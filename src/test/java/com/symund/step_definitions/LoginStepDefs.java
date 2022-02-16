package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Enter valid {string} into username inputbox")
    public void enter_valid_into_username_inputbox(String username) {
        new LoginPage().userInput.sendKeys(username);
    }

    @When("Enter valid {string} into password inputbox")
    public void enter_valid_into_password_inputbox(String password) {
        new LoginPage().passwordInput.sendKeys(password);
    }

    @When("Click on the login button")
    public void click_on_the_login_button() {
        new LoginPage().loginBtn.click();
    }

    @Then("Verify that user can login successfully")
    public void verify_that_user_can_login_successfully() {
        String expectedPageTitle = "Dashboard - Symund - QA";
        String actualPageTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

}
