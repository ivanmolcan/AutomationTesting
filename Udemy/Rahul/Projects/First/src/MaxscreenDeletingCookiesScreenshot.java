//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class MaxscreenDeletingCookiesScreenshot {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Maximize screen
        driver.manage().window().maximize();

        //Delete cookies
        driver.manage().deleteAllCookies();

        driver.get("https://www.amazon.com/");

        //Screenshot - vlozene jar commons-io-2.8.0 (https://commons.apache.org/proper/commons-io/download_io.cgi)
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("D://screenshot.png"));

    }
}
