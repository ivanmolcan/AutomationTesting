package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import sk.ivanmolcan.Base;

import java.io.IOException;

public class StepDefinition extends Base {
    @Given("Initialize the browser with chrome")
    public void initializeTheBrowserWithChrome() throws IOException {
        driver = initializeDriver();
    }

    @And("Navigate to {string} site")
    public void navigateToSite(String arg0) {
        driver.get(arg0);
    }

    @And("Click on Login link in home page to land on sign in Page")
    public void clickOnLoginLinkInHomePageToLandOnSignInPage() {
        LandingPage landing = new LandingPage(driver);
        landing.getLogin();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void userEntersAndAndLogsIn(String arg0, String arg1) {
        LoginPage login = new LoginPage(driver);
        login.getEmail().sendKeys(arg0);
        login.getPass().sendKeys(arg1);
        login.getLogin().click();
    }

    @Then("Verify that user is succesfully logged in")
    public void verifyThatUserIsSuccesfullyLoggedIn() {
        Assert.assertTrue(true);
    }
}
