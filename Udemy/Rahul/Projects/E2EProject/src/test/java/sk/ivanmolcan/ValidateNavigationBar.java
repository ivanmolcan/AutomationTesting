package sk.ivanmolcan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import sk.ivanmolcan.Base;

import java.io.IOException;

public class ValidateNavigationBar extends Base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void baseTitle() throws IOException {
        LandingPage landing = new LandingPage(driver);
        Assert.assertTrue(landing.getNav().isDisplayed());
        log.info("Navigation bar is displayed");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
