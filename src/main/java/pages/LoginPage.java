package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $x("//input[@id='login-form-username']").as("Поле ввода логина пользователя");
    private final SelenideElement passwordField = $x("//input[@id='login-form-password']").as("Поле ввода пароля пользователя");

    @Step("Аутентификация пользователя")
    public void authentication(String username, String password) {
        loginField.shouldBe(Condition.visible).sendKeys(username);
        passwordField.shouldBe(Condition.visible).sendKeys(password, Keys.ENTER);
    }
}
