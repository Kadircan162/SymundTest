package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.NotesPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class NotesStepDefs {

    NotesPage notesPage=new NotesPage();
    int numberOfNotes;

    @Then("user navigates to notes module")
    public void user_navigates_to_module() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(new NotesPage().notesButtonHover).perform();
        new DashboardPage().notesBtn.click();
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String notes) {
        numberOfNotes = new NotesPage().noteEntries();
        System.out.println("numberOfNotes = " + numberOfNotes);
        new NotesPage().newNoteButton.click();
    }

    @Then("New Note should be created")
    public void new_Note_should_be_created() {
        BrowserUtils.waitFor(2);
        int actualNotes=new NotesPage().noteEntries();
        System.out.println("actualNotes = " + actualNotes);
        boolean newNoteConfirmation = actualNotes > numberOfNotes;
        System.out.println("newNoteConfirmation = " + newNoteConfirmation);
        Assert.assertTrue("New note is not added",newNoteConfirmation);
    }


    @When("User click three dots icon next to the note title")
    public void user_click_three_dots_icon_next_to_the_note_title() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(new NotesPage().threeDotBtn5).click().perform();
    }

    @Then("Verify the opening of dropdown menu")
    public void verify_the_opening_of_dropdown_menu() {
        boolean dropDownMenuDisplayed=notesPage.addToFavorites.isDisplayed();
        Assert.assertTrue(dropDownMenuDisplayed);
    }

    @When("Click on Add to Favorites")
    public void click_on_add_to_favorites() {
        new NotesPage().addToFavorites.click();
    }

    @Then("Verify the yellow star at the beginning of the note title")
    public void verify_the_yellow_star_at_the_beginning_of_the_note_title() {
        BrowserUtils.waitForVisibility(notesPage.star,2);
        Assert.assertTrue(notesPage.star.isDisplayed());
    }
}