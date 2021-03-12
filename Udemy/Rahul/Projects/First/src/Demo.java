import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

    public static void main(String[] args) {

        //FF
//        System.setProperty("webdriver.gecko.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\geckodriver.exe");
//        WebDriver driver2 = new FirefoxDriver();

        //Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());     //find and url
        System.out.println(driver.getPageSource());     //get source of page

        driver.get("http://yahoo.com");
        driver.navigate().back();
        driver.navigate().forward();
//        driver.close();     //zavrie aktualny prehliadac
//        driver.quit();      //zavrie vsetky prehliadace otvorene seleniom, zavrie driver



    }

}
