Feature: Add product to cart

  Background:
    Given user on the home page of the Submarino website

  Scenario: Validate empty cart
    When user clicks on the cart icon
    Then the alert that the cart is empty is displayed

  Scenario: Validate search by nonexistent product
    When user types "@#$nonexistenceproductisfound@#$" on the searchbar
    And  click on search button
    Then the screen with no results found is displayed

  Scenario: Validate search by existent product
    When user types "garrafa" on the searchbar
    And  click on search button
    Then the screen with search results for "garrafa" is displayed

  Scenario: Validate product addition to cart successfully
    And  user types "Caneca" on the searchbar
    And  click on search button
    When the screen with search results for "Caneca" is displayed
    And  tap on the first result
    And  click the buy button
    Then the product was successfully added to the cart

