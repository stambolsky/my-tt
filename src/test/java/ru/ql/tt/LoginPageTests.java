package ru.ql.tt;

import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;


public class LoginPageTests extends TestBase{

    //Авторизация и проверка что пользователь вошел в ТТ
    @Test
    public void testLoginPage() {
        AVATARCOVER.should(visible).click();
        assertTrue(AVATAR_NAME.getText().equalsIgnoreCase(properties.getProperty("login")));
    }

    //Проверка перехода на страницу профиля
    @Test
    public void testMoveProfilePage() {
        profileBase.GoToProfilePage();
        assertEquals("Профиль", TITLE_PROFILE.getText());
        assertEquals(url(), properties.getProperty("ProfilePage"));
    }

}
