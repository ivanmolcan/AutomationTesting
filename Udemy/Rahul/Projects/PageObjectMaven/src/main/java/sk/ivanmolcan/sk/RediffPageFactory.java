package sk.ivanmolcan.sk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPageFactory {

    //MORE READABLE

    WebDriver driver;
    //    By username = By.xpath("//*[@id='login1']");
//    By password = By.name("passwd");
//    By go = By.name("proceed");
//    By home = By.cssSelector("");

    @FindBy(xpath = "//*[@id='login1']")
    WebElement username;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "proceed")
    WebElement go;

    @FindBy(css = ".cell.logo a")
    WebElement home;

    public RediffPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  //!! treba to tam dat
    }

    public WebElement emailId() {
//        return driver.findElement(username);
        return username;
    }

    public WebElement password() {
//        return driver.findElement(password);
        return password;
    }

    public WebElement submit() {
//        return driver.findElement(go);
        return go;
    }

    public WebElement home() {
//        return driver.findElement(home);
        return home;
    }

}
