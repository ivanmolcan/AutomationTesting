//manually wrote

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JiraTest {

    public static void main(String[] args) {
        baseURI = "http://localhost:8080";
        SessionFilter session = new SessionFilter();

        //Authentification
        String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json")
                .body("{ \"username\": \"root\", \"password\": \"root\"}").log().all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then().extract().response().asString();

        //Add comment
        String expectedMessage = "This is my first comment";
        String addComment = given().pathParam("id", "10025").log().all()
                .header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"body\": \"" + expectedMessage + "\",\r\n" +
                        "\"visibility\": {\r\n" +
                        "\"type\": \"role\",\r\n" +
                        "\"value\": \"Administrators\"\r\n" +
                        "}\r\n" +
                        "}"
                )
                .filter(session)
                .when()
                .post("/rest/api/2/issue/{id}/comment").then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();
        JsonPath js = new JsonPath(addComment);
        String commentId = js.getString("id");

        //Add attachment
        given().header("X-Atlassian-Token", "no-check").filter(session)
                .header("Content-Type", "multipart/form-data")
                .pathParam("id", "10025")
                .multiPart("file", new File("skuska.txt"))
                .when().post("/rest/api/2/issue/{id}/attachments")
                .then().log().all().assertThat().statusCode(200);

        //Get Issue
        String issueDetails = given().filter(session).pathParam("id", "10025")
                .queryParam("fields", "comment") //vypise len urcite polia
                .log().all().when()
                .get("/rest/api/2/issue/{id}")
                .then().log().all().extract().response().asString();
        System.out.println(issueDetails);
        System.out.println();

        JsonPath js2 = new JsonPath(issueDetails);
        int commentsCount = js2.getInt("fields.comment.comments.size()");
        for (int i = 0; i < commentsCount; i++) {
            String commentIdIssue = js2.get("fields.comment.comments[" + i + "].id").toString();
            if (commentIdIssue.equalsIgnoreCase(commentId)) {
                String message = js2.get("fields.comment.comments[" + i + "].body").toString();
                System.out.println("Comment body: " + message);
                Assert.assertEquals(message, expectedMessage);
            }
        }
    }
}
