package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class TaskTestSelenium {
    private final SelenideElement statusVal = $x("//span[@id='status-val']/child::span").as("Статус задачи");
    private final SelenideElement fixVersions = $x("//span[@id='fixVersions-field']/child::a").as("Исправить в версиях");

    @Step("Просмотр статуса и версии в задаче TestSelenium")
    public List<String> checkStatusAndVersion() {
        String statusText = statusVal.shouldBe(Condition.visible).getText();
        String fixVersionsText = fixVersions.shouldBe(Condition.visible).getText();
        return List.of(statusText, fixVersionsText);
    }
}