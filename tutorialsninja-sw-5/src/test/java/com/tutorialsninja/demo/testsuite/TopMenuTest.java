package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.desktops_and_products.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.laptops_notebooks_and_products.LapTopsAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    LapTopsAndNoteBooksPage lapTopsAndNoteBooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        lapTopsAndNoteBooksPage = new LapTopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }

    //    1.1 create method with name "selectMenu" it has one parameter name "menu" of type
//    string
//    1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        List<WebElement> showAll = homePage.showAllOptionsFromTopNav();
        try {
            for (WebElement e : showAll) {
                if (e.getText().equals(menu)) {
                    e.click();
                }
            }
        } catch (StaleElementReferenceException e) {

        }
    }


    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

//        1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktops();

//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

//        1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopsPage.getDeskTopTitleText(), "Desktops", "User navigated to wrong page.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
//        2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLapTopsAndNoteBooks();

//        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

//        2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(lapTopsAndNoteBooksPage.getLapTopsAndNoteBooksTitleText(), "Laptops & Notebooks", "User navigated to wrong page");

    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.moveMouseAndClickOnComponents();

//        3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

//        3.3 Verify the text ‘Components’
        Assert.assertEquals(componentsPage.getComponentsTitleText(), "Components", "User navigated to wrong page.");
    }
}
