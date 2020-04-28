Feature: Vimeo-login

  Scenario: User tries to login
    Given The user has opened the browser
    When The user maximizes the window
    When The user opens the Vimeo login page
    When The user enters correct email
    When The user enters correct password
    And The user presses the login button
    Then The user is redirected to Vimeo's home page

  Scenario: User tries to login with invalid password
    Given The user has opened the browser
    When The user maximizes the window
    When The user opens the Vimeo login page
    When The user enters correct email
    When The user enters incorrect password
    And The user presses the login button
    Then A red box is displayed with an error message


