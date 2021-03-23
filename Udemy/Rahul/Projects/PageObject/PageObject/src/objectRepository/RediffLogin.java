package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffLogin {

    WebDriver driver;
    By username = By.xpath("//*[@id='login1']");
    By password = By.name("passwd");
    By go = By.name("proceed");

    public RediffLogin(WebDriver driver) {
        this.driver = driver;
    }


}
