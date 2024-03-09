package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class NewTask {
    private final SelenideElement summaryField = $x("//input[@id='summary']");
    private final SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']");
    private final SelenideElement descriptionField = $x("//body[@id='tinymce']");
    private final SelenideElement create = $x("//input[@id='create-issue-submit']");
    private final SelenideElement atWork = $x("//span[text()='В работе']");
    private final SelenideElement process = $x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement done = $x("//span[text()='Выполнено']/parent::a[@role='menuitem']");

    public void taskDescription(String summary, String description) {
        summaryField.shouldBe(Condition.visible).sendKeys(summary);
        switchTo().frame(iframe);
        descriptionField.shouldBe(Condition.visible).sendKeys(description);
        switchTo().defaultContent();
        create.shouldBe(Condition.visible).click();
    }

    public void taskStatus() {
        atWork.shouldBe(Condition.visible).click();
        process.shouldBe(Condition.visible).click();
        done.shouldBe(Condition.visible).click();
    }
}
