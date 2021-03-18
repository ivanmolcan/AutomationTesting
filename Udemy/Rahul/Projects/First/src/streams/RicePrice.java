package streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RicePrice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("[class='table table-bordered'] thead th:nth-child(1)")).click();
//        driver.findElement(By.cssSelector("[class='table table-bordered'] thead th:nth-child(1)")).click();
        List<WebElement> rice;

        do {
            List<WebElement> vegFruitName = driver.findElements(By.cssSelector("[class='table table-bordered'] tr td:nth-child(1)"));
            rice = vegFruitName.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
            rice.stream().map(s -> s.findElement(By.xpath("./following-sibling::td[1]")).getText()).forEach(s -> System.out.println(s));

            //ak nie je najdena ryza
            if (rice.size() < 1) {
                driver.findElement(By.xpath("//*[@aria-label='Next']")).click();
            }
        } while (rice.size() < 1);
    }
}
