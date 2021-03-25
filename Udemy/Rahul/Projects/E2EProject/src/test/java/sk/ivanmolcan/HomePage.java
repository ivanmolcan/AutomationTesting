package sk.ivanmolcan;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.util.Locale;

public class HomePage extends Base {

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String pass) throws IOException {
        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");

        LandingPage landing = new LandingPage(driver);
        landing.getLogin().click();
        Assert.assertEquals(landing.getH2().getText(), ("Featured Courses").toLowerCase());

        LoginPage login = new LoginPage(driver);
        login.getEmail().sendKeys(username);
        login.getPass().sendKeys(pass);
        login.getLogin().click();

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "nonrestricteduser@qw.com";
        data[0][1] = "123456";

        data[1][0] = "restricteduser@qw.com";
        data[1][1] = "654321";

        return data;
    }
}
