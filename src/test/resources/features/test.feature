Feature: validate diffrent login scenarios

  @valid
  Scenario: verify login with valid data
    Given I'm on the home page.
    When I enter userID as "standard_user" and passwor as "secret_sauce"
    And I click on login button
    Then I'm logged in

  @invalid
  Scenario: verify login with invalid data
    Given I'm on the home page.
    When I enter userID as "secret_sauce" and passwor as "secret_sauce"
    And I click on login button
    Then I'm not logged in

  @dataTable
  Scenario: verify login with valid data
    Given I'm on the home page.
    When I enter userID and password
      | username      | password     |
      | standard_user | secret_sauce |
    And I click on login button
    Then I'm logged in
