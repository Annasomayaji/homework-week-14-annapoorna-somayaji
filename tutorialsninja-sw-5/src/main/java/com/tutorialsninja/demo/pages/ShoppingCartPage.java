package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement shoppingCartHeading;

    @CacheLookup
    @FindBy(xpath = "//table[@class='table table-striped']//td[@class='text-left']/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "(//td[@class='text-left'])[6]")
    WebElement modelName;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement getProductNameMacBook;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement updateTab;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement cartUpdateSuccessMessage;
    @CacheLookup
    @FindBy(linkText = "Checkout")
    WebElement checkOutButton;


    //Methods
    public String getShoppingCartHeadingText() {
        return getTextFromElement(shoppingCartHeading);
    }

    public String getProductNameText() {
        return getTextFromElement(productName);
    }

    public String getModelNameText() {
        return getTextFromElement(modelName);
    }

    public String getTotalText() {
        return getTextFromElement(total);
    }

    public String getProductNameMacBookText() {
        return getTextFromElement(getProductNameMacBook);
    }

    public void updateQuantity(String text) {
        quantity.clear();
        sendTextToElement(quantity, text);
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String getUpdateSuccessMessageText() {
        return getTextFromElement(cartUpdateSuccessMessage);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }
}
