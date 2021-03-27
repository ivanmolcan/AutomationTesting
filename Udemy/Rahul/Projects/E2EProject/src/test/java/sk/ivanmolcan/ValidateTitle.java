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
import java.util.Locale;

public class ValidateTitle extends Base {

    public WebDriver driver;
    LandingPage landing;
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
        landing = new LandingPage(driver);
        Assert.assertEquals(landing.getH2().getText().toLowerCase(), ("Featured Courses111").toLowerCase());
        log.info("Succesfully validated Text message");
    }

    @Test
    public void validateTitleP() {
        Assert.assertEquals(landing.getTitle().getText().toLowerCase(), ("Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..").toLowerCase());
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
