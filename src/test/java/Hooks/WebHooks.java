package Hooks;

import TestJira.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class WebHooks {
    private static final ChromeDriver chromeDriver = new ChromeDriver();

    @BeforeSuite
    public void atFirstTest() throws InterruptedException {
        WebDriver.Options options = chromeDriver.manage();
        WebDriver.Window window = options.window();
        window.maximize();
        chromeDriver.get("https://edujira.ifellow.ru/");

        Authentication authenticationSteps = new Authentication(chromeDriver);
        authenticationSteps.authentication("AT14","Qwerty123");

        HeaderActions headerActions = new HeaderActions(chromeDriver);
        headerActions.headerActions();

        SidebarAction sidebarTask = new SidebarAction(chromeDriver);
        sidebarTask.sidebarTask();

        OutputData outputData = new OutputData(chromeDriver);
        outputData.outputData();

        SidebarAction sidebarTaskList = new SidebarAction(chromeDriver);
        sidebarTaskList. sidebarTaskList();

        TestSelenium testSelenium = new TestSelenium(chromeDriver);
        testSelenium. testSelenium();

        HeaderActions createNewTask = new HeaderActions(chromeDriver);
        createNewTask.createNewTask();

        NewTask newTask = new NewTask(chromeDriver);
        newTask.newTask();

        NewTask bugStatus = new NewTask(chromeDriver);
        bugStatus.taskStatus();

        SidebarAction sidebarTasks = new SidebarAction(chromeDriver);
        sidebarTasks.sidebarTasks();

        OutputData outputNewData = new OutputData(chromeDriver);
        outputNewData.outputNewData("");
    }
}
