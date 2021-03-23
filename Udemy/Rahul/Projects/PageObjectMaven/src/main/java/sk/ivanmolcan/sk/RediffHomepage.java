package sk.ivanmolcan.sk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomepage {

    WebDriver driver;
    By search = By.id("srchquery_tbox");

    public RediffHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Search() {
        return driver.findElement(search);
    }

}
