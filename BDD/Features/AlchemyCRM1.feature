@AlchemyCRM1
Feature: Counting Dashlets

@CRMScenario1
Scenario: Open the homepage and count the number of the dashlets on the page
    Given User open the CRM site and login
    When Count the number of Dashlets on the homepage and Print the number and title
    Then Close CRM browser