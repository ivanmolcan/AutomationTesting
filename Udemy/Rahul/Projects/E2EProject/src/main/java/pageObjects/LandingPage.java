package pageObjects;

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

    @FindBy(css = "#content .container .text-center h2")
    WebElement h2;

    @FindBy(css = ".nav.navbar-nav.navbar-right li a")
    WebElement nav;

    //    @FindBy(css = "p:contains('Learn Hot tools')")
    @FindBy(css = ".col-sm-6.col-md-8.hidden-xs.video-banner p")
    WebElement title;

//    By signin = By.cssSelector("a[href*='sign_in']");

    public LoginPage getLogin() {
        signin.click();
        LoginPage login = new LoginPage(driver);
        return login;
//        return driver.findElement(signin);
    }

    public WebElement getH2() {
        return h2;
    }

    public WebElement getNav() {
        return nav;
    }

    public WebElement getTitle() {
        return title;
    }
}
