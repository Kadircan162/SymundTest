package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "settings")
    public WebElement userAvatar;

    @FindBy(linkText = "Log out")
    public WebElement logoutBtn;

    @FindBy(css = "ul[id='appmenu'] a[aria-label='Calendar']")
    public WebElement calendarBtn;

    @FindBy(xpath = "(//*[@data-id='notes'])[1]")
    public WebElement notesButtonHover;

    @FindBy(partialLinkText = "Notes")
    public WebElement notesBtn;

}
