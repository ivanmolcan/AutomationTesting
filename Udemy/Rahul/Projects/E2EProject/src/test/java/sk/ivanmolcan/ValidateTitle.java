package sk.ivanmolcan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Homepage");
    }

    @Test
    public void validateTitleApp() {
        LandingPage landing = new LandingPage(driver);
        Assert.assertEquals(landing.getH2().getText().toLowerCase(), ("Featured Courses111").toLowerCase());
        log.info("Succesfully validated Text message");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
