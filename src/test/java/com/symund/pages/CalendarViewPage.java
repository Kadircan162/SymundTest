package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CalendarViewPage extends BasePage {


    @FindBy(css = "[class^='icon action-item__menutoggle icon-view-']")
    public WebElement calViewMenu;

    @FindBy(xpath = "//li[@class='action active']")
    public WebElement dayBtn;

    @FindBy(xpath = "//ul/li[@class='action'][1]")
    public WebElement weekBtn;

    @FindBy(xpath = "//ul/li[@class='action'][2]")
    public WebElement monthBtn;

    @FindBy(css = ".button.primary.new-event")
    public WebElement newEventBtn;

    @FindBy(css = "[placeholder='Event title']")
    public WebElement eventTitleInputBox;

    @FindBy(xpath = "(//input[@name='date'][@class='mx-input'])[2]")
    public WebElement dateFrom;

    @FindBy(xpath = "(//input[@name='date'][@class='mx-input'])[3]")
    public WebElement dateTo;

    @FindBy(css = ".event-popover__buttons>.primary")
    public WebElement newEventSaveBtn;

    @FindBy(css = ".event-popover__buttons>button")
    public WebElement moreBtn;

    @FindBy(xpath = "//*[@class='action-item app-sidebar-header__menu']//*[starts-with(@class,'icon action-item__menutoggle')]")
    public WebElement eventMenuBtn;

    @FindBy(xpath = "//*[@class='action-button__icon icon-delete']")
    public WebElement deleteBtn;


    public void openCalendarInGivenOption(String viewOption) {

        switch (viewOption.toLowerCase().trim()) {
            case "day":
                dayBtn.click();
                break;
            case "week":
                weekBtn.click();
                break;
            case "month":
                monthBtn.click();
                break;
        }
    }

    public boolean isCalenderDisplayed(String time) {
        switch (time.toLowerCase().trim()) {
            case ("day"):
                if (Driver.get().getCurrentUrl().equals("https://qa.symund.com/index.php/apps/calendar/timeGridDay/now")) {
                    return true;
                }
            case ("week"):
                if (Driver.get().getCurrentUrl().equals("https://qa.symund.com/index.php/apps/calendar/timeGridWeek/now")) {
                    return true;
                }
            case ("month"):
                if (Driver.get().getCurrentUrl().equals("https://qa.symund.com/index.php/apps/calendar/dayGridMonth/now")) {
                    return true;
                }
            default:
                return false;
        }
    }

    static String assignedDay;
    static String assignedTitle;

    public void inputNewEventTitle() {
        assignedTitle = "Symund Test" + new Random().nextDouble();//here random class is used to enter different event title for each time
        eventTitleInputBox.sendKeys(assignedTitle);
    }

    public void inputNewDatesForNewEvent() {

        String actualDateFrom = dateFrom.getAttribute("value");
        System.out.println("actualDateFrom = " + actualDateFrom);

        String actualDateTo = dateTo.getAttribute("value");
        System.out.println("actualDateTo = " + actualDateTo);

        String currentDay = dateFrom.getAttribute("value").replaceAll("[^0-9]", "").substring(2, 4);
        assignedDay = Integer.parseInt(currentDay) + 1 + "";//new event will be on next day

        System.out.println("assignedDay = " + assignedDay);

        String newDateFrom = actualDateFrom.substring(0, 9) + assignedDay + actualDateFrom.substring(10);

        String newDateTo = actualDateTo.substring(0, 7) + assignedDay + actualDateTo.substring(8);

        System.out.println("newDateFrom = " + newDateFrom);
        System.out.println("newDateTo = " + newDateTo);

        dateFrom.click();
        dateFrom.clear();
        dateFrom.sendKeys(newDateFrom);
        dateTo.click();
        dateTo.clear();
        dateTo.sendKeys(newDateTo);

    }

    public boolean doesNewEventExists() {
        BrowserUtils.waitFor(1);
        List<WebElement> newEventList = Driver.get().findElements(By.cssSelector(".fc-event-title.fc-sticky"));//if no elements found then returns null
        System.out.println("assignedDay = " + assignedDay);
        System.out.println("newEventList.size() = " + newEventList.size());
        for (WebElement eachEvent : newEventList) {
            System.out.println("eachEvent.getText() = " + eachEvent.getText());
            if (eachEvent.getText().equals(assignedTitle)) {
                return true;
            }
        }
        return false;

    }

    public void openGivenDateAtMonthlyCalendar() {
        WebElement newEventDateButton = Driver.get().findElement(By.xpath("//*[@data-navlink='{\"date\":\"2022-03-0" + assignedDay + "\",\"type\":\"day\"}']"));
        newEventDateButton.click();
    }

    public void openGivenEvent() {
        List<WebElement> newEventList = Driver.get().findElements(By.cssSelector(".fc-event-title.fc-sticky"));
        System.out.println("newEventList.size() = " + newEventList.size());

        for (WebElement eachEvent : newEventList) {
            System.out.println("eachEvent.getText() = " + eachEvent.getText());
            if (eachEvent.getText().equals(assignedTitle)) {
                eachEvent.click();
                break;
            }
        }

    }

}
