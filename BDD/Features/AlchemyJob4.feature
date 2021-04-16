@AlchemyJob4
Feature: Posting a job using parameterization

@Scenario4
Scenario Outline: Post a job using details passed from the Feature file
    Given open browser and got to ​Alchemy Jobs site​ and navigate to Post a Job page​
    When User enters "<Emails>" and "<JobTitles>" and "<Descrip>" and "<Companys>" and click Preview and submit
    Then Go to the Jobs page and Confirm job listing is shown on page "<JobTitles>"
    
Examples:
    | Emails                   | JobTitles         | Descrip                       | Companys |
    | testingdurga16@gmail.com | Alchemy SDET DK1  | Test job for Cucumber project | IBM      |