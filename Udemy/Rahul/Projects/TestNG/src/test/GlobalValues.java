package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\TestNG\\src\\data.properties");
        prop.load(file);
        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("url"));
        prop.setProperty("browser", "firefox");
        System.out.println(prop.getProperty("browser"));

        //Nahranie do suboru
        FileOutputStream fos = new FileOutputStream("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects\\TestNG\\src\\data.properties");
        prop.store(fos, null);
    }
}
