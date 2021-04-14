package sk.ivanmolcan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDemos {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            openApiDemos();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void openApiDemos() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "ApiDemos-debug.apk");
//        File fs = new File("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects Appium\\FirstMaven\\src\\test\\ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4_API_30");
//        cap.setCapability("udid", "emulator-5554");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("platformVersion", "30");
//        cap.setCapability("appPackage", fs);
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }
}
