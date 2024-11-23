Feature: Zadanie warsztatowe 2

  Scenario: Buying process
    Given I am on sign in page
    And I log in to my account
    When I navigate to my store main page
    And I choose Hummingbird Printed Sweater
    And I select size M
    And I set quantity 5
    And I add to cart
    And I navigate to checkout
    And I confirm and select address
    And I select delivery option
    And I select payment method
    And I place my order
    And I take a screenshot of my order
    Then I will close the browser