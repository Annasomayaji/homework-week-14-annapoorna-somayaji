package com.tutorialsninja.demo.pages.desktops_and_products;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsProductsPage extends Utility {
    //Elements
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    WebElement hP_LP3065P;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']/span")
    WebElement deliveryDateDropDown;

    @CacheLookup
    @FindBy(xpath = "//thead//th[@class='picker-switch'])[1]")
    WebElement monthAndYear;
    @CacheLookup
    @FindBy(xpath = "//thead//th[@class='picker-switch'])[1]/following-sibling::th")
    WebElement monthYearForwardArrow;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='datepicker-days']//td")})
    List<WebElement> allDatesOnCalender;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;

    //Methods

    public void enterQuantity(String qty) {
        quantity.clear();
        sendTextToElement(quantity, qty);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkInSuccessMessage() {
        clickOnElement(shoppingCartLink);
        ;
    }


}
