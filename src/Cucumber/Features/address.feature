Feature: Adding new address

  Scenario Outline: user can add new address
    Given I am on My Store main page
    When I navigate to log in page
    And I log in
    And I navigate to Addresses
    And I can see existing addresses
    And I navigate to create new address
    And I enter alias <alias> first name <firstName> last name <lastName> address <address> city <city> post code <postCode> country <country> phone <phone>
    Then I can see added alias <alias> first name <firstName> last name <lastName> address <address> city <city> post code <postCode> country <country> phone <phone>
    And I close the browser

    Examples:
      | alias | firstName | lastName | address | city | postCode | country          | phone |
      | Home  | Sara     | Mara    | Kąkolska   | Pcim | 22-222    | "United Kingdom" | 333333333  |
