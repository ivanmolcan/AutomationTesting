package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on Netbanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        System.out.println("Given");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        System.out.println("When");
    }

    @When("^User login into application with \"([^\"]*)\" username and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_username_and_password_something(String strArg1, String strArg2) throws Throwable {
        System.out.println("When 2");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Then");
    }

    @And("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String strArg1) throws Throwable {
        throw new PendingException();
    }
}
