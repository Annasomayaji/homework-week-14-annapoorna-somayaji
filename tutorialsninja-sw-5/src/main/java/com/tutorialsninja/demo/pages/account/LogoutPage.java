package com.tutorialsninja.demo.pages.account;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement logoutHeading;

    @CacheLookup
    @FindBy(linkText= "Continue")
    WebElement continueButton;

    //Methods
 public String getLogOutHeadingText(){
     return getTextFromElement(logoutHeading);
 }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
