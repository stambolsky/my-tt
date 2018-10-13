package ru.ql.tt;

import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.closeModalWindow;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ProfilePageTests extends TestBase {

    //Проверка перехода на страницу профиля
    @Test
    public void testMoveProfilePage() {
        //profileBase.GoToProfilePage();
        Assert.assertEquals("Профиль", TITLE_PROFILE.getText());
        Assert.assertEquals(url(), properties.getProperty("ProfilePage"));
    }

    //Проверка верстки (цвета кнопки "Сформировать резюме" и положения лого )
    @Test
    public void testProfilePage() {
        //profileBase.GoToProfilePage();
        assertTrue(profileBase.checkButtonCreateResume());
        assertEquals(BUTTON_CREATE_RESUME.getText(),"Сформировать резюме");
        assertTrue(profileBase.UserPhotoAboveResume());
    }

    //Проверка блока резюме
    @Test
    public void testProfileVisibleBlockResume() {
        //profileBase.GoToProfilePage();
        profileBase.allElementInBlock(BLOCK_RESUME, BLOCK_RESUME_TITLE, BLOCK_RESUME_BUTTON, BLOCK_RESUME_FAVICON_PLACE,
                BLOCK_RESUME_FAVICON_SHORT, BLOCK_RESUME_TEXT_PLACE, BLOCK_RESUME_TEXT_SHORT);
        assertEquals("Резюме", BLOCK_RESUME_TITLE.getText());
        assertEquals("Редактировать резюме", BLOCK_RESUME_BUTTON.getText());
    }

    //Проверка блока График работы
    @Test
    public void testProfileVisibleBlockScheduleWork() {
        //profileBase.GoToProfilePage();
        profileBase.allElementInBlock(SCHEDULE_WORK_BLOCK, SCHEDULE_WORK_BLOCK_TITLE, SCHEDULE_WORK_BUTTON_EDIT,
                SCHEDULE_WORK_TABLE, SCHEDULE_WORK_TABLE);
        assertEquals("График работы", SCHEDULE_WORK_BLOCK_TITLE.getText());
        assertEquals("Редактировать график", SCHEDULE_WORK_BUTTON_EDIT.getText());
    }

    //Проверка блока Контакты
    @Test
    public void testProfileVisibleBlockContacts() {
        //profileBase.GoToProfilePage();
        profileBase.allElementInBlock(CONTACTS_BLOCK, CONTACTS_BLOCK_TITLE, CONTACTS_BLOCK_BUTTON_EDIT);
        profileBase.getTextOfSelectOptions(CONTACTS_BLOCK_ICONS);
        profileBase.getTextOfSelectOptions(CONTACTS_BLOCK_TEXT);
        assertEquals("График работы", SCHEDULE_WORK_BLOCK_TITLE.getText());
        assertEquals("Редактировать график", SCHEDULE_WORK_BUTTON_EDIT.getText());
    }

    //Проверка блока Окружение
    @Test
    public void testProfileVisibleBlockDevices() {
        //profileBase.GoToProfilePage();
        profileBase.allElementInBlock(BLOCK_DEVICES, BLOCK_DEVICES_TITLE, BLOCK_DEVICES_BUTTON_ADD);
        profileBase.getTextOfSelectOptions(BLOCK_DEVICES_TABLE);
        assertEquals("Окружения", BLOCK_DEVICES_TITLE.getText());
        assertEquals("Добавить устройство", BLOCK_DEVICES_BUTTON_ADD.getText());
    }

    //Проверка открытия модального окна Изменение краткого резюме
    @Test
    public void testOpenedWindowShortResume() {
        //profileBase.GoToProfilePage();
        openModalWindow(BLOCK_RESUME_BUTTON, MODAL_WINDOW_EDIT_RESUME);
        assertTrue(MODAL_WINDOW_EDIT_RESUME.isDisplayed());
        assertEquals("Изменение краткого резюме сотрудника", MODAL_WINDOW_EDIT_RESUME_TITLE.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_RESUME,MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_RESUME.isDisplayed());
        refresh();
    }

    //Проверка открытия модального окна Изменение графика работ
    @Test
    public void testOpenedWindowSchduleWork() {
        //profileBase.GoToProfilePage();
        openModalWindow(SCHEDULE_WORK_BUTTON_EDIT, MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        assertTrue(MODAL_WINDOW_EDIT_SCHEDULE_WORK.isDisplayed());
        assertEquals("Изменение графика работы", MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_SCHEDULE_WORK,MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_SCHEDULE_WORK.isDisplayed());
        refresh();
    }

    //Проверка открытия модального окна Изменение контактной информации
    @Test
    public void testOpenedWindowContacts() {
        //profileBase.GoToProfilePage();
        openModalWindow(CONTACTS_BLOCK_BUTTON_EDIT, MODAL_WINDOW_EDIT_CONTACTS);
        assertTrue(MODAL_WINDOW_EDIT_CONTACTS.isDisplayed());
        assertEquals("Изменение контактной информации", TITLE_MODAL_WINDOW_EDIT_CONTACTS.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_CONTACTS,MODAL_WINDOW_EDIT_CONTACTS_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_CONTACTS.isDisplayed());
        refresh();
    }

    //Проверка открытия модального окна Добавление нового устройство
    @Test
    public void testOpenedWindowAddDevices() {
        //profileBase.GoToProfilePage();
        openModalWindow(BLOCK_DEVICES_BUTTON_ADD, MODAL_WINDOW_DEVICE);
        assertTrue(MODAL_WINDOW_DEVICE.isDisplayed());
        assertEquals("Добавление нового устройства", MODAL_WINDOW_DEVICE_TITLE.should(visible).getText());
        closeModalWindow(MODAL_WINDOW_DEVICE,MODAL_WINDOW_DEVICE_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_DEVICE.isDisplayed());
        refresh();
    }
}
