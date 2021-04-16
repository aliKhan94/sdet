@AlchemyCRM2
Feature: Create leads using parameterization

@CRMScenario2
Scenario: Open the Leads page and add multiple lead accounts using values passed from Feature file
    Given User open the CRM2 site and login
    When user navigate Sales -> Leads -> Create Lead
    And fill "<FName>" and "<LName>" and save
    Then Navigate to the View Leads page to see "<FName>" and "<LName>" result
    And Close CRM2 browser
    
  Examples:
    | FName     | LName    |  
    | Madhh     | Kund     | 
    | Samii     | Prad     | 
    | Rohii     | Kumr     | 
    | Mitthee   | Ro       |