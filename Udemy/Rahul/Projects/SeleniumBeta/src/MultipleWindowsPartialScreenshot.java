import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsPartialScreenshot {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);
//        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        driver.get("https://www.rahulshettyacademy.com/");
        String nameCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(nameCourse);

        //Screenshot partial
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));

        //Zachytenie Height a Width elementu
        System.out.println("Height: " + name.getRect().getDimension().getHeight());
        System.out.println("Width: " + name.getRect().getDimension().getWidth());

//        driver.quit();

    }
}
