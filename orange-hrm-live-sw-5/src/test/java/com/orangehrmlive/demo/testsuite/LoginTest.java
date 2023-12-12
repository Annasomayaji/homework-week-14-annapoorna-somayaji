package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {

//        Enter username
//        Enter password
//        Click on Login Button
        loginPage.loginToApplication("Admin", "admin123");

//        Verify "DashBoard" Message
        String actualDashBoardTitle = homePage.getDashboardTitleText();
        Assert.assertEquals(actualDashBoardTitle, "Dashboard", "User navigated ti incorrect page.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {

//        Login To The application
        loginPage.loginToApplication("Admin", "admin123");

//        Verify Logo is Displayed
        Assert.assertTrue(loginPage.getLogoElement().isDisplayed(), "Logo is not displayed.");

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {

//        Login To The application
        loginPage.loginToApplication("Admin", "admin123");

//        Click on User Profile logo
        homePage.clickOnUserProfileLogo();

//        Mouse hover on "Logout" and click
        homePage.clickOnDropDownOptions("Logout");

//        Verify the text "Login Panel" is displayed
        Assert.assertEquals(loginPage.getLoginPanelHeadingText(), "Login", "User navigated to wrong page.");

    }

    @Test(dataProvider = "invalidlogindetails", dataProviderClass = TestData.class, groups = "regression")
    public void verifyErrorMessageWithInvalidCredentials(String userName, String password, String errorMsg) {

//        Enter username <username>
//        Enter password <password>
//        Click on Login Button
        loginPage.loginToApplication(userName, password);

        if (userName.isEmpty() && password.isEmpty()) {
            Assert.assertEquals(loginPage.getErrorMessageForUserNameRequiredField(), errorMsg, "No error message or error message as not expected.");
            Assert.assertEquals(loginPage.getErrorMessageForPasswordRequiredField(), errorMsg, "No error message or error message as not expected.");

        } else if (userName.isEmpty()) {
            Assert.assertEquals(loginPage.getErrorMessageForUserNameRequiredField(), errorMsg, "No error message or error message as not expected.");

        } else if (password.isEmpty()) {
            Assert.assertEquals(loginPage.getErrorMessageForPasswordRequiredField(), errorMsg, "No error message or error message as not expected.");

        } else
            Assert.assertEquals(loginPage.getErrorMessageForInvalidCredentials(), errorMsg, "No error message or error message as not expected.");


    }


}
