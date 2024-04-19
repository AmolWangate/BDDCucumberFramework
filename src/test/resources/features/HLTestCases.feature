Feature: 

  Scenario: login with valid data
    Given I'm on the home page
    When I click on login button on home page
    And I enter user credentials
    Then I'm redirected to homepage as logged in user

  Scenario: login with invalid data
    Given I'm on the home page
    When I click on login button on home page
    And I enter invalid user credentials
    Then I get login failure error message
    But I'm not redirected to the home page

  Scenario: Search for an item and navigate to PDP page as guest user
    Given I'm on the home page
    When I click on the search icon
    And I enter product name in the search flyout
    Then I click on search icon on the flyout
    Then I'm on the SRP page
    And I click on the product on SRP page
    Then I'm navigated to PDP page as guest

  Scenario: Search for an item and navigate to PDP page as logged in user
    Given I'm on the home page
    When I click on login button on home page
    And I enter user credentials
    Then I'm redirected to homepage as logged in user
    And I click on the search icon
    And I enter product name in the search flyout
    Then I click on search icon on the flyout
    Then I'm on the SRP page
    And I click on the product on SRP page
    Then I'm navigated to PDP page as logged in user

  Scenario: Add product to bag from PDP page as a guest user
    Given I'm on the home page
    And I click on the search icon
    Then I select a product from the search flyout
    Then I'm navigated to PDP page
    When I click on Add to bag button
    Then I see mini cart flyout
    When I click on bag button on the flyout
    Then I'm redirected to the bag page

  Scenario: Add product to bag from PDP page as a logged in user
    Given I'm on the home page
    When I click on login button on home page
    And I enter user credentials
    Then I'm redirected to homepage as logged in user
    And I click on the search icon
    Then I select a product from the search flyout
    Then I'm navigated to PDP page
    When I click on Add to bag button
    Then I see mini cart flyout
    When I click on bag button on the flyout
    Then I'm redirected to the bag pagev
