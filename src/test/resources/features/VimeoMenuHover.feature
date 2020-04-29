Feature: Vimeo hover over menu color

  Scenario Outline: User hovers the mouse over a top menu dropdown list button
    Given The user has opened the browser
    When The user maximizes the window
    And The user opens the Vimeo <fromurl> website
    When The user clicks on a <xpath_first> top menu item with a dropdown list
    Then The color of a <xpath_second> button when hovering over the mouse should be <color>

    Examples:
    |fromurl    | xpath_first   | xpath_second    | color   |
    |"https://vimeo.com/"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/div[1]"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/div[2]/div/div[2]/div/a[1]"     | "rgb(246, 247, 248)"    |
    |"https://vimeo.com/"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/div[1]"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/div[2]/div/div[2]/div/a[4]"     | "rgb(246, 247, 248)"    |
    |"https://vimeo.com/"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[3]/div[1]"   | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[3]/div[2]/ul/li[3]"              | "rgb(238, 241, 242)"    |