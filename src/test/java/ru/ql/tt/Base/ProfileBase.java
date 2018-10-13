package ru.ql.tt.Base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
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

}
