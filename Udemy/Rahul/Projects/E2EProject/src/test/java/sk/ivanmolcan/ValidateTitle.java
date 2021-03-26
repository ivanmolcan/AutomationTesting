package sk.ivanmolcan;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import sk.ivanmolcan.Base;

import java.io.IOException;

public class ValidateTitle extends Base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void baseTitle() {
        LandingPage landing = new LandingPage(driver);
        Assert.assertEquals(landing.getH2().getText().toLowerCase(), ("Featured Courses").toLowerCase());
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
