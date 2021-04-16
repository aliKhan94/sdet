@AlchemyCRM3
Feature: Schedule a meeting and invite members

@CRMScenario3
Scenario: To schedule a meeting and include at least 3 invitees
    Given User open the CRM3 site and login
    When user navigate Activities -> Meetings -> Schedule a Meeting
    And Enter the details of the meeting
    And Search FName and LName and add them
      
    | Madhabii | Kund     | 
    | Sami     | Prad     | 
    | Rohi     | Kumr     | 
    | Mitth    | Ro       |
    
    Then Save and Navigate to View Meetings page and confirm creation of the meeting
    And Close CRM3 browser