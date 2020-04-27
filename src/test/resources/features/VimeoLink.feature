Feature: VimeoLink

  Scenario Outline: Link exists
    Given I have opened the browser
    When I maximize the window
    And I open the Vimeo <fromurl> website
    Then A link <xpath> should exist on <linkurl> element

    Examples:
      | fromurl               | xpath                                                                                 | linkurl                         |
      | "https://vimeo.com/"  | "//*[@id='nav-cta-upgrade']/div/a"                                                          | "https://vimeo.com/upgrade"     |
      | "https://vimeo.com/"  | "//*[@id='lohp-app']/div/div[2]/div/div[1]/div[1]/div[1]/ul/li[3]/div[2]/ul/li[1]/a"  | "https://vimeo.com/watch"       |


