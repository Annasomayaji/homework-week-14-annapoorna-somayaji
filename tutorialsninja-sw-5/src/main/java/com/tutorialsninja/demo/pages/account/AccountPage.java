package com.tutorialsninja.demo.pages.account;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2[text()='My Account']")
    WebElement myAccountHeading;

    @CacheLookup
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    //Methods

    public String getMyAccountHeadingText() {
        return getTextFromElement(myAccountHeading);
    }

    public void clickOnMyAccountLink(){
        clickOnElement(myAccountLink);
    }

}
