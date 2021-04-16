@AlchemyHRM1
Feature: Creating a job vacancy

@HRMScenario1
Scenario: To create a job vacancy for "DevOps Engineer"
    Given User open the OrangeHRM and login
    When user navigate to the Recruitment page and Click on the Vacancies menu item
    And Click on the Add and Fill the necessary details in Add Job Vacancy form and Click Save
    Then Verify that the vacancy was created
    And Close test browser