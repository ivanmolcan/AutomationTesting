import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//add manually
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class AboveBelowLeftRight {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(withTagName("input").below(dateOfBirth)).sendKeys("19-Mar-2021");

        WebElement iceCream = driver.findElement(By.xpath("//*[@for='exampleCheck1']"));
        driver.findElement(withTagName("input").toLeftOf(iceCream)).click();

        WebElement student = driver.findElement(By.cssSelector("[for='inlineRadio1']"));
        driver.findElement(withTagName("input").toRightOf(student)).click();
    }
}
