package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_email")
    WebElement email;

    @FindBy(name = "commit")
    WebElement name;

    public WebElement getEmail() {
        return email;
    }

    public WebElement getName(){
        return name;
    }

}
