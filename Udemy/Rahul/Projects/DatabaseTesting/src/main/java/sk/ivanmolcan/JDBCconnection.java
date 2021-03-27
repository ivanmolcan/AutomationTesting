package sk.ivanmolcan;

import com.mysql.cj.protocol.Resultset;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class JDBCconnection {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "");

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from employeeinfo where name = 'sam'");


        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

        while (rs.next()) {
            driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("location"));
        }

        driver.close();
    }
}
