Feature: Validatin Place API's

  Scenario: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload
    When user calls "AddPlaceAPI" Post http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
