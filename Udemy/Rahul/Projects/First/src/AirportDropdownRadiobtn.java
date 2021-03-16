import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AirportDropdownRadiobtn {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Dropdown
        WebElement staticDropdown = driver.findElement(By.cssSelector("[name='ctl00$mainContent$DropDownListCurrency']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        dropdown.selectByValue("USD");

        //Dropdown2
        driver.findElement(By.cssSelector("[id*='divpaxin']")).click();
        Thread.sleep(200);
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.xpath("//span[contains(@id,'hrefInc')]")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        //Dropdown3
        driver.findElement(By.cssSelector("[id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        ///Index [2]
//        driver.findElement(By.xpath("//a[@value='MAA']")).click();
//        Thread.sleep(200);
//        driver.findElement(By.xpath("(//a[@value='IXB'])[2]")).click();

        ///Bez indexova mozno Parent->Child
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='IXB']")).click();

        //Doplnovaci dropdown / autosuggestive dropdown
        driver.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("ind");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

        //Radio Button
        driver.findElement(By.cssSelector("[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected());
        ///TestNG
        Assert.assertTrue(driver.findElement(By.cssSelector("[id*='friendsandfamily']")).isSelected());

        ///Zaskrtnutie vsetkych checkboxov
        System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.xpath("//*[@type='checkbox']")).size(), 6);

        //Radio Button
        driver.findElement(By.xpath("//*[text()='Round Trip']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Round Trip']")).isEnabled());
        driver.findElement(By.xpath("//*[text()='One Way']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='One Way']")).isEnabled());

    }
}
