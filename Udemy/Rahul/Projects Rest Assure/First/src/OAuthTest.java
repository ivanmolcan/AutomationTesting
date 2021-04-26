import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojoDeserialization.Api;
import pojoDeserialization.GetCourse;
import pojoDeserialization.WebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//manually wrote
import static io.restassured.RestAssured.*;

public class OAuthTest {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "D:\\Doc\\Programovanie\\Automation Testing\\Materials\\Webdriver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
////        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
////        WebDriver driver = new FirefoxDriver();
//
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.findElement(By.cssSelector("[type='email']")).sendKeys("lineer2@gmail.com");
//        driver.findElement(By.cssSelector("[class='VfPpkd-RLmnJb']")).click();
//        String url = driver.getCurrentUrl();
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AY0e-g7B_5p2P52pFy5zp5-4zw8LAR5ECFmcKJ8Zx4YzT7FuckRYAXPKGwS7NUuhygGO2w&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";

        String partialCode = url.split("code=")[1];
        partialCode = partialCode.split("&")[0];


        String accessTokenResponse = given().urlEncodingEnabled(false)
                .queryParams("code", partialCode)
                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type", "authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();
        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");


        GetCourse gc = given().queryParam("access_token", accessToken)
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

        System.out.println(gc.getLinkedIn());
        gc.getInstructor();
        gc.getCourses().getApi().get(1).getCourseTitle();

        List<Api> apiCpurses = gc.getCourses().getApi();
        for (int i = 0; i < apiCpurses.size(); i++) {
            if (apiCpurses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
                System.out.println(apiCpurses.get(i).getPrice());
                gc.getCourses().getMobile().get(1).getCourseTitle();
            }
        }

        //Get the course names of WebAutomation
        String[] courseTitles = {"Selenium Webdriever Java", "Cypress", "Protractor"};
        ArrayList<String> a = new ArrayList<String>();

        List<WebAutomation> w = gc.getCourses().getWebAutomation();
        for (int j = 0; j < w.size(); j++) {
            a.add(w.get(j).getCourseTitle());
        }

        List<String> expectedList = Arrays.asList(courseTitles);
        Assert.assertTrue(a.equals(expectedList));
    }
}
