package TestJira;

import TestJira.steps.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"TestJira.steps"},
        plugin = {"pretty"}
)
public class RunnerTest extends WebHooks {
}
