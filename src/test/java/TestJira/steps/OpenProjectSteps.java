package TestJira.steps;

import TestJira.JiraTest;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class OpenProjectSteps extends JiraTest{

    @Когда("Авторизуемся как пользователь {string} с паролем {string}")
    public void loginTest(String login, String password) {
        loginPage.authentication(login, password);
        checkPage.waitSignIn();
    }

    @Также("Переход в проект Test")
    public void headerTest(){
        headerActions.selectProject();
    }

    @Тогда("Отображаются задачи")
    public void openTasksTest() {
        Assertions.assertTrue(checkPage.openTasks("Открытые задачи"));
    }
}