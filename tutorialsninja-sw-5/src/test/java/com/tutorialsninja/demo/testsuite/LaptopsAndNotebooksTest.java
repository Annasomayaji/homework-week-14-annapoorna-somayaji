package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.CheckOutPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.laptops_notebooks_and_products.LapTopsAndNoteBooksPage;
import com.tutorialsninja.demo.pages.laptops_notebooks_and_products.MacBookPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    LapTopsAndNoteBooksPage lapTopsAndNoteBooksPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        lapTopsAndNoteBooksPage = new LapTopsAndNoteBooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLapTopsAndNoteBooks();

//        1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopsAndNotebooks();

        //Store elements in an array and use Collections sort method before filter
        List<WebElement> beforeFilterPrice = lapTopsAndNoteBooksPage.getFilteredProductList();
        List<Double> beforeFilterPriceList = new ArrayList<>();
        String[] priceArray;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : beforeFilterPrice) {
            priceArray = p.getText().split("\n");
            System.out.println(priceArray[0]); //for debug purpose
            String number = priceArray[0].replace("$", "");
            String num = number.replace(",", "");
            beforeFilterPriceList.add(Double.valueOf(num));
        }

        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);

//        1.3 Select Sort By "Price (High > Low)"
        lapTopsAndNoteBooksPage.selectFromSortByFilter("Price (High > Low)");

        List<WebElement> afterFilterPrice = lapTopsAndNoteBooksPage.getFilteredProductList();
        ArrayList<Double> afterFilterPriceList = new ArrayList<>();

        String[] priceArrayAfterFilter;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : afterFilterPrice) {
            // System.out.println(p);
            priceArrayAfterFilter = p.getText().split("\n");
            String number = priceArrayAfterFilter[0].replace("$", "");
            String num = number.replace(",", "");
            afterFilterPriceList.add(Double.valueOf(num));
        }

//        1.4 Verify the Product price will arrange in High to Low order.

        Assert.assertEquals(afterFilterPriceList, beforeFilterPriceList, "The products are not in descending order.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //select Pound Sterling from currency dropdown
        homePage.moveMouseAndClickOnCurrencyDropDown();
        List<WebElement> allCurrencies = homePage.getCurrencyListFromDropDown();
        for (WebElement currency : allCurrencies) {
            if (currency.getText().equalsIgnoreCase("£Pound Sterling")) {
                currency.click();
                break;
            }
        }

//        2.1 Mouse hover on Laptops & Notebooks Tab and click
//        2.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnAllLaptopsAndNoteBooks();

//        2.3 Select Sort By "Price (High > Low)"
        lapTopsAndNoteBooksPage.selectFromSortByFilter("Price (High > Low)");

//        2.4 Select Product “MacBook”
        lapTopsAndNoteBooksPage.clickOnMacBook();

//        2.5 Verify the text “MacBook
        Assert.assertEquals(macBookPage.getMacBookHeadingText(), "MacBook", "Page heading is incorrect.");

//        2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCartButton();

//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(macBookPage.getSuccessMessageText().contains("shopping cart"));

//        2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCartLinkInSuccessMessage();

//        2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.getShoppingCartHeadingText().contains("Shopping Cart"));

//        2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductNameMacBookText(), "MacBook", "Wrong product name");

//        2.11 Change Quantity "2"
        shoppingCartPage.updateQuantity("2");

//        2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTab();

//        2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.getUpdateSuccessMessageText().contains("Success: You have modified your shopping cart!"), "Cart update success message is incorrect.");

//        2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalText(), "£737.45", "Total is incorrect.");

//        2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();

//        2.16 Verify the text “Checkout”
        Assert.assertEquals(checkOutPage.getCheckOutHeadingText(), "Checkout", "Incorrect pageHeading.");

//        2.17 Verify the Text “New Customer”
        //Thread.sleep(5000);
        //Add explicit wait for New customer heading element
        Assert.assertEquals(checkOutPage.getNewCustomerHeadingText(), "New Customer", "New customer heading is incorrect.");

//        2.18 Click on “Guest Checkout” radio button
        checkOutPage.clickOnRadioButton("Guest Checkout");

//        2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButton();

//        2.20 Fill the mandatory fields
        checkOutPage.enterFirstName("Annu");
        checkOutPage.enterLastName("Som");
        checkOutPage.enterPassword("Password1");
        checkOutPage.enterConfirmPassword("Password1");
        checkOutPage.enterEmail("abc@gmail.com");
        checkOutPage.enterPhone("07712345920");
        checkOutPage.enterAddress("5 high view");
        checkOutPage.enterCity("London");
        checkOutPage.enterPostCode("TW3 4RK");
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.selectRegionOrStateFromDropDown("Bristol");
        checkOutPage.clickOnCheckBox();

//        2.21 Click on “Continue” Button
        checkOutPage.clickOnContinueButtonInBillingDetails();

//        2.22 Add Comments About your order into text area
        checkOutPage.enterCommentsAboutOrder("Please send via special delivery");

//        2.23 Check the Terms & Conditions check box
        checkOutPage.clickOnCheckBox();

//        2.24 Click on “Continue” button
        checkOutPage.clickOnContinueButtonInPaymentMethod();

//        2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkOutPage.getWarningMessageText(), "Warning: Payment method required!", "Incorrect warning message.");

    }

}
