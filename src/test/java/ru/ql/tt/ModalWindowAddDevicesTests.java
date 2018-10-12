package ru.ql.tt;

import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.*;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.ProfileBase.closeModalWindow;
import static ru.ql.tt.Base.ProfileBase.openModalWindow;

public class ModalWindowAddDevicesTests extends TestBase{

    //Проверка открытия модального окна Добавление нового устройство
    @Test
    public void testOpenedWindowAddDevices() {
        profileBase.GoToProfilePage();
        openModalWindow(BLOCK_DEVICES_BUTTON_ADD, MODAL_WINDOW_DEVICE);
        assertTrue(MODAL_WINDOW_DEVICE.isDisplayed());
        assertEquals("Добавление нового устройства", MODAL_WINDOW_DEVICE_TITLE.should(visible).getText());
        closeModalWindow(MODAL_WINDOW_DEVICE,MODAL_WINDOW_DEVICE_BUTTON_CLOSE_NOT_SAVE);
        assertFalse(MODAL_WINDOW_DEVICE.isDisplayed());
    }
}
