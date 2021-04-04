Feature: Application Login

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with username "jim" and password "1234"
    Then Home page is populated
    And Cards are displayed

  Scenario: Home page default login
    Given User is on Netbanking landing page
    When User login into application with username "ico" and password "4423"
    Then Home page is populated
    And Cards are displayed
