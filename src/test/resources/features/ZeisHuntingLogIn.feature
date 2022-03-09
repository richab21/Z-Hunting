Feature: login
@HUN
  Scenario Outline: Login with wrong username and password
    Given I navigate to the login page
    When I provide "<username>" and "<password>"
    And I click on login button
    Then I should see the error alert
    Examples:
      | username                     | password         |
      | tester | password |
