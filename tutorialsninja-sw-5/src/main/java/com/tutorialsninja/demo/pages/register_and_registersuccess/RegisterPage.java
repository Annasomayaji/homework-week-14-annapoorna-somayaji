package com.tutorialsninja.demo.pages.register_and_registersuccess;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement registerPageHeading;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindAll
            ({@FindBy(xpath = "//input[@name='newsletter']")})
    List<WebElement> newLetterRadioButtons;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    //Methods

    public String getRegisterPageHeadingText() {
        return getTextFromElement(registerPageHeading);
    }

    public void enterFirstName(String text) {
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text) {
        sendTextToElement(lastName, text);
    }

    public void enterEmail(String text) {
        sendTextToElement(email, text);
    }

    public void enterPhone(String text) {
        sendTextToElement(phone, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void enterConfirmPassword(String text) {
        sendTextToElement(confirmPassword, text);
    }

    public void clickOnNewsLetterRadioButton(String text) {
        List<WebElement> radioButton = newLetterRadioButtons;
        for (WebElement r : radioButton) {
            if (r.getText().equalsIgnoreCase(text)) {
                r.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }


}
