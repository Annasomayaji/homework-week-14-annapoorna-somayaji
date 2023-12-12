package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.pages.desktops_and_products.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.desktops_and_products.DesktopsProductsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DesktopsPage desktopsPage;
    DesktopsProductsPage desktopsProductsPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        desktopsProductsPage = new DesktopsProductsPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
//        1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverAndClickOnDesktops();

//        1.2 Click on “Show All Desktops”
        homePage.mouseHoverAndClickOnShowAllDesktops();

        //Create an array and store all products before sorting and sort them using Collections sort method
        List<WebElement> productsBeforeFilterList = desktopsPage.getFilteredProductList();
        ArrayList<String> productsBeforeFilter = new ArrayList<>();
        for (WebElement product : productsBeforeFilterList) {
            productsBeforeFilter.add(product.getText());
        }
        Collections.sort(productsBeforeFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(productsBeforeFilter);

//        1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectSortByName("Name (Z - A)");

//Provide explicit wait for all the product to be available on page after sorting

//        driver.navigate().refresh();
//        driver.navigate().to(driver.getCurrentUrl());

        List<WebElement> productsAfterFilterList = desktopsPage.getFilteredProductList();

        ArrayList<String> productsAfterFilter = new ArrayList<>();
        for (WebElement product : productsAfterFilterList) {
            productsAfterFilter.add(product.getText());
        }

        //        1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(productsAfterFilter, productsBeforeFilter, "Products are not arranged in descending order");

    }


    //In the below test all the test steps run successfully when item is chosen manually. It fails, when List of elements is iterated and clicked on. click does not work

    @Test(dataProvider = "productdetails", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) throws InterruptedException {
//        2.1 Mouse hover on Currency Dropdown and click
        homePage.moveMouseAndClickOnCurrencyDropDown();

//        2.2 Mouse hover on £Pound Sterling and click
        List<WebElement> allCurrencies = homePage.getCurrencyListFromDropDown();
        for (WebElement element : allCurrencies) {
            if (element.getText().equalsIgnoreCase("£Pound Sterling")) {
                element.click();
                break;
            }
        }

        System.out.println("Product from TestData: " + product);
//        2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktops();

//        2.4 Click on “Show All Desktops”
        homePage.mouseHoverAndClickOnShowAllDesktops();

//        2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectSortByName("Name (A - Z)");

        //desktopsPage.clickOnHP_LP3065();

        // 2.6 Select product <product>

        //STOPS WORKING HERE
        List<WebElement> allProducts = desktopsPage.getAllProducts();
        for (WebElement element : allProducts) {
            if (element.getText().equalsIgnoreCase(product)) {
                System.out.println("Matching product: " + element.getText());//debug purpose
                element.click();
                break;
            }
        }

        //desktopsPage.selectProduct(product);
        //  desktopsPage.selectAProductInDesktop(product);

//        2.7 Enter Qty <qty> using Select class.
        desktopsProductsPage.enterQuantity(qty);

//        2.8 Click on “Add to Cart” button
        desktopsProductsPage.clickOnAddToCartButton();

//        2.9 Verify the Message <successMessage>
        Assert.assertTrue(desktopsProductsPage.getProductAddedSuccessMessageText().contains(successMessage), "success message is not displayed correctly. ");
        //Assert.assertEquals(desktopsProductsPage.getProductAddedSuccessMessageText(), successMessage, "success message is not displayed correctly. ");

//        2.10 Click on link “shopping cart” display into success message
        desktopsProductsPage.clickOnShoppingCartLinkInSuccessMessage();

//        2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.getShoppingCartHeadingText().contains("Shopping Cart"));

//        2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.getProductNameText(), productName, "Product name does not match.");

//        2.13 Verify the Model <model>
        Assert.assertEquals(shoppingCartPage.getModelNameText(), model, "Incorrect model name in shopping cart.");

//        2.14 Verify the Total <total>
        Assert.assertEquals(shoppingCartPage.getTotalText(), total, "Total is incorrect.");

    }


}
