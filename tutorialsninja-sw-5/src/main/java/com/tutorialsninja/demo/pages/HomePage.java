package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    //Elements
    @CacheLookup
    @FindAll({@FindBy(xpath = "//a[@class='see-all']")})
    List<WebElement> showAllOptions;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement deskTops;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement lapTopsAndNoteBooks;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement currencyDropDown;


    @CacheLookup
    @FindAll({@FindBy(xpath = "//ul[@class='dropdown-menu']/li/button")})
    List<WebElement> currencyList;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNoteBooks;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")})
    List<WebElement> myAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    //Methods

    public void mouseHoverAndClickOnDesktops() {
        moveMouseOnElementAndClick(deskTops);
    }

    public List<WebElement> showAllOptionsFromTopNav() {
        return showAllOptions;
    }

    public void mouseHoverAndClickOnLapTopsAndNoteBooks() {
        moveMouseOnElementAndClick(lapTopsAndNoteBooks);
    }

    public void moveMouseAndClickOnComponents() {
        moveMouseOnElementAndClick(components);
    }

    public void mouseHoverAndClickOnShowAllDesktops() {
        moveMouseOnElementAndClick(showAllDesktops);
    }

    public void moveMouseAndClickOnCurrencyDropDown() {
        moveMouseOnElementAndClick(currencyDropDown);
    }

    public List<WebElement> getCurrencyListFromDropDown() {
        return currencyList;
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(showAllLaptopsAndNoteBooks);
    }

    public void clickOnMyAccountLink() {
        waitUntilVisibilityOfElementLocated(myAccountLink, 10);
        clickOnElement(myAccountLink);
    }

    public List<WebElement> getMyAccountOptions() {
        return myAccountOptions;
    }

    //**************************************Methods for repetitive actions*****************
    public void clickOnAllLaptopsAndNoteBooks() {
        moveMouseOnElementAndClick(lapTopsAndNoteBooks);
        clickOnElement(showAllLaptopsAndNoteBooks);

    }
}
