Feature: Login into App

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com" site
    And Click on Login link in home page to land on sign in Page
    When User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in

    Examples:
      | username         | password |
      | test99@gmail.com | 123456   |
      | ivan@gmail.com   | 4444     |