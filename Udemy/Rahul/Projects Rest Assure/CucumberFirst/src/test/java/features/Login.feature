Feature: Application Login

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with "jin" username and password "1234"
    Then Home page is populated
    And Cards displayed are "true"

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with "john" username and password "4321"
    Then Home page is populated
    And Cards displayed are "false"