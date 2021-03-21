package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//nad nazvom clasy ALT+ENTER a dat Create test
public class BasicTest {

    @Test
    public void demo() {
        System.out.println("Hello Ivan");
    }

    @Test(groups = {"Smoke"})
    public void secondTest() {
        System.out.println("Bye Ivan");
    }

    @Test
    public void mobile1() {
        System.out.println("mobile1");
        Assert.assertTrue(false);
    }

    @Test(timeOut = 4000)
    public void mobile2() {
        System.out.println("mobile2");
    }

    @Test
    public void mobile3() {
        System.out.println("mobile3");
    }
}