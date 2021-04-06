import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Fileupload {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://altoconvertpdftojpg.com");
        driver.findElement(By.cssSelector("[class='btn--choose']")).click();
        Runtime.getRuntime().exec("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\Auto_It\\src\\fileupload.exe")
    }
}
