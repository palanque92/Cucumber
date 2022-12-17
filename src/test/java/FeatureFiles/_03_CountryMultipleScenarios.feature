Feature: Country Multi Scenario

  Background: Create Country
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly
    And Navigate to country page

    Scenario:Create a country parameter data
      When create a country
      Then Success message should be displayed

    Scenario:Create a country parameter data
      When create a country name as "boncukUlk111" code as "omerulk123"
      Then Success message should be displayed

