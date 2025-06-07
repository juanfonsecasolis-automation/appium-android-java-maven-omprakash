Feature: Login Functionality

@login
Scenario: Verify error message is displayed when I enter incomplete credentials
    Given user navigates to the login page
    When user tries to log in using username "<username>" and password "<password>"
    Then user receives error message "<errorMessage>"

    Examples:
    | username  | password  | errorMessage          |
    |           |           | Username is required  |
    #| username  |           | Enter Password        |