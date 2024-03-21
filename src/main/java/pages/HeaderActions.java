package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderActions {
    private final SelenideElement goToProject = $x("//a[@id='browse_link']").as("Кнопка проекты");
    private final SelenideElement goToProjectTest = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка Test(TEST)");
    private final SelenideElement profileItem = $x("//a[@id='header-details-user-fullname']").as("Иконка профиля пользователя");
    private final SelenideElement createTask = $x("//a[@id='create_link']").as("Кнопка Создать");
    private final SelenideElement tasks = $x("//a[@id='find_link']").as("Кнопка Задачи");
    private final SelenideElement reportedByMe = $x("//a[@id='filter_lnk_reported_lnk']").as("Переход в задачи Сообщенные мной");
    private final SelenideElement searchTask = $x("//input[@id='quickSearchInput']").as("Строка поиска");

    @Step("Переход в проект \"test\"")
    public void selectProject() {
        goToProject.shouldBe(Condition.visible).click();
        goToProjectTest.shouldBe(Condition.visible).click();
    }

    @Step("Переход в профиль пользователя")
    public void signIn() {
        profileItem.shouldBe(Condition.visible);
    }

    @Step("Клик на кнопку создать проект")
    public void createNewTask() {
        createTask.shouldBe(Condition.visible).click();
    }

    @Step("Переход к задачам сообщенным мной")
    public void myTask() {
        tasks.shouldBe(Condition.visible).click();
        reportedByMe.shouldBe(Condition.visible).click();
    }

    @Step("Ввод названия задачи \"TestSelenium\" в поле поиска")
    public void searchText(String text) {
        searchTask.sendKeys(text);
        searchTask.pressEnter();
    }
}
