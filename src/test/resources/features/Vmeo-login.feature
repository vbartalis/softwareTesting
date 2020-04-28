Feature: Vimeo-login

  Scenario: User tries to login
    Given I have opened the browser
    When I maximize the window
    When I open the Vimeo login page
    When The user enters correct email
    When The user enters correct password
    And The user presses the login button
    Then The user is redirected to Vimeo's home page

  Scenario: User tries to login with invalid password
    Given I have opened the browser
    When I maximize the window
    When I open the Vimeo login page
    When The user enters correct email
    When The user enters incorrect password
    And The user presses the login button
    Then A red box is displayed with an error message


