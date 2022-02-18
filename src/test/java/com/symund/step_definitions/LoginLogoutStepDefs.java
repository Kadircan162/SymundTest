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
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

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

    @And("the user hits enter from keyboard")
    public void theUserHitsEnterFromKeyboard() {
        new LoginPage().loginBtn.sendKeys(Keys.ENTER);
    }

    @Then("Verify that user can login successfully")
    public void verify_that_user_can_login_successfully() {
        String expectedPageTitle = "Dashboard - Symund - QA";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        System.out.println("User logged in successfully");
    }

    @Given("the user logged in with username {string} and password {string}")
    public void theUserLoggedIn(String username, String password) {
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
        String expectedLoginPageTitle = "Symund - QA";
        String actualLoginPageTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
        System.out.println("User logged out successfully");
    }

    @When("the user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        BrowserUtils.waitFor(1);
        Driver.get().navigate().back();
    }

    @Then("verify that user can not go to home page again after logged out")
    public void verifyThatUserCanNotGoToHomePageAgainAfterLoggedOut() {
        String expectedLoginPageTitle = "Symund - QA";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedLoginPageTitle, actualPageTitle);
        System.out.println("The user stays at the login page when trying to navigate back");
    }

    Map<String,String> givenCredentials;

    @And("the user enters invalid username or password and click login button")
    public void theUserEntersUsernameAndPassword(Map<String,String> givenCredentials) {
        this.givenCredentials = givenCredentials;
        System.out.println("givenCredentials.get(\"username\") = " + givenCredentials.get("givenUsername"));
        System.out.println("givenCredentials.get(\"password\") = " + givenCredentials.get("givenPassword"));
        LoginPage loginPage = new LoginPage();
        if(givenCredentials.get("givenUsername") != null || !givenCredentials.get("givenUsername").isEmpty()){
            loginPage.userInput.sendKeys(givenCredentials.get("givenUsername"));
            System.out.println("username sent");
        }
        if(givenCredentials.get("givenPassword") != null || !givenCredentials.get("givenPassword").isEmpty()){
            loginPage.passwordInput.sendKeys(givenCredentials.get("givenPassword"));
            System.out.println("password sent");
        }

        loginPage.loginBtn.click();

    }
    @Then("verify that the user cannot login with invalid credentials")
    public void verifyThatTheUserCannotLogin_with_invalid_credentials(List<String> validCredentials) {
        BrowserUtils.waitFor(2);
        String actualLoginPageTitle = Driver.get().getTitle();

        if(!validCredentials.contains(this.givenCredentials.get("givenUsername")) ||
                !validCredentials.contains(this.givenCredentials.get("givenPassword"))){//that means given credentials are invalid

            String expectedLoginPageTitle = "Symund - QA";
            System.out.println("expectedLoginPageTitle = " + expectedLoginPageTitle);
            System.out.println("actualLoginPageTitle = " + actualLoginPageTitle);
            System.out.println("this.givenCredentials = " + this.givenCredentials);
            Assert.assertEquals("User is able to login with invalid credentials",expectedLoginPageTitle,actualLoginPageTitle);

        }

    }
}
