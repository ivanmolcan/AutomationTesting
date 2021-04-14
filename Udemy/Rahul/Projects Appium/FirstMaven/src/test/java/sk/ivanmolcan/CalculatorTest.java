package sk.ivanmolcan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            openCalculator();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void openCalculator() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel_4_API_30");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "30");

        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Application started ...");

        MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/formula_container"));

        two.click();
        plus.click();
        three.click();
        equals.click();
        System.out.println("Result: " + result.getText());
    }
}
