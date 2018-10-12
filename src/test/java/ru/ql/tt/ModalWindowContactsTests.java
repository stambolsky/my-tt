package ru.ql.tt;

import org.junit.Test;

import static org.testng.Assert.*;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.closeModalWindow;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ModalWindowContactsTests extends TestBase{

    //Проверка открытия модального окна Изменение контактной информации
    @Test
    public void testOpenedWindowContacts() {
        profileBase.GoToProfilePage();
        openModalWindow(CONTACTS_BLOCK_BUTTON_EDIT, MODAL_WINDOW_EDIT_CONTACTS);
        assertTrue(MODAL_WINDOW_EDIT_CONTACTS.isDisplayed());
        assertEquals("Изменение контактной информации", TITLE_MODAL_WINDOW_EDIT_CONTACTS.getText());
        closeModalWindow(MODAL_WINDOW_EDIT_CONTACTS,MODAL_WINDOW_EDIT_CONTACTS_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_EDIT_CONTACTS.isDisplayed());
    }
}
