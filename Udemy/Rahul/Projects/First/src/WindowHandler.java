import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandler {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
//        String email = driver.findElement(By.cssSelector(".im-para.red")).getText();
//        email = email.substring((email.indexOf("t") + 2), email.length());
//        email = email.substring(0, email.indexOf(" "));
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailId);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);

    }
}
