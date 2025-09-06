Feature: OrangeHRM Workflow

  Scenario: Login and Add User
    Given User is on login page
    When User enters "username" and "password"
    Then User should land on dashboard
    Then User select role from the list
    And User click on add button
    When User clicks on user role
    Then User should should select an option from drop down
    When User enter text in the employee name field
    Then User need to select a name from the dropdown
    When User clicks on status
    Then User need to select a status from the dropdown
