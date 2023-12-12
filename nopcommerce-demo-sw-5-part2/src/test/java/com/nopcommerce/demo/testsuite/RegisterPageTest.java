package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();

    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

//    Click on Register Link
        homePage.clickOnRegisterLink();

//    Verify "Register" text
        Assert.assertEquals(registerPage.getRegisterTitleText(), "Register", "User navigated to incorrect page.");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
//        Click on Register Link
        homePage.clickOnRegisterLink();

//        Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

//        Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getFirstNameErrorText(), "First name is required.", "Error message for First Name is not displayed.");

//        Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getLastNameErrorText(), "Last name is required.", "Error message for Last Name is not displayed.");

//        Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getEmailErrorText(), "Email is required.", "Error message for Email is not displayed.");

//        Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordErrorText(), "Password is required.", "Error message for Password is not displayed.");

//        Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getConfirmPasswordErrorText(), "Password is required.", "Error message for Password is not displayed.");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
//        Click on Register Link
        homePage.clickOnRegisterLink();

//        Select gender "Female"
        registerPage.clickOnFemaleRadioButton();

//        Enter firstname
        registerPage.enterFirstName("Sally");

//        Enter lastname
        registerPage.enterLastName("Smith");

//        Select day
        registerPage.selectDateOfBirthDateFromDropDown("4");

//        Select month
        registerPage.selectDateOfBirthMonthFromDropDown("June");

//        Select year
        registerPage.selectDateOfBirthYearFromDropDown("2000");

        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String randomString = String.format("%03d", randomNumber);
        String randomEmail = randomString + "sallysmith@gmail.com";

//        Enter email
        registerPage.enterEmail(randomEmail);

//        Enter password
        registerPage.enterPassword("Password1");

//        Enter Confirm Password
        registerPage.enterConfirmPassword("Password1");

//        Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

//        Verify message "Your registration completed"
        Assert.assertEquals(registerPage.getRegistrationSuccessMessageText(), "Your registration completed", "Registration did not complete successfully.");

    }

}