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

  Scenario Outline: Videos button background color
    Given The user has opened the browser
    When The user maximizes the window
    When The user opens the Vimeo login page
    When The user enters correct email
    When The user enters correct password
    When The user presses the login button
    Then The color of a <xpath> button when hovering over the mouse should be <color> lightgray

    Examples:
      | xpath                                                                                                                   | color                         |
      | "/html/body/div[1]/div[2]/main/div/div/div[1]/div[1]/div/div[1]/section[2]/div[1]/div/div[3]/span/div/div[2]/div/div/a" | "rgba(218, 225, 226, 1)"      |