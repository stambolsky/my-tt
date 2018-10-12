package ru.ql.tt;

import org.junit.Test;

import static org.testng.Assert.*;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.closeModalWindow;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ModalWindowResumeTests extends TestBase{

    //Проверка открытия модального окна Изменение краткого резюме
    @Test
    public void testOpenedWindowShortResume() {
        profileBase.GoToProfilePage();
        openModalWindow(BLOCK_RESUME_BUTTON, MODAL_WINDOW_EDIT_RESUME);
        assertTrue(MODAL_WINDOW_EDIT_RESUME.isDisplayed());
        assertEquals("Изменение краткого резюме сотрудника", MODAL_WINDOW_EDIT_RESUME_TITLE.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_RESUME,MODAL_RESUME_EDIT_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_RESUME.isDisplayed());
    }
}
