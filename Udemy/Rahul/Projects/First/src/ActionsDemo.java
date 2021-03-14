import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //Maximize screen
        driver.manage().window().maximize();

        //MouseOver
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        a.moveToElement(move).contextClick().build().perform();
        //Napisanie velkym pismom
        a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
                .doubleClick().build().perform();

    }
}
