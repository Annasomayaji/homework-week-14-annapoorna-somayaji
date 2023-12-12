package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.account.AccountPage;
import com.tutorialsninja.demo.pages.account.LogoutPage;
import com.tutorialsninja.demo.pages.account.ReturningCustomerPage;
import com.tutorialsninja.demo.pages.register_and_registersuccess.RegisterPage;
import com.tutorialsninja.demo.pages.account.LoginPage;
import com.tutorialsninja.demo.pages.register_and_registersuccess.RegisterSuccessPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    RegisterSuccessPage registerSuccessPage;
    LogoutPage logOutPage;
    ReturningCustomerPage returningCustomerPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        registerSuccessPage = new RegisterSuccessPage();
        logOutPage = new LogoutPage();
        returningCustomerPage = new ReturningCustomerPage();
        accountPage = new AccountPage();


    }
//        1.1 create method with name "selectMyAccountOptions" it has one parameter name
//        "option" of type string
//        1.2 This method should click on the options whatever name is passed as parameter.
//        (Hint: Handle List of Element and Select options)

    public void selectMyAccountOptions(String option) {
        List<WebElement> allMyAccountOptions = homePage.getMyAccountOptions();
        for (WebElement e : allMyAccountOptions) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
//        1.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//        1.3 Verify the text “Register Account”
        Assert.assertEquals(registerPage.getRegisterPageHeadingText(), "Register Account", "Navigated To Wrong page.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
//        2.1 Click on My Account Link
        homePage.clickOnMyAccountLink();

//        2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//        2.3 Verify the text “Returning Customer”
        Assert.assertEquals(loginPage.getReturningCustomerHeadingText(), "Returning Customer", "Navigated To Wrong page.");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() {
//        3.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//        3.3 Enter First Name
        registerPage.enterFirstName("Annu");

//        3.4 Enter Last Name
        registerPage.enterLastName("Som");

//        3.5 Enter Email
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomString = String.format("%03d", number);
        String randomEmail = randomString + "annu@gmail.com";
        registerPage.enterEmail(randomEmail);

//        3.6 Enter Telephone
        registerPage.enterPhone("07712342520");

//        3.7 Enter Password
        registerPage.enterPassword("Password1");

//        3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Password1");

//        3.9 Select Subscribe Yes radio button
        registerPage.clickOnNewsLetterRadioButton("Yes");

//        3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicyCheckBox();

//        3.11 Click on Continue button
        registerPage.clickOnContinueButton();

//        3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(registerSuccessPage.getRegisterSuccessMessageText(), "Your Account Has Been Created!", "Registraion successful message incorrect.");

//        3.13 Click on Continue button
        registerSuccessPage.clickOnContinueButton();

//        3.14 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//        3.16 Verify the text “Account Logout”
        Assert.assertEquals(logOutPage.getLogOutHeadingText(), "Account Logout", "LogOut page heading is incorrect.");

//        3.17 Click on Continue button
        logOutPage.clickOnContinueButton();


    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
//        4.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();

//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//        4.3 Enter Email address
        returningCustomerPage.enterEmail("annusom@gmail.com");

//        4.5 Enter Password
        returningCustomerPage.enterPassword("Password1");

//        4.6 Click on Login button
        returningCustomerPage.clickOnLoginButton();

//        4.7 Verify text “My Account”
        Assert.assertEquals(accountPage.getMyAccountHeadingText(), "My Account", "Did ot navigate to My Account page.");

//        4.8 Click on My Account Link.
        homePage.clickOnMyAccountLink();


//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

//        4.10 Verify the text “Account Logout”
        logOutPage.getLogOutHeadingText();

//        4.11 Click on Continue button
        logOutPage.clickOnContinueButton();
    }

}
