package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    //Elements

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    //    @CacheLookup
//    @FindBy(className = "orangehrm-login-logo")
//    WebElement hrmLogo;
    @CacheLookup
    @FindBy(xpath = "(//img[@alt='client brand banner'])[1]")
    WebElement hrmLogo;

    @CacheLookup
    @FindBy(xpath = "//h5[text()='Login']")
    WebElement loginPanelHeading;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Required'][1]")
    WebElement errorMessageForUserNameRequiredField;

    @CacheLookup
    @FindBy(xpath = "(//span[text()='Required'])[2]")
    WebElement errorMessageForPasswordRequiredField;
    @CacheLookup
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement errorMessageForInvalidLogin;


    //Methods
    public void enterUserName(String text) {
        sendTextToElement(userName, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public WebElement getLogoElement() {
        return hrmLogo;
    }

    public String getLoginPanelHeadingText() {
        return getTextFromElement(loginPanelHeading);
    }

    public void loginToApplication(String name, String pwd) {
        sendTextToElement(userName, name);
        sendTextToElement(password, pwd);
        clickOnLoginButton();
    }

    public String getErrorMessageForUserNameRequiredField() {
        return errorMessageForUserNameRequiredField.getText();
    }

    public String getErrorMessageForPasswordRequiredField() {
        return errorMessageForUserNameRequiredField.getText();
    }

    public String getErrorMessageForInvalidCredentials() {
        return errorMessageForInvalidLogin.getText();
    }

}
