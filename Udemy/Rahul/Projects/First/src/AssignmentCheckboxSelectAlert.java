import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AssignmentCheckboxSelectAlert {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("checkBoxOption2")).click();
        String valCheckbox = driver.findElement(By.xpath("//*[@id='checkBoxOption2']//parent::label[@for='benz']")).getText();
        Select sel = new Select(driver.findElement(By.id("dropdown-class-example")));
        sel.selectByVisibleText(valCheckbox);

        driver.findElement(By.cssSelector("[id='name']")).sendKeys(valCheckbox);
        driver.findElement(By.cssSelector("[value='Alert']")).click();
        String alertText = driver.switchTo().alert().getText();
        String alertTextName = alertText.substring(alertText.indexOf(" ")+1, alertText.indexOf(","));
        if(valCheckbox.equalsIgnoreCase(alertTextName)){
            System.out.println("Right");
        } else {
            System.out.println("False");
        }
        driver.switchTo().alert().accept();

    }
}
