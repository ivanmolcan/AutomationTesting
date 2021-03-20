package test;

import org.testng.annotations.*;

public class Skuska {

    @Parameters({"URL", "APIKey/usrname"})
    @Test(dependsOnMethods = {"api"})
    public void skuska(String urlName, String apikey) {
        System.out.println("URL: " + urlName + " APIkey: " + apikey);
    }

    @Test(groups = {"Smoke"}, enabled = false)
    public void testik() {
        System.out.println("testik");
    }

    @Test
    public void api() {
        System.out.println("api");
    }

    @BeforeTest
    public void prereq() {
        System.out.println("Before");
    }

    @AfterTest
    public void after() {
        System.out.println("After");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before every method");
    }

    @DataProvider
    public Object[][] getData() {

        //1st combination - username password
        //2st combination - username password
        //3st combination - username password
        Object[][] data = new Object[3][2];
        //1st set
        data[0][0] = "first username";
        data[0][1] = "first password";
        //2st set
        data[1][0] = "second username";
        data[1][1] = "second password";
        //3st set
        data[2][0] = "third username";
        data[2][1] = "third password";

        return data;
    }

    @Test(dataProvider = "getData")
    public void first() {
        System.out.println("api");
    }
}
