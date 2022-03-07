Feature: Notes Functions

  Background:
    Given the user logged in with username "Employee51" and password "Employee123"
    When user navigates to notes module

  Scenario: User can create a new note
    When User clicks on "New note" button
    Then New Note should be created

  @wip
  Scenario: User can add any note to the favorites
    Given User clicks on "New note" button
    When User click three dots icon next to the note title
#    Then Verify the opening of dropdown menu
#    When Click on Add to Favorites
#    Then Verify the yellow star at the beginning of the note title