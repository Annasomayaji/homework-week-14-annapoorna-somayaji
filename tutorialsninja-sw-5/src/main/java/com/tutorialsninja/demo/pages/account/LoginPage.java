package com.tutorialsninja.demo.pages.account;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    WebElement returningCustomerHeading;

    //Methods
    public String getReturningCustomerHeadingText(){
        return getTextFromElement(returningCustomerHeading);
    }
}
