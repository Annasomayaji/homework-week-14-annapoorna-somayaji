package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement computersPageTitle;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='sublist']//a[normalize-space()='Desktops']")
    WebElement desktopsLink;

    //Methods
    public  String getComputersPageTitleText(){
        return getTextFromElement(computersPageTitle);
    }

    public void clickOnDesktopsLink(){
        clickOnElement(desktopsLink);
    }

}
