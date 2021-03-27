package sk.ivanmolcan;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        //System.getProperty("user.dir")
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
//        FileInputStream file = new FileInputStream("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\E2EProject\\src\\main\\java\\resources\\data.properties");

        prop.load(file);

        //mvn test -Dbrowser=chrome
        String browserName = System.getProperty("browser");
//        String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options = options.addArguments("headless");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));

        return destinationFile;
    }

}
