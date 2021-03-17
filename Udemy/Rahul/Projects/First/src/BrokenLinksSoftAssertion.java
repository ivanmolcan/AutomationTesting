import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksSoftAssertion {

    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Broken URL, java methods will call URL's and gets you the status code
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        int i = 1;
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(i + ": " + respCode);
            i++;

            //Hard assertion
//            Assert.assertTrue(respCode < 400, "The link with Text/ " + link.getText() + " /with broken code " + respCode);

            //Soft assertion
            a.assertTrue(respCode < 400, "The link with Text/ " + link.getText() + " /with broken code " + respCode);

//            if (respCode > 400) {
//                System.out.println("The link with Text/ " + link.getText() + " /with broken code " + respCode);
//                Assert.assertTrue(false);
//            }
        }

        //Soft assertion, vysledok zo vsetkych liniek
        a.assertAll();
    }
}
