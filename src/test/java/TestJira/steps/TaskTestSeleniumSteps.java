package TestJira.steps;

import TestJira.JiraTest;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class TaskTestSeleniumSteps extends JiraTest {

    @Также("Переход в задачу TestSelenium")
    public void SeleniunTest() {
        headerActions.searchText("TestSelenium");
    }

    @Тогда("Отображение статуса задачи \"ГОТОВО\" и версии \"Version 2.0\"")
    public void checkStatusTestSelenium() {
        List<String> projectStatus = taskTestSelenium.checkStatusAndVersion();
        Assertions.assertEquals("ГОТОВО", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }
}