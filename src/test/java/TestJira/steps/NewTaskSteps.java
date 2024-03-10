package TestJira.steps;

import TestJira.JiraTest;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class NewTaskSteps extends JiraTest {

    @Также("Создание новой задачи и изменение статуса")
    public void createNewTaskTest() {
        headerActions.createNewTask();
        newTask.taskDescription(SUMMARY, DESCRIPTION);
        headerActions.myTask();
        newTask.taskStatus();
    }

    @Тогда("Проверка статуса {string}")
    public void statusTaskTest() {
        String statusTaskDone = newTask.statusTask();
        Assertions.assertEquals("ГОТОВО", statusTaskDone);
    }
}
