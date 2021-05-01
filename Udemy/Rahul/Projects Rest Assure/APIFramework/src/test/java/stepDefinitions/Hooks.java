package stepDefinitions;

import io.cucumber.java.*;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws Throwable {
        //write a code that will give you place id
        //execute this code only when place id is null
        StepDefinition m = new StepDefinition();
        if (m.place_id == null) {
            m.add_place_payload("Shetty", "French", "Asia");
            m.user_calls_something_post_http_request("AddPlaceAPI", "POST");
            m.verify_placeid_created_maps_to_something_using_something("Shetty", "getPlaceAPI");
        }
    }
}
