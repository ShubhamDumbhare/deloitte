
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:  
Given I Landed on Ecommerce Page



  @tag2
  Scenario Outline: Positive Test of Submitting the order 
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And  Checkout <productName> and submit the order
    Then <ValidationMessage> message is displayed on ConfirmationPage

    Examples: 
      | name                   | password     | productName | ValidationMessage      |
      | sd8625060600@gmail.com | S8625060600s | ZARA COAT 3 | THANKYOU FOR THE ORDER.|
    