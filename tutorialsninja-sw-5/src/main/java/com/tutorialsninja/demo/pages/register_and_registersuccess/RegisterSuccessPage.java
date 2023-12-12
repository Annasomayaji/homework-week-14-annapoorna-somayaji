package com.tutorialsninja.demo.pages.register_and_registersuccess;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterSuccessPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement registerSuccessMessage;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueButton;


    //Methods
    public String getRegisterSuccessMessageText(){
        return getTextFromElement(registerSuccessMessage);
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
