Feature: VimeoLink

  Scenario Outline: Link exists
    Given The user has opened the browser
    When The user maximizes the window
    And The user opens the Vimeo <fromurl> website
    Then A link <xpath> should exist on <linkurl> element

    Examples:
      | fromurl               | xpath                                                                                 | linkurl                         |
      | "https://vimeo.com/"  | "//*[@id='nav-cta-upgrade']/div/a"                                                          | "https://vimeo.com/upgrade"     |
      | "https://vimeo.com/"  | "//*[@id='lohp-app']/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[3]/div[2]/ul/li[1]/a"  | "https://vimeo.com/watch"       |
      | "https://vimeo.com/"  | "/html/body/main/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[4]/div[2]/div/div[2]/div/a[1]"  | "https://vimeo.com/create"       |


