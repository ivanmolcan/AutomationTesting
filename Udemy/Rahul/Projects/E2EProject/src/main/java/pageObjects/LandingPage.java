package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href*='sign_in']")
    WebElement signin;

    @FindBy(css = ".container>.text-center>h2")
    WebElement h2;

//    By signin = By.cssSelector("a[href*='sign_in']");

    public WebElement getLogin() {
        return signin;
//        return driver.findElement(signin);
    }

    public WebElement getH2(){
        return h2;
    }
}
