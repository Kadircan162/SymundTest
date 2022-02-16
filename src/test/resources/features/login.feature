Feature: Login Functionality

  @wip @setupAndTearDown
  Scenario Outline: Verify that user can login with valid credentials
    Given user is on the login page
    When Enter valid "<username>" into username inputbox
    And Enter valid "<password>" into password inputbox
    And Click on the login button
    Then Verify that user can login successfully

    Examples:
      | username   | password    |
      | Employee51 | Employee123 |

