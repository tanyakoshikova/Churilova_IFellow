package TestJira.steps;

import TestJira.JiraTest;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps extends JiraTest {

    @Дано("Открыть сайт {string}")
    public void openUrl(String url) {
        open(url);
    }

    @Когда("Авторизация пользователя {string} с паролем {string}")
    public void loginTest(String login, String password) {
        loginPage.authentication(login, password);
        checkPage.waitSignIn();
    }

    @Тогда("Переход в профиль")
    public void verifierUserTest() {
        Assertions.assertTrue(checkPage.checkPage());
    }
}
