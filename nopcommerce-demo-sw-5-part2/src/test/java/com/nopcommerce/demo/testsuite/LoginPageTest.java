package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    /**
     * This method performs repetitive 4 steps in one method call
     */
    public void loginToAccount(String email, String password) {
        homePage.clickOnLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    // @Test(groups = "smoke")
    @Test(groups = {"smoke", "sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
//        Click on login link
        homePage.clickOnLoginLink();

//        verify that "Welcome, Please Sign In!" message display
        Assert.assertEquals(loginPage.getWelcomeMessageText(), "Welcome, Please Sign In!", "User navigated to incorrect page.");
        System.out.println("test login");
        System.out.println(System.getProperty("user.dir"));  //checking the path , debug purpose
        System.out.println(System.getProperty("C:\\Users\\annus\\IdeaProjects\\nopcommerce-demo-sw-5-part2\\test-output\\extent.html"));//checking the path, debug purpose
    }


    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {

        loginToAccount("john.smith@gmail.com", "Password1");

//        Click on login link
        //    homePage.clickOnLoginLink();

//        Enter EmailId
        //   loginPage.enterEmail("john.smith@gmail.com");

//        Enter Password
        //   loginPage.enterPassword("Password1");

//        Click on Login Button
        //   loginPage.clickOnLoginButton();

//        Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.";

        Assert.assertTrue(loginPage.getErrorMessageText().contains(expectedErrorMessage), "The error message is not displayed.");

    }


    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {

        loginToAccount("sallysmith@gmail.com", "Password1");
//        Click on login link
        //homePage.clickOnLoginLink();
//        Enter EmailId
        //loginPage.enterEmail("annusom@gmail.com");

//        Enter Password
        // loginPage.enterPassword("Password1");

//        Click on Login Button
        // loginPage.clickOnLoginButton();

//        Verify that LogOut link is display
        Assert.assertEquals(homePage.getLogOutLinkText(), "Log out", "Log out text not displayed.");

    }


    @Test(groups = {"regression"})

    public void verifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
//        Click on login link
//        Enter EmailId
//        Enter Password
//        Click on Login Button
        loginToAccount("sallysmith@gmail.com", "Password1");

//        Click on LogOut Link
        homePage.clickOnLogoutLink();
        driver.navigate().refresh();

        //Verify that LogIn Link Display after providing explicit wait
        Assert.assertEquals(homePage.getTextFromLoginLink(), "Log in", "Log in link is not displayed on logout.");

    }


}
