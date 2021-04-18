import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

//manually wrote
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {

        //given - all input details
        //when - Submit the API
        //Then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //Post
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace())
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
        js2.getString("address");

        

    }
}
