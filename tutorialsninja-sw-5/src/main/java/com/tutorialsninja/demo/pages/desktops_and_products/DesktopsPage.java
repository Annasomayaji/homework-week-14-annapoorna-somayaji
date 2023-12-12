package com.tutorialsninja.demo.pages.desktops_and_products;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement desktopPageTitle;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']")})
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropDown;
    @CacheLookup
    @FindBy(xpath = "//a[text()='HP LP3065']")
    WebElement hP_LP3065;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']/h4")})
    List<WebElement> allDesktopProducts;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//span[text()='Add to Cart']")})
    List<WebElement> addProductToCart;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='image']")})
    List<WebElement> productImages;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']")})
    List<WebElement> productDescription;


    //Methods
    public String getDeskTopTitleText() {
        return getTextFromElement(desktopPageTitle);
    }

    public void selectSortByName(String text) {
        selectByVisibleTextFromDropDown(sortByDropDown, text);
    }

    public List<WebElement> getFilteredProductList() {

        waitUntilVisibilityOfElementLocated(productsList, 10); //Using overloaded method that takes a list of elements and waits for them to be displayed.
        return productsList;
    }

    public List<WebElement> getAllProducts() {
        return allDesktopProducts;
    }

    public void selectProduct(String name) {
        for (WebElement element : productDescription) {
            if (element.getText().contains(name)) {
                element.click();
                break;
            }
        }
    }

    public void selectAProductInDesktop(String pdt) {
        for (WebElement product : allDesktopProducts) {
            System.out.println("Product name: " + product.getText());//debug purpose
            if (product.getText().equals(pdt)) {
                System.out.println("The matching product: " + product.getText());//debug purpose
                // clickOnProductImage(product.getText());
                clickOnElement(product);
                break;
                // product.click();

            }

        }
    }

    public void clickOnProductImage(String text) {
        for (WebElement productDescription : productsList) {
            if (productDescription.getText().contains(text)) {
                productDescription.click();

            }
        }
    }

    public void clickOnHP_LP3065() {
        clickOnElement(hP_LP3065);
    }

}
