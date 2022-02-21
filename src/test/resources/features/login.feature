Feature: Login Functionality

  @SYMU-962 @setupAndTearDown
  Scenario Outline: Verify that user can login with valid credentials
    Given the user is on the login page
    When the user enters valid "<username>" into username inputbox
    And the user enters valid password "<password>" into password inputbox
    And Click on the login button
    Then Verify that user can login successfully

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |
      | Employee81 | Employee123 |
      | Employee61 | Employee123 |

  @SYMU-968 @setupAndTearDown
  Scenario Outline: Verify that user can login with valid credentials (Pushing enter button on keyboard)
    Given the user is on the login page
    When the user enters valid "<username>" into username inputbox
    And the user enters valid password "<password>" into password inputbox
    And the user hits enter from keyboard
    Then Verify that user can login successfully

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |
      | Employee81 | Employee123 |
      | Employee61 | Employee123 |


  @SYMU-977 @setupAndTearDown
  Scenario Outline: the user cannot login with invalid credentials
    Given the user is on the login page
    And the user enters invalid username "<givenUsername>" or password "<givenPassword>" and click login button
    Then verify that the user cannot login with invalid credentials
    And the notice message "Wrong username or password." is displayed

    Examples:
      | givenUsername | givenPassword |
      | employee51    | Employee123   |
#      | _Employee81   | Employee123   |
#      | Empl@yee61    | Employee123   |
#      | Employee71    | Employee_123  |

  @SYMU-1021
  Scenario: "Please fill out this field" message should be displayed if the password or username is empty
    Given the user is on the login page
    And the user enters valid username "Employee51" into username inputbox and clicks on login button
    Then verify that validation tooltip message "Please fill out this field." pups up for password
    Given the user clears the username input box
    And the user enters a valid password "Employee123" into the password input box and clicks on login button
    Then verify that validation tooltip message "Please fill out this field." pups up for username

  @SYMU-1022
  Scenario: User can see the password in a form of dots by default
    Given the user is on the login page
    And the user enters valid password "Employee123" into password inputbox
    Then verify that the password is displayed as dots

  @SYMU-1023
  Scenario: Verify that user can see the password explicitly if needed
    Given the user is on the login page
    And the user enters valid password "Employee123" into password inputbox
    When the user clicks on eye button in the password input box
    Then verify that the password is displayed explicitly

  @SYMU-1024 @setupAndTearDown
  Scenario: Verify that user can see the "Forgot password?" link on the login page and
  can see the "Reset Password" button on the next page after clicking on forget password link
    Given the user is on the login page
    Then verify the forgot password link is displayed
    When the user clicks on forgot password link
    Then verify that reset password link is displayed

  @SYMU-1025 @setupAndTearDown
  Scenario: Verify that user can see valid placeholders on Username and Password fields
    Given the user is on the login page
    Then verify that the placeholders for username and password inputbox are "Username or email" and "Password"








