package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class NewTask {
    private final SelenideElement summaryField = $x("//input[@id='summary']").as("Поле ввода темы задачи");
    private final SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']").as("Переход в iframe");
    private final SelenideElement descriptionField = $x("//body[@id='tinymce']").as("Поле ввода описания задачи");
    private final SelenideElement create = $x("//input[@id='create-issue-submit']").as("Кнопка Создать");
    private final SelenideElement atWork = $x("//span[text()='В работе']").as("Статус В работе");
    private final SelenideElement process = $x("//a[@id='opsbar-transitions_more']").as("Выбор статуса Бизнес-процесс");
    private final SelenideElement done = $x("//span[text()='Выполнено']/parent::a[@role='menuitem']").as("Статус Выполнено");

    @Step("Заполнение основных полей и создание бага")
    public void taskDescription(String summary, String description) {
        summaryField.shouldBe(Condition.visible).sendKeys(summary);
        switchTo().frame(iframe);
        descriptionField.shouldBe(Condition.visible).sendKeys(description);
        switchTo().defaultContent();
        create.shouldBe(Condition.visible).click();
    }

    @Step("Изменение статуса задачи")
    public void taskStatus() {
        atWork.shouldBe(Condition.visible).click();
        process.shouldBe(Condition.visible).click();
        done.shouldBe(Condition.visible).click();
    }
}
