package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotesPage extends BasePage {

    @FindBy(id = "notes_new_note")
    public WebElement newNoteButton;


    @FindBy(xpath = "(//button[@aria-label='Actions'])[3]")
    public WebElement threeDots1;

    @FindBy(xpath = "(//div[@class='action-item'])[3]")
    public WebElement threeDots2;

    @FindBy(xpath = "(//button[@aria-haspopup='true'])[3]")
    public WebElement threeDots3;

    @FindBy(xpath = "//*[@class='app-navigation-toggle']")
    public WebElement sideMenuBtn;

    @FindBy(xpath = "//li[@class='app-navigation-entry router-link-exact-active active']//*[@class='app-navigation-entry__utils']")
    public WebElement threeDots4;

    @FindBy(xpath = "//li[@class='app-navigation-entry active']//*[@aria-label]")
    public WebElement threeDotBtn5;

    @FindBy(xpath = " //span[contains(text(),'Add to favorites')]")
    public WebElement addToFavorites;

    @FindBy(xpath = "//div[@class='app-navigation-entry-icon nav-icon icon-starred']")
    public WebElement star;



    public int noteEntries() {
        List<WebElement> notes = Driver.get().findElements(By.xpath("//span[@class='app-navigation-entry__title']"));
        return notes.size();
    }

}
