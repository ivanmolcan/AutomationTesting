import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SpicejetKalendarBasic {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");

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

        //Kalendar
//        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("0.5")){
            System.out.println("It is disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
}
