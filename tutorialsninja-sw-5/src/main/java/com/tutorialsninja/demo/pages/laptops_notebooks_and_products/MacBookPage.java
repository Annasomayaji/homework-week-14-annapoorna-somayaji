package com.tutorialsninja.demo.pages.laptops_notebooks_and_products;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {
    //Elements

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-4']/h1")
    WebElement macBook;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCArtButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;


    //Methods

    public String getMacBookHeadingText() {
        return getTextFromElement(macBook);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCArtButton);
    }

    public String getSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkInSuccessMessage() {
        clickOnElement(shoppingCartLink);
    }

}
