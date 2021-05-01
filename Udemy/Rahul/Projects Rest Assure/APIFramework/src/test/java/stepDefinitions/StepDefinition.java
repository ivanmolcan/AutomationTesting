package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.*;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String place_id;

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws Throwable {
        res = given().spec(requestSpecification())
                .body(data.addPlacePayLoad(name, language, address));
    }

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_post_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);

        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
        if (method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourceAPI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourceAPI.getResource());
        }

//        .then().spec(resspec).extract().response()
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() {
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @And("{string} in response body is {string}")
    public void something_in_response_body_is_something(String keyValue, String expectedValue) {
//        String resp = response.asString();
//        js = new JsonPath(resp);
        Assert.assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

    @And("verify place_Id created maps to {string} using {string}")
    public void verify_placeid_created_maps_to_something_using_something(String expectedName, String resource) throws IOException {
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_something_post_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(actualName, expectedName);
    }


    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }
}
