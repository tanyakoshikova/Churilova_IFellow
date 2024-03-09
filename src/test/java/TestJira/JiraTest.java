package TestJira;

import config.WebHooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.List;

public class JiraTest extends WebHooks {
    public static final LoginPage loginPage = new LoginPage();
    public static final HeaderActions headerActions = new HeaderActions();
    public static final TaskTestSelenium taskTestSelenium = new TaskTestSelenium();
    public static final NewTask newTask = new NewTask();
    public static final String LOGIN = "AT14";
    public static final String PASSWORD = "Qwerty123";
    public static final String SUMMARY = "Некорректное отображение имени пользователя в профиле.";
    public static final String DESCRIPTION = "1.Зайти в аккаунт пользователя; 2.Перейти на страницу профиля; 3.Отметить, что вместо имени отображаются случайные символы.";

    @Test
    @DisplayName("Авторизация")
    public void loginTest() {
        loginPage.authentication(LOGIN, PASSWORD);
    }

    @Test
    @DisplayName("Переход в проект Test")
    public void headerTest() {
        loginPage.authentication(LOGIN, PASSWORD);
        headerActions.selectProject();
    }

    @Test
    @DisplayName("Проверка полей задачи TestSelenium")
    public void SeleniunTest() {
        loginPage.authentication(LOGIN, PASSWORD);
        headerActions.signIn();
        headerActions.searchText("TestSelenium");
        List<String> projectStatus = taskTestSelenium.checkStatusAndVersion();
        Assertions.assertEquals("ГОТОВО", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @Test
    @DisplayName("Создание задачи и изменение статуса")
    public void createNewTaskTest() {
        loginPage.authentication(LOGIN, PASSWORD);
        headerActions.createNewTask();
        newTask.taskDescription(SUMMARY, DESCRIPTION);
        headerActions.myTask();
        newTask.taskStatus();
    }
}