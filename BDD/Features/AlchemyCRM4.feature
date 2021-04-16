@AlchemyCRM4
Feature: Creating a Product

@CRMScenario4
Scenario: To use an Examples table to add products
    Given User open the CRM4 site and login
    When user navigate All -> Products-> Create Product
    And Enter the details "<PName>" and "<Price>" and "<Desc>" and save
    Then Navigate to View Products page to see all products "<PName>" listed
    And Close CRM4 browser
    Examples:
    |PName |Price|Desc|
    |CRM41 |100  |Test|