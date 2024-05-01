Feature: Account Management on DemoQA Platform

  As a user of the DemoQA platform,
  I want to be able to manage my account through a web table interface,
  So that I can easily search, register, update, and delete my account.

  Scenario Outline: Search for Account
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the account management page
    When they search for their account by "<searchCriteria>"
    Then they should see their account details displayed in the web table
    Examples:
      | webBrowser | searchCriteria |
      #| CHROME     | Alden          |
      | EDGE       | Kierra         |

  Scenario Outline: Register a New Account
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the account management page
    When they register a new account with valid data
    Then they should see their data in the table
    Examples:
      | webBrowser |
      #| CHROME     |
      | EDGE       |

  Scenario Outline: Update Account Details
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the account management page
    When the user updates their account's name from "<currentUserName>" to "<newUserName>"
    Then they should see their data updated
    Examples:
      | webBrowser | currentUserName | newUserName |
      #| CHROME     | Cierra          | Johan       |
      | EDGE       | Alden           | David       |

  Scenario Outline: Delete Account
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the account management page
    When they delete their account
    Then they should not see their data in the table
    Examples:
      | webBrowser |
      #| CHROME     |
      | EDGE       |

