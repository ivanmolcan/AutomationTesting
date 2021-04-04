package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("User is on Netbanking landing page")
    public void user_is_on_netbanking_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given");
    }

    @When("User login into application with username {string} and password {string}")
    public void user_login_into_application_with_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(string);
        System.out.println(string2);
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then");
    }

    @And("Cards are displayed")
    public void cards_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("And");
    }
}
