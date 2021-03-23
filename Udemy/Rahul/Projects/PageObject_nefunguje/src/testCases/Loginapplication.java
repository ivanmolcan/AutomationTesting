package testCases;

import objectRepository.RediffLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Loginapplication {

    @Test
    public void loginApp() {

        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        RediffLogin rd = new RediffLogin(driver);
        rd.emailId().sendKeys("hello");
        rd.password().sendKeys("1234");
        rd.submit().click();

    }
}
