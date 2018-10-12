package ru.ql.tt;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import ru.ql.tt.Base.ProfileBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static ru.ql.tt.Base.CssLocators.*;

public class TestBase {

    static final Properties properties = new Properties();
    static final ProfileBase profileBase = new ProfileBase();

    @BeforeClass
    public static void setup() throws Exception {
        init();
        login();
    }

    private static void init() throws Exception {
        properties.load(new FileReader(new File("src/test/resources/authorization.properties")));
        properties.load(new FileReader(new File("src/test/resources/URL.properties")));
        setDriver(properties.getProperty("browser"));
        open(properties.getProperty("LoginPage"));
    }


    private static void setDriver(String browser) throws Exception {
        System.out.println("browser: " + browser);
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "safari":
                Configuration.browser = "safari";
                break;
            case "ie":
                Configuration.browser = "ie";
                break;
            default:
                throw new Exception("Incorrect parameter: browser = '" + browser + "'");
        }
        Configuration.timeout = 5000;
    }

    public static void login() throws IOException {
        assertTrue(LOGIN.isDisplayed());
        assertTrue(PASSWORD.should(visible).isDisplayed());
        assertTrue(SUBMIT.should(visible).isDisplayed());
        LOGIN.sendKeys(properties.getProperty("login"));
        PASSWORD.sendKeys(properties.getProperty("password"));
        SUBMIT.click();
    }

}





