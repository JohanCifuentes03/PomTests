Feature: Interact with alerts

  As a user on the demoqa platform,
  I want to handle alerts effectively,
  So that I can continue using the platform without interruption.

  Scenario Outline: Interact with alerts successfully
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the alerts page
    When interacts with all alerts
    Then should see a green message confirming successful interaction

    Examples:
      | webBrowser |
      #| CHROME     |
      | EDGE       |
