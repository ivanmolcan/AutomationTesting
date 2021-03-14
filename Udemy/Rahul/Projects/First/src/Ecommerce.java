import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Ecommerce {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //Pridanie do kosika podla nazvu tovaru
//        driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]/following-sibling::div[@class='product-action']//button")).click();
        int j = 0;
        List itemsNeeded= Arrays.asList("Cucumber", "Brocolli");
        Thread.sleep(200);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText().replaceAll(" .*", "");
            if (itemsNeeded.contains(name)) {
                driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();
                j++;
                if (j > itemsNeeded.size()-1) break;
            }
        }
    }
}
