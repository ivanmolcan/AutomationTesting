import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println(driver.findElements(By.tagName("a")).size());
        int i = driver.findElements(By.tagName("a")).size();
        Assert.assertEquals(i, 27);

        //Pocet a tagov iba vo footeri
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        ///alebo takto
        System.out.println(driver.findElements(By.xpath("//*[@id='gf-BIG']//a")).size());

        //Vo footeri 'a' iba v druhej sekcii
        System.out.println(driver.findElement(By.xpath("//*[@id='gf-BIG']//tr//td[2]")).findElements(By.tagName("a")).size());
        System.out.println(footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")).findElements(By.tagName("a")).size());

        //kliknutie na vsetky linky
//        for(int j=1;j<footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")).findElements(By.tagName("a")).size(); j++ ){
//            //kliknutie linky na kazdy novy tab
//            String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
//            footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")).findElements(By.tagName("a")).get(j).sendKeys(clickOnLink);
//        }

        List<WebElement> list = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")).findElements(By.tagName("a"));
        for (WebElement l : list) {
            l.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        }

        Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
        Iterator<String> it = windows.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getCurrentUrl() + ": " + driver.getTitle());
        }
    }
}
