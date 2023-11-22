Feature: Login and Shopping Cart

  Background:
    Given User opens the browser
    And User navigates to the URL

  @smokeTest
  Scenario Outline: Verify user can log in successfully with valid credentials
    When User enters username "<username>" and password "<password>"
    Then User clicks on the login button
    And User should be on the home page
    Then User closes the browser

    Examples:
      | username       | password    |
      | standard_user  | secret_sauce |
      | visual_user    | secret_sauce |

  @E2ETest
  Scenario: Verify user can add 3 products to the shopping cart
    When User enters username "standard_user" and password "secret_sauce"
    Then User clicks on the login button
    And User should be on the home page
    Then User adds three items to the shopping cart
    Then User closes the browser
