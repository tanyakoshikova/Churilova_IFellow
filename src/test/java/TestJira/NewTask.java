package TestJira;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTask {
    private final ChromeDriver chromeDriver;
    public NewTask(ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    @Test
    public void newTask() throws InterruptedException{
     Thread.sleep(1000);
    WebElement summary = chromeDriver.findElement(By.id("summary"));
        summary.sendKeys("Некорректное отображение имени пользователя в профиле.");

        Thread.sleep(1000);
        chromeDriver.switchTo().frame("mce_0_ifr");
    WebElement description = chromeDriver.findElement(By.cssSelector("[data-mce-bogus='1']"));
        description.sendKeys("1.Зайти в аккаунт пользователя;\n" +
                "2.Перейти на страницу профиля;\n" +
                "3.Обратить внимание на поле “Имя пользователя”;\n" +
                "4.Отметить, что вместо имени отображаются случайные символы.");
        chromeDriver.switchTo().defaultContent();

        Thread.sleep(1000);
        WebElement create = chromeDriver.findElement(By.id("create-issue-submit"));
        create.click();
    }
    @Test
    public void taskStatus() throws InterruptedException{
        Thread.sleep(3000);
        WebElement lookStatus = chromeDriver.findElement(By.xpath("//a[@class=\"issueaction-viewworkflow jira-workflow-designer-link\"]"));
        lookStatus.click();

        Thread.sleep(1000);
        WebElement atWork = chromeDriver.findElement(By.xpath("//span[text()='В работе']"));
        atWork.click();

        Thread.sleep(1000);
        WebElement process = chromeDriver.findElement(By.xpath("//span[text()='Бизнес-процесс']"));
        process.click();

        Thread.sleep(1000);
        WebElement done = chromeDriver.findElement(By.xpath("//span[text()='Выполнено']"));
        done.click();
    }
}
