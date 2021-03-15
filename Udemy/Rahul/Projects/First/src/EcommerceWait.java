import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceWait {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //Pridanie do kosika podla nazvu tovaru
//        driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]/following-sibling::div[@class='product-action']//button")).click();

        //Implicit wait, globalne nastavenie casu
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List itemsNeeded = Arrays.asList("Cucumber", "Brocolli");
        Thread.sleep(200);
        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
        //Explicit wait
        WebDriverWait w1 = new WebDriverWait(driver, 5);
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='promoWrapper']/input[@class='promoCode']")));

        driver.findElement(By.xpath("//div[@class='promoWrapper']/input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("[class='promoBtn']")).click();

        //Explicit wait
        WebDriverWait w2 = new WebDriverWait(driver, 5);
        w2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
//        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

    }

    public static void addItems(WebDriver driver, List itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText().replaceAll(" .*", "");
            if (itemsNeeded.contains(name)) {
                driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();
                j++;
                if (j > itemsNeeded.size() - 1) break;
            }
        }
    }

}
