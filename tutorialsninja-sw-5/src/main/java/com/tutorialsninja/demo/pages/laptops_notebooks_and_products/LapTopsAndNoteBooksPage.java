package com.tutorialsninja.demo.pages.laptops_notebooks_and_products;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LapTopsAndNoteBooksPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement lapTopsAndNoteBooksPageTitle;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropDown;
    @CacheLookup
    @FindAll({@FindBy(xpath = "//p[@class='price']")})
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;


    //Methods
    public String getLapTopsAndNoteBooksTitleText() {
        return getTextFromElement(lapTopsAndNoteBooksPageTitle);
    }

    public void selectFromSortByFilter(String text) {
        selectByVisibleTextFromDropDown(sortByDropDown, text);
    }

    public List<WebElement> getFilteredProductList() {
        try {
            waitUntilVisibilityOfElementLocated(productsList, 20);
            return productsList;
        } catch (Exception e) {
            driver.getCurrentUrl();
            return productsList;
        }

    }

    public void clickOnMacBook() {
        clickOnElement(macBook);
    }

}
