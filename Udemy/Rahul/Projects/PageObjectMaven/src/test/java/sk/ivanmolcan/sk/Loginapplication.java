package sk.ivanmolcan.sk;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Loginapplication {

    @Test
    public void loginApp() {

        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        RediffLogin rd = new RediffLogin(driver);
        rd.emailId().sendKeys("hello");
        rd.password().sendKeys("1234");
        rd.submit().click();
        rd.home().click();

        RediffHomepage rh = new RediffHomepage(driver);
        rh.Search().sendKeys("rediff");
        rh.Search().sendKeys(Keys.ENTER);

    }
}
