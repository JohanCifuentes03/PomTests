Feature: User Registration Form
  As a new user on the demoqa platform
  I want to fill out a user registration form
  So that I can access the platform's services


  @happy_path
  Scenario Outline: User successfully registers
    Given the user is on the demoqa main page using "<webBrowser>"
    And navigates to the registration form
    When they enter their data correctly
    And submit the form
    Then they should see a welcome message
    Examples:
      | webBrowser |
      | CHROME     |
      | EDGE       |

