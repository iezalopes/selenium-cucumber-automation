Feature: Test

  Scenario: add to basket
    Given that i am on the shopping website
    When I add an item to the basket
    Then i can view the item in my basket
