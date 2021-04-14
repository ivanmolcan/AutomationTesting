import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "ApiDemos-debug.apk");
//        File fs = new File("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects Appium\\First\\src\\ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 28");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
    }
}
