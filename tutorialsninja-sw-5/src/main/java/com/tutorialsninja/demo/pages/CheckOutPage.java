package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOutPage extends Utility {
    //Elements

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement checkOutHeading;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerHeading;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//input[@name='account']")})
    List<WebElement> radioButton;
    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;

    //Billing Details Elements

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement phone;
    @CacheLookup
    @FindBy(id = "input-payment-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-payment-confirm")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionStateDropDown;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class='pull-right']/input[@value='Continue']")
    WebElement continueButtonBillingDetails;

    //Payment Method Elements

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement sendCommentsOnOrdersTextArea;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndConditionsCheckBox;
    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement continueButtonInPaymentMethod;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentRequiredWarningMessage;


    //Methods
    public String getCheckOutHeadingText() {
        return getTextFromElement(checkOutHeading);
    }

    public String getNewCustomerHeadingText() {
        waitUntilVisibilityOfElementLocated(newCustomerHeading, 5);
        return getTextFromElement(newCustomerHeading);
    }

    public void clickOnRadioButton(String text) {
        List<WebElement> rButtons = radioButton;
        for (WebElement r : rButtons) {
            if (r.getText().equalsIgnoreCase(text)) {
                r.click();
                break;
            }
        }
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
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

    public void enterAddress(String text) {
        sendTextToElement(address, text);
    }

    public void enterCity(String text) {
        sendTextToElement(city, text);
    }

    public void enterPostCode(String text) {
        sendTextToElement(postCode, text);
    }

    public void selectCountryFromDropDown(String text) {
        selectByVisibleTextFromDropDown(countryDropDown, text);
    }

    public void selectRegionOrStateFromDropDown(String text) {
        selectByVisibleTextFromDropDown(regionStateDropDown, text);
    }

    public void clickOnCheckBox() {
        clickOnElement(checkBox);
    }

    public void clickOnContinueButtonInBillingDetails() {
        clickOnElement(continueButtonBillingDetails);
    }

    public void enterCommentsAboutOrder(String text) {
        sendTextToElement(sendCommentsOnOrdersTextArea, text);
    }

    public void clickOnTermsAndConditionsCheckBox() {
        clickOnElement(termsAndConditionsCheckBox);
    }

    public void clickOnContinueButtonInPaymentMethod() {
        clickOnElement(continueButtonInPaymentMethod);
    }

    public String getWarningMessageText() {
        return getTextFromElement(paymentRequiredWarningMessage);
    }


}
