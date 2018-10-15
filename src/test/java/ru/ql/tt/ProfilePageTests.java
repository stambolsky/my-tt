package ru.ql.tt;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ProfilePageTests extends TestBase {

    //Проверка перехода на страницу профиля
    @Test
    public void testMoveProfilePage() {
        Assert.assertEquals("Профиль", TITLE_PROFILE.getText());
        Assert.assertEquals(url(), properties.getProperty("ProfilePage"));
    }

    //Проверка верстки (цвета кнопки "Сформировать резюме" и положения лого )
    @Test
    public void testProfilePage() {
        assertTrue(profileBase.checkButtonCreateResume());
        assertEquals(BUTTON_CREATE_RESUME.getText(),"Сформировать резюме");
        assertTrue(profileBase.UserPhotoAboveResume());
    }

    //Проверка блока резюме
    @Test
    public void testProfileVisibleBlockResume() {
        profileBase.allElementInBlock(BLOCK_RESUME, BLOCK_RESUME_TITLE, BLOCK_RESUME_BUTTON, BLOCK_RESUME_FAVICON_PLACE,
                BLOCK_RESUME_FAVICON_SHORT, BLOCK_RESUME_TEXT_PLACE, BLOCK_RESUME_TEXT_SHORT);
        assertEquals("Резюме", BLOCK_RESUME_TITLE.getText());
        assertEquals("Редактировать резюме", BLOCK_RESUME_BUTTON.getText());
    }

    //Проверка блока График работы
    @Test
    public void testProfileVisibleBlockScheduleWork() {
        profileBase.allElementInBlock(SCHEDULE_WORK_BLOCK, SCHEDULE_WORK_BLOCK_TITLE, SCHEDULE_WORK_BUTTON_EDIT,
                SCHEDULE_WORK_TABLE, SCHEDULE_WORK_TABLE);
        assertEquals("График работы", SCHEDULE_WORK_BLOCK_TITLE.getText());
        assertEquals("Редактировать график", SCHEDULE_WORK_BUTTON_EDIT.getText());
    }

    //Проверка блока Контакты
    @Test
    public void testProfileVisibleBlockContacts() {
        profileBase.allElementInBlock(CONTACTS_BLOCK, CONTACTS_BLOCK_TITLE, CONTACTS_BLOCK_BUTTON_EDIT);
        profileBase.getTextOfSelectOptions(CONTACTS_BLOCK_ICONS);
        profileBase.getTextOfSelectOptions(CONTACTS_BLOCK_TEXT);
        assertEquals("График работы", SCHEDULE_WORK_BLOCK_TITLE.getText());
        assertEquals("Редактировать график", SCHEDULE_WORK_BUTTON_EDIT.getText());
    }

    //Проверка блока Окружение
    @Test
    public void testProfileVisibleBlockDevices() {
        profileBase.allElementInBlock(BLOCK_DEVICES, BLOCK_DEVICES_TITLE, BLOCK_DEVICES_BUTTON_ADD);
        profileBase.getTextOfSelectOptions(BLOCK_DEVICES_TABLE);
        assertEquals("Окружения", BLOCK_DEVICES_TITLE.getText());
        assertEquals("Добавить устройство", BLOCK_DEVICES_BUTTON_ADD.getText());
    }

    //Проверка открытия модального окна Изменение краткого резюме
    //Проверка сохранения информации
    @Test
    public void testOpenedWindowShortResume() {
        openModalWindow(BLOCK_RESUME_BUTTON, MODAL_WINDOW_EDIT_RESUME);
        assertTrue(MODAL_WINDOW_EDIT_RESUME.isDisplayed());
        assertEquals("Изменение краткого резюме сотрудника", MODAL_WINDOW_EDIT_RESUME_TITLE.getText());
        profileBase.enterFieldText(MODAL_WINDOW_EDIT_TEXTAREA, "Test Test Test");
        MODAL_WINDOW_EDIT_TIP_TEXTAREA.click();
        assertEquals(MODAL_WINDOW_EDIT_TIP_TEXTAREA.getText(), "Опишите себя в 2-3 предложениях (когда начался и как развивался путь в тестировании, что вы умеете делать круче других, какие ваши сильные стороны, что считаете самым главным в работе).");
        MODAL_WINDOW_EDIT_BUTTON_SAVE.should(appear).click();
        profileBase.waitElement(BLOCK_RESUME_TEXT_SHORT);
        assertEquals(BLOCK_RESUME_TEXT_SHORT.getText(),"Test Test Test");
    }

    //Проверка того, что информация в модальном окне Изменение краткого резюме сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testShortResumeButtonCloseNotSave() {
        openModalWindow(BLOCK_RESUME_BUTTON, MODAL_WINDOW_EDIT_RESUME);
        profileBase.enterFieldText(MODAL_WINDOW_EDIT_TEXTAREA, "Закрыть без сохранения");
        MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE.shouldBe(appear).click();
        assertFalse(BLOCK_RESUME_TEXT_SHORT.getText().equals("Закрыть без сохранения"));
    }

    //Проверка того, что информация в модальном окне Изменение краткого резюме сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “крестик”.
    @Test
    public void testShortResumeIconCross() {
        openModalWindow(BLOCK_RESUME_BUTTON, MODAL_WINDOW_EDIT_RESUME);
        profileBase.enterFieldText(MODAL_WINDOW_EDIT_TEXTAREA, "Закрыть без сохранения");
        MODAL_RESUME_EDIT_ICON_CROSS.shouldBe(appear).click();
        assertFalse(BLOCK_RESUME_TEXT_SHORT.getText().equals("Закрыть без сохранения"));
    }

    //Проверка открытия модального окна Изменение графика работ
    //Проверка сохранения информации
    @Test
    public void testOpenedWindowSchduleWork() {
        openModalWindow(SCHEDULE_WORK_BUTTON_EDIT, MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        assertTrue(MODAL_WINDOW_EDIT_SCHEDULE_WORK.isDisplayed());
        assertEquals("Изменение графика работы", MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK.getText());
        profileBase.changeTimeScheduleWork();
        String beforeStart = MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK.getValue();
        String beforeEnd = MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK.getValue();
        String before = beforeStart + " - " + beforeEnd;
        MODAL_WINDOW_EDIT_BUTTON_SAVE_SCHEDULE_WORK.click();
        MODAL_WINDOW_EDIT_SCHEDULE_WORK.should(disappear);
        assertEquals(PROFILE_TABLE_TIME_MONDAY.getText(),before);
    }

    //Проверка того, что информация в модальном окне Изменение графика работ сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testSchedulWorkButtonCloseNotSave() {
        openModalWindow(SCHEDULE_WORK_BUTTON_EDIT, MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        profileBase.changeTimeScheduleWork();
        String beforeStart = MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK.getValue();
        String beforeEnd = MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK.getValue();
        String before = beforeStart + " - " + beforeEnd;
        MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE.click();
        assertFalse(PROFILE_TABLE_TIME_MONDAY.getText().equals(before));
    }

    //Проверка того, что информация в модальном окне Изменение графика работ сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “Крестик”.
    @Test
    public void testSchedulWorkIconCross() {
        openModalWindow(SCHEDULE_WORK_BUTTON_EDIT, MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        profileBase.changeTimeScheduleWork();
        String beforeStart = MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK.getValue();
        String beforeEnd = MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK.getValue();
        String before = beforeStart + " - " + beforeEnd;
        MODAL_WINDOW_EDIT_ICON_CROSS.click();
        assertFalse(PROFILE_TABLE_TIME_MONDAY.getText().equals(before));
    }

    //Проверка открытия модального окна Изменение контактной информации
    //Проверка сохранения информации
    @Test
    public void testOpenedWindowContacts() {
        openModalWindow(CONTACTS_BLOCK_BUTTON_EDIT, MODAL_WINDOW_EDIT_CONTACTS);
        assertTrue(MODAL_WINDOW_EDIT_CONTACTS.isDisplayed());
        assertEquals("Изменение контактной информации", TITLE_MODAL_WINDOW_EDIT_CONTACTS.getText());
        profileBase.enterFieldText(MODAL_EDIT_PHONE_FIELD.shouldBe(appear), "12345");
        profileBase.enterFieldText(MODAL_EDIT_SKYPE_FIELD.shouldBe(appear), "MY_SKYPE");
        MODAL_EDIT_SAVE_BUTTON.click();
        MODAL_WINDOW_EDIT_CONTACTS.should(disappear);
        assertEquals(PROFILE_CONTACTS_FIELD_SKYPE.shouldBe(appear).getText(), "MY_SKYPE");
        assertEquals(PROFILE_CONTACTS_FIELD_PHONE.shouldBe(appear).getText(), "12345");
    }

    //Проверка того, что информация в модальном окне Изменение контактной информации сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testContactsButtonCloseNotSave() {
        openModalWindow(CONTACTS_BLOCK_BUTTON_EDIT, MODAL_WINDOW_EDIT_CONTACTS);
        profileBase.enterFieldText(MODAL_EDIT_PHONE_FIELD.shouldBe(appear), "000000");
        profileBase.enterFieldText(MODAL_EDIT_SKYPE_FIELD.shouldBe(appear), "Test");
        MODAL_EDIT_BUTTON_CLOSE_NOT_SAVE.click();
        assertFalse(PROFILE_CONTACTS_FIELD_SKYPE.shouldBe(appear).getText().equals("000000"));
        assertFalse(PROFILE_CONTACTS_FIELD_SKYPE.shouldBe(appear).getText().equals("Test"));
    }

    //Проверка того, что информация в модальном окне Изменение контактной информации сотрудника не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testContactsIconCross() {
        openModalWindow(CONTACTS_BLOCK_BUTTON_EDIT, MODAL_WINDOW_EDIT_CONTACTS);
        profileBase.enterFieldText(MODAL_EDIT_PHONE_FIELD.shouldBe(appear), "000000");
        profileBase.enterFieldText(MODAL_EDIT_SKYPE_FIELD.shouldBe(appear), "Test");
        MODAL_EDIT_ICON_CROSS.click();
        assertFalse(PROFILE_CONTACTS_FIELD_SKYPE.shouldBe(appear).getText().equals("000000"));
        assertFalse(PROFILE_CONTACTS_FIELD_SKYPE.shouldBe(appear).getText().equals("Test"));
    }

    //Проверка открытия модального окна Добавление нового устройство
    //Проверка сохранения информации
    @Test
    public void testOpenedWindowAddDevices() {
        profileBase.addDevice(4, 5, "Test OS");
        profileBase.checkPopUpWindows();
        profileBase.deleteDevice();
    }

    //Проверка того, что информация в модальном окне Добавление нового устройство не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testAddDevicesButtonCloseNotSave() {
        profileBase.addDevice(4, 5, "Test OS");
        TABLE_ICON_EDIT.shouldBe(appear).click();
        profileBase.enterFieldText(EDIT_WINDOW_VERSION_OS, "Test Test Test");
        EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE.shouldHave(appear).click();
        EDIT_WINDOW_BUTTON_CLOSE_NOT_SAVE.shouldHave(appear).click();
        assertFalse(TABLE_FIELD_OS.getText().equals("Test Test Test"));
        profileBase.deleteDevice();
    }

    //Проверка того, что информация в модальном окне Добавление нового устройство не сохраняется при закрытии
    //окна при нажатии кнопки “Закрыть без сохранения”.
    @Test
    public void testAddDevicesIconCross() {
        profileBase.addDevice(4, 5, "Test OS");
        TABLE_ICON_EDIT.shouldBe(appear).click();
        profileBase.enterFieldText(EDIT_WINDOW_VERSION_OS, "Test Test Test");
        EDIT_WINDOW_ICON_CROSS.shouldBe(appear).click();
        EDIT_WINDOW_ICON_CROSS.shouldBe(appear).click();
        assertFalse(TABLE_FIELD_OS.getText().equals("Test Test Test"));
        profileBase.deleteDevice();
    }

    //Проверка того, что при нажатии на кнопку “Сформировать резюме” в новой вкладке открывается превью резюме.
    @Test
    public void testOpenNewTabCreateResume() {
        BUTTON_CREATE_RESUME.shouldBe(exist).click();
        String idWindow = getWebDriver().getWindowHandle();
        profileBase.switchWindow(idWindow);
        String titleNewWindows = getWebDriver().getTitle();
        assertEquals(titleNewWindows, "Первая страница");
        String firstname = WINDOW_RESUME_FIRST_NAME.getText();
        String lastname = WINDOW_RESUME_LAST_NAME.getText();
        String name = lastname + " " + firstname;
        String place = WINDOW_RESUME_PLACE.should(appear).getText();
        getWebDriver().close();
        switchTo().window(idWindow);
        assertTrue(FIRST_AND_LAST_NAME.should(appear).getText().equalsIgnoreCase(name));
        assertTrue(PROFILE_RESUME_FIELD_PLACE.should(appear).getText().equalsIgnoreCase(place));
    }






}
