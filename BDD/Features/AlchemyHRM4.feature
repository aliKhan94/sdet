@AlchemyHRM4
Feature: Creating a job vacancy

@HRMScenario4
Scenario: To create a job vacancy for "DevOps Engineer"
    Given User open the OrangeHRM4 and login
    When user navigate to the Recruitment page and Click on the Vacancies
    And Click Add and Fill "<JobTitle>" and "<VName>" and "<Hmanager>" and Click Save
    Then Verify that the vacancy was created "<VName>"
    And Close HRM4 browser
    
Examples:
    | JobTitle                  | VName     | Hmanager  | 
    | DevOps Engineer           | DurgaK    |  IBM 01   |
    | Automation Test Engineer  | SamirP    |  IBM 02   |
    | Java Developer            | MitthiR   |  IBM 03   |