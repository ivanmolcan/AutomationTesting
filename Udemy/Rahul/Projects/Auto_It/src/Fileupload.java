import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Fileupload {

    public static void main(String[] args) throws IOException {
        String downloadPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://altoconvertpdftojpg.com");
        driver.findElement(By.cssSelector("[class='btn--choose']")).click();
        Runtime.getRuntime().exec("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\Auto_It\\src\\fileupload.exe");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='medium']")));

        driver.findElement(By.cssSelector("button[class='medium']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
        driver.findElement(By.linkText("Download Now")).click();
        File f = new File(downloadPath + "/converted.zip");
        if (f.exists()) {
            System.out.println("file found");
            f.delete();
        }

    }
}
