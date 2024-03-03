package TestJira;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderActions {
    private final ChromeDriver chromeDriver;
    public HeaderActions (ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    @Test
    public void headerActions() throws InterruptedException {
        Thread.sleep(1000);
        WebElement goToProject = chromeDriver.findElement(By.id("browse_link"));
        goToProject.click();

        Thread.sleep(1000);
        WebElement goToProjectTest = chromeDriver.findElement(By.id("admin_main_proj_link_lnk"));
        goToProjectTest.click();
    }

    @Test
    public void createNewTask() throws InterruptedException {
        Thread.sleep(1000);
        WebElement newTask = chromeDriver.findElement(By.id("create_link"));
        newTask.click();
    }
}
