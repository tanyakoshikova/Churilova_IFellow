package TestJira;

import pages.*;

public class JiraTest {
    public static final LoginPage loginPage = new LoginPage();
    public static final CheckPage checkPage = new CheckPage();
    public static final HeaderActions headerActions = new HeaderActions();
    public static final TaskTestSelenium taskTestSelenium = new TaskTestSelenium();
    public static final NewTask newTask = new NewTask();
    public static final String SUMMARY = "Некорректное отображение имени пользователя в профиле.";
    public static final String DESCRIPTION = "1.Зайти в аккаунт пользователя; 2.Перейти на страницу профиля; 3.Отметить, что вместо имени отображаются случайные символы.";

}