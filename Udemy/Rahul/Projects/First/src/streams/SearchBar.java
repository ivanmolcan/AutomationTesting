package streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchBar {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        veggies.stream().filter(s -> s.getText().contains("Rice")).map(s -> s.getText()).forEach(s -> System.out.println(s));
        List<WebElement> list = veggies.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(veggies.size()+1, list.size());
    }
}
