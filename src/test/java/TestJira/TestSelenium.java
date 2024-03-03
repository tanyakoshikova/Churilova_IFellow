package TestJira;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    private final ChromeDriver chromeDriver;
    public TestSelenium (ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    @Test
    public void testSelenium() throws InterruptedException {
        Thread.sleep(1000);
        WebElement testSeleniumTask = chromeDriver.findElement(By.xpath("//span[text()='TestSelenium']"));
        testSeleniumTask.click();

        Thread.sleep(1000);
        WebElement taskStatus = chromeDriver.findElement(By.xpath("//span[@class=\" jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium\"]"));
        String status = taskStatus.getText();
        System.out.println("Статус задачи: " + status);

        Thread.sleep(1000);
        WebElement fixInVersion = chromeDriver.findElement(By.xpath("//span[@class=\"shorten\"]"));
        String version = fixInVersion.getText();
        System.out.println("Исправить в версиях: " + version);
    }
}
