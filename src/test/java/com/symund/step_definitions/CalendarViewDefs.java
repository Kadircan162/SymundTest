package com.symund.step_definitions;

import com.symund.pages.CalendarViewPage;
import com.symund.pages.DashboardPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class CalendarViewDefs {
    @Given("the user is on the calendar page")
    public void the_user_is_on_the_calendar_page() {
        new DashboardPage().calendarBtn.click();
    }

    @Given("the user opens the calendar views menu on the left panel")
    public void the_user_opens_the_calendar_views_menu_on_the_left_panel() {
        new CalendarViewPage().calViewMenu.click();
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String givenCalViewOption) {
        new CalendarViewPage().openCalendarInGivenOption(givenCalViewOption);
    }

    @Then("verify that {string} calendar view is displayed")
    public void verify_that_daily_calendar_view_is_displayed(String givenCalViewTime) {
        boolean isCalendarDisplayed = new CalendarViewPage().isCalenderDisplayed(givenCalViewTime);
        Assert.assertTrue("Calendar could not displayed",isCalendarDisplayed);
    }

    @Given("the user opens the new event tile")
    public void the_user_opens_the_new_event_tile() {
        new CalendarViewPage().newEventBtn.click();
    }

    @Given("the user input an event title")
    public void the_user_input_an_event_title() {
        new CalendarViewPage().inputNewEventTitle();
    }

    @Given("the user input a new date")
    public void the_user_input_a_new_date() {
        new CalendarViewPage().inputNewDatesForNewEvent();
    }

    @When("the user clicks on the save button")
    public void the_user_clicks_on_the_save_button() {
        new CalendarViewPage().newEventSaveBtn.click();
    }

    @Then("verify that the created event should be displayed on the related day over the {string} Calendar view")
    public void verify_that_the_created_event_should_be_displayed_on_the_related_day_over_the_Calendar_view(String viewOption) {
        new CalendarViewPage().openGivenDateAtMonthlyCalendar();
        boolean doesNewEventExist = new CalendarViewPage().doesNewEventExists();
        Assert.assertTrue("New event could not be found", doesNewEventExist);
    }

    @Then("the user opens the event date")
    public void the_user_opens_the_event_date() {
        new CalendarViewPage().openGivenDateAtMonthlyCalendar();
    }

    @Then("the user opens event")
    public void the_user_opens_event() {
        new CalendarViewPage().openGivenEvent();
    }

    @Then("the user click on more button")
    public void the_user_click_on_more_button() {
        new CalendarViewPage().moreBtn.click();
    }

    @Then("the user clicks on menu button at the event tile")
    public void the_user_clicks_on_menu_button_at_the_event_tile() {
        new CalendarViewPage().eventMenuBtn.click();
    }

    @When("the user clicks on delete button")
    public void the_user_clicks_on_delete_button() {
        new CalendarViewPage().deleteBtn.click();
    }

    @Then("verify that the event was deleted successfully")
    public void verify_that_the_event_was_deleted_successfully() {
        //BrowserUtils.waitFor(2);
        boolean doesEventExist = new CalendarViewPage().doesNewEventExists();
        Assert.assertFalse("Event could not be deleted", doesEventExist);
    }


}
