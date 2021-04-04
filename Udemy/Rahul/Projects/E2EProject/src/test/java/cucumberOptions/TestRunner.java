package cucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
//glue - package name
@CucumberOptions(
        features = "classpath:src/test/java/features",
        glue = "classpath:src/test/java/stepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
