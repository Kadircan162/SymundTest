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
#      | givenUsername | <givenUsername> |
#      | givenPassword | <givenPassword> |
    Then verify that the user cannot login with invalid credentials
#     validUsername
      | Employee11    |
      | Employee21    |
      | Employee31    |
      | Employee41    |
      | Employee51    |
      | Employee61    |
      | Employee71    |
      | Employee81    |
      | Employee91    |
      | Employee101   |
      | Employee111   |
      | Employee121   |
      | Employee131   |
      | Employee141   |
#     validPassword
      | Employee123   |

    Examples:
      | givenUsername | givenPassword |
      | employee51    | Employee123   |
#      | _Employee81   | Employee123   |
#      | Empl@yee61    | Employee123   |
#      |               | Employee123   |
#      | Employee71    | Employee_123  |
#      | Employee81    |               |




