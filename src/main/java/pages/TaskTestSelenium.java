package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class TaskTestSelenium {
    private final SelenideElement statusVal = $x("//span[@id='status-val']/child::span");
    private final SelenideElement fixVersions = $x("//span[@id='fixVersions-field']/child::a");

    public List<String> checkStatusAndVersion() {
        String statusText = statusVal.shouldBe(Condition.visible).getText();
        String fixVersionsText = fixVersions.shouldBe(Condition.visible).getText();
        return List.of(statusText, fixVersionsText);
    }
}