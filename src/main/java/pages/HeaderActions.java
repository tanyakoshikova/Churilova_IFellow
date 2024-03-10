package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderActions {
    private final SelenideElement goToProject = $x("//a[@id='browse_link']");
    private final SelenideElement goToProjectTest = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement createTask = $x("//a[@id='create_link']");
    private final SelenideElement tasks = $x("//a[@id='find_link']");
    private final SelenideElement reportedByMe = $x("//a[@id='filter_lnk_reported_lnk']");
    private final SelenideElement searchTask = $x("//input[@id='quickSearchInput']");

    public void selectProject() {
        goToProject.shouldBe(Condition.visible).click();
        goToProjectTest.shouldBe(Condition.visible).click();
    }

    public void createNewTask() {
        createTask.shouldBe(Condition.visible).click();
    }

    public void myTask() {
        tasks.shouldBe(Condition.visible).click();
        reportedByMe.shouldBe(Condition.visible).click();
    }

    public void searchText(String text) {
        searchTask.sendKeys(text);
        searchTask.pressEnter();
    }
}
