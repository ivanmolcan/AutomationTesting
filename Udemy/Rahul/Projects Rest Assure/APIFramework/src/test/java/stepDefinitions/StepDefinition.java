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

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws Throwable {
        res = given().spec(requestSpecification())
                .body(data.addPlacePayLoad(name, language, address));
    }

    @When("^user calls \"([^\"]*)\" Post http request$")
    public void user_calls_something_post_http_request(String resource) {
        APIResources resourceAPI = APIResources.valueOf(resource);

        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
        response = res.when().post(resourceAPI.getResource())
                .then().spec(resspec).extract().response();
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() {
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String keyValue, String expectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        Assert.assertEquals(js.get(keyValue).toString(), expectedValue);
    }
}
