Feature: VimeoButton

  Scenario: Click on the vimeo button
    Given The user has opened the browser
    When The user maximizes the window
    When The user opens the Vimeo login page
    When The user enters correct email
    When The user enters correct password
    When The user presses the login button
    When The user presses the videos button
    And The user presses the vimeo button
    Then The user is redirected to Vimeo's home page