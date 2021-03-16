import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL {

    public static void main(String[] args) {


        //SSL certificates (ak stranka nahodou nema SSL, preskocenie vystrazneho okna)
        ///general chrome profile
        DesiredCapabilities ch = DesiredCapabilities.chrome();
//        ch.acceptInsecureCerts();
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ///belongs to your local browser
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(c);
    }
}
