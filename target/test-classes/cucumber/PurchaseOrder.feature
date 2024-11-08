
Feature: Purchase order from Ecomerce
  I want to use this template for my feature file
  Background:
  Given I landed to ECommerce page

Scenario Outline: Positive Test of Purchasing Order
    Given I Logged in with username as <username> and password as <password>
    When I add product <productname> to cart
    And verify <productname> added in cart page
    And validate user click on submit button in checkout page
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username  | password | productname  |
      | beherajeevan25@gmail.com | Jeevan99@ | ZARA COAT 3 |
