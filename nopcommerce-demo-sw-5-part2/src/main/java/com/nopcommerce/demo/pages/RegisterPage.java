package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement registerTitle;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    @CacheLookup
    @FindBy(id = "FirstName-error")
    WebElement firstNameError;

    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement lastNameError;

    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement emailError;

    @CacheLookup
    @FindBy(id = "Password-error")
    WebElement passwordError;

    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordError;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement femaleRadioButton;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDateDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement DateOfBirthMonthDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement DateOfBirthYearDropDown;

    @CacheLookup
    @FindBy(id="Email")
    WebElement emailId;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Your registration completed']")
    WebElement registrationSuccessMessage;

    //Methods

    public String getRegisterTitleText() {
        return getTextFromElement(registerTitle);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    public String getFirstNameErrorText() {
        return getTextFromElement(firstNameError);
    }

    public String getLastNameErrorText() {
        return getTextFromElement(lastNameError);
    }

    public String getEmailErrorText() {
        return getTextFromElement(emailError);
    }

    public String getPasswordErrorText() {
        return getTextFromElement(passwordError);
    }

    public String getConfirmPasswordErrorText() {
        return getTextFromElement(confirmPasswordError);
    }

    public void clickOnFemaleRadioButton() {
        clickOnElement(femaleRadioButton);
    }

    public void enterFirstName(String name){
        sendTextToElement(firstName,name);
    }

    public void enterLastName(String name){
        sendTextToElement(lastName,name);
    }

    public void selectDateOfBirthDateFromDropDown(String date){
       selectByVisibleTextFromDropDown(dateOfBirthDateDropDown,date);
    }
    public void selectDateOfBirthMonthFromDropDown(String month){
       selectByVisibleTextFromDropDown(DateOfBirthMonthDropDown,month);
    }
    public void selectDateOfBirthYearFromDropDown(String year){
       selectByVisibleTextFromDropDown(DateOfBirthYearDropDown,year);
    }

    public void enterEmail(String email){
        sendTextToElement(emailId,email);
    }

    public void enterPassword(String pwd){
        sendTextToElement(password,pwd);
    }

    public void enterConfirmPassword(String confirmPwd){
        sendTextToElement(confirmPassword,confirmPwd);
    }

    public String getRegistrationSuccessMessageText(){
        return getTextFromElement(registrationSuccessMessage);
    }

}
