package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[text()='Add User']")
    WebElement addUserHeading;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement userRoleSelectDropDown;

    @CacheLookup
    @FindAll
            ({@FindBy(xpath = "//div[@role='option']")})
    List<WebElement> userRoleOptions;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement typeForHints;
    @CacheLookup
    @FindBy(xpath = "//div[@role='option']/span")
    WebElement autoCompleteHint;
    @CacheLookup
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPassword;
    @CacheLookup//div[@class='oxd-table-card']//div[2]//div[1]
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;


    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement userStatusSelectDropDown;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@role='option']")})
    List<WebElement> statusOptions;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--success']/p[2]")
    WebElement successToasterMessage;


    //Methods
    public String getAddUserHeadingText() {
        return getTextFromElement(addUserHeading);
    }

    public void clickUserRoleDropDown() {
        userRoleSelectDropDown.click();
    }

    public void selectUserRoleFromDropDown(String userRole) {
        for (WebElement option : userRoleOptions) {
            if (option.getText().equals(userRole)) {
                option.click();
                break;
            }
        }
    }

    public WebElement waitExplicitlyForEmployeeNameTextBox(int timeInSeconds) {
        return waitUntilVisibilityOfElementLocated(employeeName, timeInSeconds);
    }

    public void clickOnEmployeeNameTextBox() {
        clickOnElement(employeeName);
    }

    public void enterHintText(String hint) {
        sendTextToElement(typeForHints, hint);
    }

    public void clickOnAutoCompleter() {
        clickOnElement(autoCompleteHint);
    }

    public void enterUserName(String uName) {

        sendTextToElement(userName, uName);
    }

    public void enterPassword(String pwd) {
        sendTextToElement(password, pwd);
    }
    public void enterConfirmPassword(String confirmPwd) {
        sendTextToElement(confirmPassword, confirmPwd);
    }

    public void clickOnSaveButton(){
        saveButton.submit();
    }

    public void clickOnStatusDropDown() {
        clickOnElement(userStatusSelectDropDown);
    }

    public void selectStatusFromDropDown(String status) {
        for (WebElement option : statusOptions) {
            if (option.getText().equals(status)) {
                option.click();
                break;
            }
        }
    }

    public String getSuccessToasterMessageText(){
        return getTextFromElement(successToasterMessage);
    }


}
