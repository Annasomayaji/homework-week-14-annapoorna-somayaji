package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
    WebElement newLoginLink;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logoutLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersLink;


    //Methods
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public String getLogOutLinkText() {
        return getTextFromElement(logoutLink);
    }

    public void clickOnLogoutLink() {
        clickOnElement(logoutLink);
    }

    public String getFromLoginLinkText() {
        waitUntilVisibilityOfElementLocated(loginLink, 5);
        return getTextFromElement(loginLink);
    }

    public String getTextFromLoginLink() {
        return getTextFromElement(newLoginLink);
    }


    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }

    public void clickOnComputerLink() {
        clickOnElement(computersLink);
    }

}

