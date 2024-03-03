package TestJira;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Authentication {
    private final ChromeDriver chromeDriver;
    public Authentication(ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    public void authentication(String username, String password){
        WebElement loginField = chromeDriver.findElement(By.id("login-form-username"));
        WebElement passwordField = chromeDriver.findElement(By.id("login-form-password"));
        loginField.sendKeys(username);
        passwordField.sendKeys(password, Keys.ENTER);
    }
}

