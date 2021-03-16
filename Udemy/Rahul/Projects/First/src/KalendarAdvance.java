import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class KalendarAdvance {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("ez-accept-all")).click();

        driver.findElement(By.xpath("//*[@id='travel_date']")).click();

        //Mesiace
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        //Dni
        List<WebElement> dates = driver.findElements(By.cssSelector(".day"));

        for (int i = 0; i < driver.findElements(By.cssSelector(".day")).size(); i++) {
            String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
            if (text.equalsIgnoreCase("23")) {
                driver.findElements(By.cssSelector(".day")).get(i).click();
                break;
            }
        }


        //Explicit Wait, cakanie na zavretie popup okna
//        WebDriverWait wait = new WebDriverWait(driver, 180);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='sumome-react-svg-image-container']")));
//        driver.findElement(By.cssSelector("[class='sumome-react-svg-image-container'] div")).click();

    }
}
