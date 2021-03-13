import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String myName = "Ivan";
        driver.findElement(By.id("name")).sendKeys(myName);
        driver.findElement(By.id("alertbtn")).click();
        //Alert okno - switchnutie do alert modu
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(myName);
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();

    }
}
