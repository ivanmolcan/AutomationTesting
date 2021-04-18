import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//manually wrote
import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";

        String response = given().header("Content-Type", "application/json")
                .body(Payload.addbook("adsf", "6464"))
                .when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        String id = js.getString("ID");
        System.out.println(id);
    }

    @DataProvider
    public Object[][] getData(){

        new Object[][]{};

        return new Object[0][];
    }
}
