package TestJira;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SidebarAction {
    private final ChromeDriver chromeDriver;
    public SidebarAction (ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    @Test
    public void sidebarTask() throws InterruptedException {
        Thread.sleep(1000);
        WebElement goToTasks = this.chromeDriver.findElement(By.xpath("//span[@class=\"aui-icon aui-icon-large icon-sidebar-issues aui-iconfont-issues\"]"));
        goToTasks.click();
    }
    @Test
    public void sidebarTaskList() throws InterruptedException {
        Thread.sleep(1000);
        WebElement goToTasksList = chromeDriver.findElement(By.xpath(" //span[@class=\"aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog\"]"));
        goToTasksList.click();
    }
    @Test
    public void sidebarTasks() throws InterruptedException {
        Thread.sleep(1000);
        WebElement allTasks = chromeDriver.findElement(By.xpath("//span[@class=\"aui-icon aui-icon-large icon-sidebar-issues aui-iconfont-issues\"]"));
        allTasks.click();
    }
}
