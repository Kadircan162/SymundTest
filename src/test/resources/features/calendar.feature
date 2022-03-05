@smoke
Feature: Calendar functionality

  Background:
    Given the user logged in with username "Employee51" and password "Employee123"
    And the user is on the calendar page

  @SYMU-1154
  Scenario Outline: User can display calendar views
    Given the user opens the calendar views menu on the left panel
    When the user clicks on "<viewOption>" button
    Then verify that "<viewOption>" calendar view is displayed

    Examples:
      | viewOption |
      | day        |
      | week       |
      | month      |

  @SYMU-1158
  Scenario: Verify that user can create a new event under the Calendar module
  and see it on the related day through the Monthly Calendar view
    Given the user opens the new event tile
    And the user input an event title
    And the user input a new date
    And the user clicks on the save button
    And the user opens the calendar views menu on the left panel
    And the user clicks on "month" button
    Then verify that the created event should be displayed on the related day over the "Monthly" Calendar view

    @SYMU-1170
    Scenario: Verify that user can delete any event through the Monthly Calendar view
    by clicking on the event and then using “more” option
      Given the user opens the new event tile
      And the user input an event title
      And the user input a new date
      Then the user clicks on the save button
      And the user opens the calendar views menu on the left panel
      And the user clicks on "month" button
      And the user opens the event date
      And the user opens event
      And the user click on more button
      And the user clicks on menu button at the event tile
      When the user clicks on delete button
      Then verify that the event was deleted successfully


