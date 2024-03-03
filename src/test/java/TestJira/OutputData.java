package TestJira;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OutputData {
    private final ChromeDriver chromeDriver;
    public OutputData (ChromeDriver driver) {
        this.chromeDriver = driver;
    }
    public Object outputData() throws InterruptedException {
        Thread.sleep(1000);
        WebElement showing = chromeDriver.findElement(By.xpath("//div[@class=\"showing\"]"));
        String strNumber = showing.getText();
        String cleanedText = strNumber.replaceAll("[^0-9]", " ");
        String[] words = cleanedText.split(" ");
        String firstValue = words[words.length - 1];
        System.out.println("Количество задач всего: " + firstValue);
        return firstValue;
    }

    public void outputNewData(Object firstValue) throws InterruptedException {
        Thread.sleep(1000);
        WebElement showing = chromeDriver.findElement(By.xpath("//div[@class=\"showing\"]"));
        String strNumber = showing.getText();
        String cleanedText = strNumber.replaceAll("[^0-9]", " ");
        String[] words = cleanedText.split(" ");
        String secondValue = words[words.length - 1];
        System.out.println("Количество задач после создания бага: " + secondValue);

        Boolean isComparisonTrue = (Boolean) ((JavascriptExecutor) chromeDriver)
                .executeScript("return arguments[0] >= arguments[1];", firstValue, secondValue);
        if (isComparisonTrue) {
            System.out.println("Новых задач не создано");
        } else {
            System.out.println("Созданы новые задачи");
        }
    }
}
