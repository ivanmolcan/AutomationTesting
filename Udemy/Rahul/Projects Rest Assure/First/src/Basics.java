import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//manually wrote
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) throws IOException {

        //given - all input details
        //when - Submit the API
        //Then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //Post
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//                .body(Payload.addPlace())
                .body(new String(Files.readAllBytes(Paths.get("D:\\Doc\\Programovanie\\Automation Testing\\Udemy\\Rahul\\Projects Rest Assure\\First\\src\\try.json"))))  //Citanie zo suboru json - parameter Path
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");

        //Update
        String newAddress = "Summer Walk, Africa";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"" + placeId + "\",\r\n" +
                        "\"address\":\"" + newAddress + "\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //Get
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js2 = new JsonPath(getPlaceResponse);
        String actualAddress = js2.getString("address");

        Assert.assertEquals(actualAddress, newAddress);

    }
}
