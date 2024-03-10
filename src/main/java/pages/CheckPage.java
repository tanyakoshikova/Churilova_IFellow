package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckPage {

    private final SelenideElement userFullname = $x("//a[@id='header-details-user-fullname']");
    private final SelenideElement subnavigationTitle = $x("//h1/span[@id='issues-subnavigation-title']");

    public Boolean checkPage() {
        waitSignIn();
        return userFullname.isDisplayed();
    }

    public Boolean openTasks(String title) {
        return subnavigationTitle.getText().equals(title);
    }

    public void waitSignIn() {
        userFullname.shouldBe(Condition.visible);
    }
}
