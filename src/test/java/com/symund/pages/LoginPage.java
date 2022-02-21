package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement userInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement noticeMsg;

    @FindBy(css = "img[alt='Toggle password visibility']")
    public WebElement eyeButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(css = "#reset-password-submit")
    public WebElement resetPasswordLink;

}
