package TestJira.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @Before
    public void initBrowser() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}