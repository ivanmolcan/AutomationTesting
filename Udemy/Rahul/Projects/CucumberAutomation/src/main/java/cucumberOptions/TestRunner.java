package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//glue - package name
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions"
)
public class TestRunner {

}
