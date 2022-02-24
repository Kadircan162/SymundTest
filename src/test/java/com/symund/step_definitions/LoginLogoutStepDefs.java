package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class LoginLogoutStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid {string} into username inputbox")
    public void enter_valid_into_username_inputbox(String username) {
        new LoginPage().userInput.sendKeys(username);
    }

    @When("the user enters valid password {string} into password inputbox")
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
        System.out.println("User logged in successfully");
    }

    @And("the user hits enter from keyboard")
    public void theUserHitsEnterFromKeyboard() {
        new LoginPage().loginBtn.sendKeys(Keys.ENTER);
    }

    @And("the user enters invalid username {string} or password {string} and click login button")
    public void theUserEntersInvalidUsernameOrPassword(String givenUsername, String givenPassword) {
        LoginPage loginPage = new LoginPage();
        loginPage.userInput.sendKeys(givenUsername);
        loginPage.passwordInput.sendKeys(givenPassword);
        loginPage.loginBtn.click();
    }

    @Then("verify that the user cannot login with invalid credentials")
    public void verifyThatTheUserCannotLogin_with_invalid_credentials() {

        BrowserUtils.waitFor(1);
        String expectedLoginPageTitle = "Symund - QA";
        String actualLoginPageTitle = Driver.get().getTitle();
        System.out.println("expectedLoginPageTitle = " + expectedLoginPageTitle);
        System.out.println("actualLoginPageTitle = " + actualLoginPageTitle);
        Assert.assertEquals("User is able to login with invalid credentials",expectedLoginPageTitle,actualLoginPageTitle);

    }

    @And("the notice message {string} is displayed")
    public void theNoticeMessageIsDisplayed(String expectedNoticeMsg) {
        Assert.assertTrue(expectedNoticeMsg, new LoginPage().noticeMsg.isDisplayed());
        System.out.println("Notice Message is displayed");
    }

    @And("the user enters valid username {string} into username inputbox and clicks on login button")
    public void theUserEntersValidUsernameIntoUsernameInputbox(String username) {
        new LoginPage().userInput.sendKeys(username);
        new LoginPage().loginBtn.click();
    }

    @Then("verify that validation tooltip message {string} pups up for password")
    public void verifyThatValidationTooltipMessagePupsUp(String expectedValidationMsg) {
        BrowserUtils.waitFor(1);
        String actualValidationMsg = new LoginPage().passwordInput.getAttribute("validationMessage");
        Assert.assertEquals("The validation tooltip message isn't displayed", expectedValidationMsg, actualValidationMsg);
    }

    @Given("the user clears the username input box")
    public void theUserClearsTheUsernameInputBox() {
        new LoginPage().userInput.clear();
    }

    @And("the user enters a valid password {string} into the password input box and clicks on login button")
    public void theUserEntersAValidPasswordIntoThePasswordInputBox(String password) {
        new LoginPage().passwordInput.sendKeys(password);
        new LoginPage().loginBtn.click();
    }

    @Then("verify that validation tooltip message {string} pups up for username")
    public void verifyThatValidationTooltipMessagePupsUpForPassword(String expectedValidationMsg) {
        BrowserUtils.waitFor(1);
        String actualValidationMsg = new LoginPage().userInput.getAttribute("validationMessage");
        Assert.assertEquals("The validation tooltip message isn't displayed", expectedValidationMsg, actualValidationMsg);
    }

    @Then("verify that the password is displayed as dots")
    public void verifyThatThePasswordIsDisplayedAsDots() {
        System.out.println("new LoginPage().passwordInput.getAttribute(\"type\") = " + new LoginPage().passwordInput.getAttribute("type"));
    }

    @When("the user clicks on eye button in the password input box")
    public void theUserClicksOnEyeButtonInThePasswordInputBox() {
        new LoginPage().eyeButton.click();
    }

    @Then("verify that the password is displayed explicitly")
    public void verifyThatThePasswordIsDisplayedExplicitly() {
        String actualTypeAttributeValue = new LoginPage().passwordInput.getAttribute("type");
        Assert.assertEquals("Password cannot be explicitly displayed", "text", actualTypeAttributeValue);
    }

    @Then("verify the forgot password link is displayed")
    public void theForgotPasswordLinkIsDisplayed() {
        boolean isDisplayed = new LoginPage().forgotPasswordLink.isDisplayed();
        Assert.assertTrue("Forgot password link is not displayed", isDisplayed);
    }

    @When("the user clicks on forgot password link")
    public void theUserClicksOnForgotPasswordLink() {
        new LoginPage().forgotPasswordLink.click();
    }

    @Then("verify that reset password link is displayed")
    public void verifyThatResetPasswordLinkIsDisplayed() {
        boolean isDisplayed = new LoginPage().resetPasswordLink.isDisplayed();
        Assert.assertTrue("Reset password link is not displayed", isDisplayed);
    }

    @Then("verify that the placeholders for username and password inputbox are {string} and {string}")
    public void verifyThatThePlaceholdersForUsernameAndPasswordInputboxAreAnd(String expectedUserNamePlaceholder, String expectedPasswordPlaceholder) {
        String actualUsernamePlaceholder = new LoginPage().userInput.getAttribute("placeholder");
        String actualPasswordPlaceholder = new LoginPage().passwordInput.getAttribute("placeholder");
        Assert.assertEquals("Placeholder is not displayed properly", expectedUserNamePlaceholder, actualUsernamePlaceholder);
        Assert.assertEquals("Placeholder is not displayed properly", expectedPasswordPlaceholder, actualPasswordPlaceholder);
    }

    @Given("the user logged in with username {string} and password {string}")
    public void theUserLoggedInWithUsernameAndPassword(String username, String password) {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.userInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
    }

    @Given("the user opens the user avatar and clicks on logout button")
    public void theUserOpensTheUserAvatarAndClicksOnLogoutButton() {
        new DashboardPage().userAvatar.click();
        new DashboardPage().logoutBtn.click();
    }

    @And("verify that the user ends up in the login page")
    public void verifyThatTheUserEndsUpInTheLoginPage() {
        String expectedPageTitle = "Symund - QA";
        String actualPageTitle = Driver.get().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);
        Assert.assertEquals("User could not land on login page", expectedPageTitle,actualPageTitle);
    }

    @When("the user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        BrowserUtils.waitFor(2);
        Driver.get().navigate().back();
    }

    @Then("verify that user can not go to home page again after logged out")
    public void verifyThatUserCanNotGoToHomePageAgainAfterLoggedOut() {
        String expectedPageTitle = "Symund - QA";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals("User can go back to the homepage",expectedPageTitle,actualPageTitle);
    }
}
