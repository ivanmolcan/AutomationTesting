package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_email")
    WebElement email;

    @FindBy(id = "user_password")
    WebElement pass;

    @FindBy(xpath = "//*[@name='commit']")
    WebElement login;

    @FindBy(css = ".link-below-button")
    WebElement forgotPass;

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPass() {
        return pass;
    }

    public WebElement getLogin() {
        return login;
    }

    public ForgotPassword getForgotPass() {
        forgotPass.click();
        return new ForgotPassword(driver);
    }


}
