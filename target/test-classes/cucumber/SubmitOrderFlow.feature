
@tag
Feature: I want to submit an order
  I want to use this template for my feature file
  
  Background: 
  Given I am in landing page

  @SubmitOrder
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <username> and password <password>
    When I added the product <productname> to cart
    And checkout the product <productname> and submit the order
    Then success mesage "THANKYOU FOR THE ORDER." should be displayed on confirmation page

    Examples: 
      | username							  | password       | productname  |
      | 1819sameerag@gmail.com  | Sameer@123 		 | ZARA COAT 3  |
     
