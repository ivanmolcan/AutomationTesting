package sk.ivanmolcan.sk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLogin {

    WebDriver driver;
    By username = By.xpath("//*[@id='login1']");
    By password = By.name("passwd");
    By go = By.name("proceed");
    By home = By.cssSelector(".cell.logo a");

    public RediffLogin(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement emailId() {
        return driver.findElement(username);
    }

    public WebElement password() {
        return driver.findElement(password);
    }

    public WebElement submit() {
        return driver.findElement(go);
    }

    public WebElement home() {
        return driver.findElement(home);
    }

}
