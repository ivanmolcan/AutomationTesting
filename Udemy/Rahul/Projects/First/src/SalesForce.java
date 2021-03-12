import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForce {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("hello");
        driver.findElement(By.name("pw")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        
        System.out.println(driver.findElement(By.id("error")).getText());
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());

    }
}
