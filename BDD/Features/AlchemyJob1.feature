@AlchemyJob1
Feature: Create a new user

@Scenario1
Scenario: Visit the sites backend and create a new user
    Given User open the browser and Navigate to url​
    When log in and Locate the left hand menu and click the menu item that says Users
    And Locate the Add New button and click it and Fill in the necessary details and  Click the New User button
    Then Verify that the user was created
    And Close the browser