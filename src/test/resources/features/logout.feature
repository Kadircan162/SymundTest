@SYMU-972
Feature: Logout functionality

  Background:
    Given the user logged in with username "Employee51" and password "Employee123"

  @smoke @SYMU-970 @setupAndTearDown
  Scenario: the user can log out and ends up in log in page
    Given the user opens the user avatar and clicks on logout button
    And verify that the user ends up in the login page

  @SYMU-973 @setupAndTearDown
  Scenario: User cannot go to home page again by clicking step back button after successfully logged out
    Given the user opens the user avatar and clicks on logout button
    And verify that the user ends up in the login page
    When the user navigates back to the homepage
    Then verify that user can not go to home page again after logged out