Feature: Select date in calendar

  As a user on the demoqa platform,
  I want to reserve a date,
  So that I can use that time as I want.

  Scenario Outline: Reserve date successfully
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the datepicker page
    When the user reserves a date
    Then the date should be successfully reserved

    Examples:
      | webBrowser |
      #| CHROME     |
      | EDGE       |
