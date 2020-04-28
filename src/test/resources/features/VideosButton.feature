Feature: VideosButton
  Scenario: Click on the videos button
    Given The user has opened the browser
    When The user maximizes the window
    When The user opens the Vimeo login page
    When The user enters correct email
    When The user enters correct password
    When The user presses the login button
    And The user presses the videos button
    Then The user is redirected to the videos page