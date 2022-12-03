
@tag
Feature: Validate error on the login page
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Error message validation
    Given I am in landing page
    When Logged in with username <username> and password <password>
    Then Error message "Incorrect email or password."should be disaplyed

    Examples: 
      | username						   | password    | 
      | 1819sameerag@gmail.com | Sameer@1234 | 
      
