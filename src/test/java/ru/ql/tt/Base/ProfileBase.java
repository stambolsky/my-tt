package ru.ql.tt.Base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;
import static ru.ql.tt.Base.CssLocators.BLOCK_RESUME;

public class ProfileBase {

    //Переход на страницу Профиля
    public void GoToProfilePage() {
        //AVATARCOVER.should(appear).click();
        LINK_PROFILE.should(visible).click();
    }

    //Проверяю цвет кнопки Сформировать Резюме
    public boolean checkButtonCreateResume() {
        boolean res = true;
        String color = BUTTON_CREATE_RESUME.getCssValue("background-color");
        String hexColor = Color.fromString(color).asHex();
        if (!hexColor.equals("#716aca")) {
            res = false;
        }
        return res;
    }

    //Проверяю положение Логотипа и блока резюме
    public boolean UserPhotoAboveResume() {
        boolean res = true;
        int firstElement = AVATAR.getLocation().getX();
        int secondElement = BLOCK_RESUME.getLocation().getY();
        if (firstElement - secondElement > 0) {
            res = false;
        }
        return res;
    }

    public static List getTextOfSelectOptions(ElementsCollection selectOptions) {
        List<String> result = new LinkedList<String>();
        List<String> texts = selectOptions.texts();
        for (String text : texts) {
            result.add(text.trim());
        }
        return result;
    }

    public boolean allElementInBlock(SelenideElement... elements) {
        return listElements(elements).size() == elements.length;
    }

    private Collection listElements(SelenideElement... elements) {
        List<SelenideElement> listOfElements = new LinkedList<>();
        for (SelenideElement element : elements) {
            if (element.isDisplayed()) {
                listOfElements.add(element);
            } else {
                System.out.println("Element is not displayed:" + element);
            }
        }
        return listOfElements;
    }

    //открываю модальное окно
    public static void openModalWindow(SelenideElement button, SelenideElement window) {
        button.waitUntil(appear, 4000).click();
        window.waitUntil(visible, 4000);
    }

    //закрываю модальное окно
    public static void closeModalWindow(SelenideElement window, SelenideElement button) {
        button.waitUntil(appear, 4000).click();
        button.waitUntil(appear, 4000).click();
        window.waitUntil(disappear, 4000);
    }

    public String getPopupWindowText(SelenideElement element) {
        return getElementValue(element);
    }

    public static String getElementValue(SelenideElement element) {
        return element.should(appear).getText();
    }


    public void waitElement(SelenideElement element) {
        element.waitUntil(exist, 5000);
    }

    public void enterFieldText(SelenideElement field, String text) {
        field.should(appear).clear();
        field.sendKeys(text);
    }

    public void changeTimeScheduleWork() {
        MODAL_WINDOW_EDIT_START_TIME_SCHEDULE_WORK.should(exist).click();
        MODAL_WINDOW_EDIT_TIME_HOUR_UP.should(exist).click();
        MODAL_WINDOW_EDIT_TIME_MINUTE_UP.should(exist).click();
        MODAL_WINDOW_EDIT_END_TIME_SCHEDULE_WORK.should(exist).click();
        MODAL_WINDOW_EDIT_TIME_HOUR_UP.should(exist).click();
        MODAL_WINDOW_EDIT_TIME_MINUTE_UP.should(exist).click();
    }

    public void addDevice(int type, int typeOs, String versionOs) {
        openModalWindow(BLOCK_DEVICES_BUTTON_ADD, MODAL_WINDOW_DEVICE);
        assertTrue(MODAL_WINDOW_DEVICE.isDisplayed());
        assertEquals("Добавление нового устройства", MODAL_WINDOW_DEVICE_TITLE.should(visible).getText());
        TYPE_PC.selectOption(type);
        EDIT_WINDOW_OS.selectOption(typeOs);
        enterFieldText(TYPE_OS, versionOs);
        BUTTON_DEVICE_SAVE.shouldBe(appear).click();
    }

    public void deleteDevice() {
        TABLE_ICON_TRASH.shouldBe(appear).click();
        EDIT_WINDOW.waitUntil(visible, 3000);
        assertEquals("Удаление устройства", EDIT_WINDOW_TITLE.getText());
        BUTTON_DELETE_DEVICE.shouldBe(appear).click();
        //assertEquals("Устройство удалено", getPopupWindowText(POPUP_WINDOWS));
    }

    public void switchWindow(String idWindow) {
        Set<String> idOpeningWindows = getWebDriver().getWindowHandles();
        for (String tab : idOpeningWindows) {
            if (!tab.equals(idWindow)) {
                switchTo().window(tab);
                break;
            }
        }
    }

}
