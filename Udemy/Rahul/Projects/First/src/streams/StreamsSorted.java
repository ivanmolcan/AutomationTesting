package streams;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StreamsSorted {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        driver.findElement(By.cssSelector("[class='table table-bordered'] thead th:nth-child(1)")).click();
        
        //capture all webelements into list
        List<WebElement> l1 = driver.findElements(By.cssSelector("[class='table table-bordered'] tr td:nth-child(1)"));

        //capture text of all webelements into new (original) list
        List<String> l1Text = l1.stream().map(s -> s.getText()).collect(Collectors.toList());

//        List<String> l1Text = new ArrayList<>();
//        for (WebElement list : l1) {
//            //capture text of all webelements into new (original) list
//            l1Text.add(list.getText());
//        }

        //sort on the original list of step 3 - > sorted list
        List<String> sortedList = l1Text.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        System.out.println(l1Text);
        System.out.println(sortedList);

        Assert.assertTrue(l1Text.equals(sortedList));

    }
}
