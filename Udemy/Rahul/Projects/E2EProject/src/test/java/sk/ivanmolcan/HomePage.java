package sk.ivanmolcan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class HomePage extends Base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String pass) throws IOException {
        driver.get(prop.getProperty("url"));

        LandingPage landing = new LandingPage(driver);
//        landing.getLogin().click();
        LoginPage login = landing.getLogin();

//        LoginPage login = new LoginPage(driver);
        login.getEmail().sendKeys(username);
        login.getPass().sendKeys(pass);
        log.info("Credentials entered");
        login.getLogin().click();

        ForgotPassword fp = login.getForgotPass();
        fp.getEmail().sendKeys("skuska@skuska.sk");
        fp.getName().click();

    }

    @AfterTest
    public void teardown() {
        driver.close();
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
