package cucumber.Options;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepDefitions"}
)
public class TestRunner {

    @Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {
        System.out.println("Given");
    }

    @When("^user calls \"([^\"]*)\" Post http request$")
    public void user_calls_something_post_http_request(String strArg1) {
        System.out.println("When");
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() {
        System.out.println("Then");
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) {
        System.out.println("And");
    }
}
