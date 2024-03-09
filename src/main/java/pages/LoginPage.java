package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']");

    public void authentication(String username, String password) {
        loginField.shouldBe(Condition.visible).sendKeys(username);
        passwordField.shouldBe(Condition.visible).sendKeys(password, Keys.ENTER);
    }
}
