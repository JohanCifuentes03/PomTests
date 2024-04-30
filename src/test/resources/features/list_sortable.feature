Feature: Sort list in interaction page
  As a user on the demoqa platform
  I want order the items list
  So that I can gain abilities

  Scenario Outline: Order items successfully
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the interactions list page
    When orders the item's list
    Then items should be ordered
    Examples:
      | webBrowser |
      #| CHROME     |
      | EDGE       |