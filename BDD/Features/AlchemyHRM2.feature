@AlchemyHRM2
Feature: Adding a candidate for recruitment

@HRMScenario2
Scenario: Add information about a candidate for recruitment
    Given User open OrangeHRM and login for HRM2
    When user navigate to the Recruitment page and Click on Add
    And fill in the details of the candidate and Upload a resume and save
    Then Navigate back to the Recruitments page to confirm candidate entry
    And Close test browser HRM2