package ru.ql.tt;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;

public class ProfilePageTests extends TestBase {

    //Проверка верстки (цвета кнопки "Сформировать резюме" и положения лого )
    @Test
    public void testProfilePage() {
        assertTrue(profileBase.checkButtonCreateResume());
        Assertions.assertEquals(BUTTON_CREATE_RESUME.getText(),"Сформировать резюме");
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
}
