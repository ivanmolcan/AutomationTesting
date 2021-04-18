import io.appium.java_client.*;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Basics extends Base {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver<MobileElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Package - io.appium.android.apis

        driver.findElement(By.xpath("//*[@content-desc='Preference']")).click();
//        driver.findElement(By.xpath("//*[@text='Preference']")).click();

    }
}
