import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceSiblingParent {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("hello");
        driver.findElement(By.name("pw")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        
        System.out.println(driver.findElement(By.id("error")).getText());
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());

        //Traverse
//        driver.findElement(By.xpath("//div[@id='content']/div[3]/div/a[@id='mydomainLink']")).click();
//        driver.findElement(By.xpath("//div[@id='content']/div[3]/div/a[2]")).click();

        //Sibling
//        driver.findElement(By.xpath("//*[@id='forgot_password_link']/following-sibling::a[1]")).click();
//        driver.findElement(By.xpath("//*[@id='mydomainLink']/preceding-sibling::a")).click();

        //Parent
//        driver.findElement(By.xpath("//*[@id='mydomainLink']/parent::div/parent::div/parent::div/following-sibling::div")).click();

        //Text
//        driver.findElement(By.xpath("//*[text()='Use Custom Domain']")).click();

        //CSS


    }
}
