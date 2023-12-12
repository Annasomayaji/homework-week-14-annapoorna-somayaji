package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span/h6[text()='Dashboard']")
    WebElement dashboardTitle;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileLogo;
    @CacheLookup
    @FindAll
            ({@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li")})
    List<WebElement> userProfileDropDownOptions;

    //Methods

    public void clickOnAdminTab() {
        clickOnElement(adminTab);
    }

    public String getDashboardTitleText() {
        return getTextFromElement(dashboardTitle);
    }

    public void clickOnUserProfileLogo() {
        clickOnElement(userProfileLogo);
    }

    public void clickOnDropDownOptions(String text) {

        for (WebElement e : userProfileDropDownOptions) {
            System.out.println(e.getText());
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }

    }

}
