package ru.ql.tt;

import org.junit.Test;

import static org.testng.Assert.*;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.closeModalWindow;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ModalWindowScheduleWorkTests extends TestBase{

    //Проверка открытия модального окна Изменение графика работ
    @Test
    public void testOpenedWindowSchduleWork() {
        profileBase.GoToProfilePage();
        openModalWindow(SCHEDULE_WORK_BUTTON_EDIT, MODAL_WINDOW_EDIT_SCHEDULE_WORK);
        assertTrue(MODAL_WINDOW_EDIT_SCHEDULE_WORK.isDisplayed());
        assertEquals("Изменение графика работы", MODAL_WINDOW_EDIT_TITLE_SCHEDULE_WORK.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_SCHEDULE_WORK,MODAL_SCHEDULE_WORK_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_SCHEDULE_WORK.isDisplayed());
    }
}
