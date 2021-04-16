@AlchemyHRM3
Feature: Adding a candidate for recruitment

@HRMScenario3
Scenario Outline: Add information about a candidate for recruitment
    Given User open OrangeHRM and login for HRM3
    When user navigate to PIM option and Click Add 
    And fill "<Fname>" and "<Lname>" and check Create Login Details checkbox and fill "<UserName>" and save
    Then Verify that the employees have been created with "<Fname>"
    And Close test browser HRM3
    
 Examples:
    | Fname  | Lname     | UserName  | 
    | Durga  | Kundu     | DurgaK    |
    | Samir  | Pradhan   | SamirP    |
    | Rohit  | Kumar     | RohitK    |
    | Mitthi | Roy       | MitthiR   |