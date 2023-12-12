package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
//        Click on Computer tab
        homePage.clickOnComputerLink();

//        Verify "Computer" text
        Assert.assertEquals(computerPage.getComputersPageTitleText(), "Computers", "User navigated to wrong page.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
//        Click on Computer tab
        homePage.clickOnComputerLink();

//        Click on Desktops link
        computerPage.clickOnDesktopsLink();

//        Verify "Desktops" text
        Assert.assertEquals(desktopsPage.getDesktopPageTitleText(), "Desktops", "The user navigated to wrong page.");

    }

    @Test(dataProvider = "productdetails", dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
//        Click on Computer tab
        homePage.clickOnComputerLink();

//        Click on Desktops link
        computerPage.clickOnDesktopsLink();

//        Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();

//        Select processor "processor"
        buildYourOwnComputerPage.selectProcessorDropDownByVisibleText(processor);

//        Select RAM "ram"
        buildYourOwnComputerPage.selectRamDropDownByVisibleText(ram);

//        Select HDD "hdd"
        buildYourOwnComputerPage.clickOnHddRadioButton(hdd);

//       Select OS "os"
        buildYourOwnComputerPage.clickOnOsRadioButton(os);

//        Select Software "software"
        buildYourOwnComputerPage.selectSoftwareCheckBox(software);

//        Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();

//        Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(buildYourOwnComputerPage.getProductAddedToCartMessage(),"The product has been added to your shopping cart", "Product not added successfully.");
    }


}
