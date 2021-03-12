import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://facebook.com");

        //Zatvorenie cookies okna
//        xpath = //tagName[@attribute='value']
//        driver.findElement(By.cssSelector("button._51sy[title='Accept All']")).click();
        driver.findElement(By.xpath("//button[@title='Accept All']")).click();
//        driver.findElement(By.xpath("//*[@title='Accept All']")).click();

        /* Vyskusanie v console v chrome

        $x("//*[@title='Accept All']") -- xpatch
        $("//*[@title='Accept All']") -- css selector

         */

//        driver.findElement(By.id("email")).sendKeys("lineer2@gmail.com");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("email@email.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@name='login']")).click();

    }
}
