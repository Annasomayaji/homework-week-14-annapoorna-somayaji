package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processor;
    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hddRadioButton;

    //    @CacheLookup
//    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[1]//input[@type='radio']")})
//    List<WebElement> hddRadioButtons;
//
    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[1]/li")})
    List<WebElement> hddRadioButtonsList;

    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[2]/li")})
    List<WebElement> oSRadioButtonsList;

    @CacheLookup
    @FindBy(xpath = "((//ul[@class='option-list'])[1]/li/input[@type='radio'])[1]")
    WebElement radioButton1;

    @CacheLookup
    @FindBy(xpath = "((//ul[@class='option-list'])[1]/li/input[@type='radio'])[2]")
    WebElement radioButton2;

    @CacheLookup
    @FindBy(xpath = "((//ul[@class='option-list'])[2]/li/input[@type='radio'])[1]")
    WebElement osRadioButton1;
    @CacheLookup
    @FindBy(xpath = "((//ul[@class='option-list'])[2]/li/input[@type='radio'])[2]")
    WebElement osRadioButton2;


    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement osRadioButton;

    //Multiple elements lookup using @FindAll
    @CacheLookup
    @FindAll({@FindBy(xpath = "(//ul[@class='option-list'])[3]/li")})
    List<WebElement> softwareCheckBoxOptions;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productIsAddedMessage;

    //Methods
    public void selectProcessorDropDownByVisibleText(String str) {
        selectByVisibleTextFromDropDown(processor, str);
    }

    public void selectRamDropDownByVisibleText(String str) {
        selectByVisibleTextFromDropDown(ram, str);
    }

    public void clickOnHddRadioButton(String hdd) {
        System.out.println(hddRadioButtonsList);
        int count = 1;
        for (WebElement option : hddRadioButtonsList) {

            System.out.println("radio button: " + option.getText());//for debug purpose
            if (option.getText().equals(hdd)) {
                if (count == 1) {
                    radioButton1.click();
                    // option.click();
                    break;
                } else
                    radioButton2.click();
            }
            count++;
        }
    }

    public void clickOnOsRadioButton(String os) {
        int count = 1;
        for (WebElement option : oSRadioButtonsList) {
            System.out.println("radio button: " + option.getText());//for debug purpose
            if (option.getText().equals(os)) {
                if (count == 1) {
                    osRadioButton1.click();
                    // option.click();
                    break;
                } else
                    osRadioButton2.click();
            }
            count++;
        }
    }

    public void selectSoftwareCheckBox(String software) {
        for (WebElement option : softwareCheckBoxOptions) {
            if (option.getText().equals(software)) {
                option.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getProductAddedToCartMessage() {
        return getTextFromElement(productIsAddedMessage);
    }

}
