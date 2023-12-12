package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Random;

public class UsersTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        //        Login to Application
        loginPage.loginToApplication("Admin", "admin123");

//        click On "Admin" Tab
        homePage.clickOnAdminTab();

//        Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUserHeadingText(), "System Users", "The user navigated to incorrect page");

//        click On "Add" button
        viewSystemUsersPage.clickOnAddUserButton();

//        Verify "Add User" Text
        Assert.assertEquals(addUserPage.getAddUserHeadingText(), "Add User", "The page heading is incorrect.");

//        Select User Role "Admin"
        addUserPage.clickUserRoleDropDown();
        addUserPage.selectUserRoleFromDropDown("Admin");

//        enter Employee Name "Ananya Dash"
        addUserPage.clickOnEmployeeNameTextBox();
        addUserPage.enterHintText("Peter");
        addUserPage.clickOnAutoCompleter();

//        enter Username
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String randomString = String.format("%03d", randomNumber);
        String name = randomString + "abc.xyz";
        addUserPage.enterUserName(name);

//        Select status "Disabled"
        addUserPage.clickOnStatusDropDown();
        addUserPage.selectStatusFromDropDown("Disabled");

//        enter password
        addUserPage.enterPassword("Password1");

//        enter Confirm Password
        addUserPage.enterConfirmPassword("Password1");

//        click On "Save" Button
        addUserPage.clickOnSaveButton();

//        verify message "Successfully Saved"
        Assert.assertEquals(addUserPage.getSuccessToasterMessageText(), "Successfully Saved", "Not saved successfully.");

    }


    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
//        Login to Application
        loginPage.loginToApplication("Admin", "admin123");

//        click On "Admin" Tab
        homePage.clickOnAdminTab();

//        Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUserHeadingText(), "System Users", "The user navigated to incorrect page");

        //Search user

        viewSystemUsersPage.searchUser("Annu.Som", "Admin", "Disabled");


//        Verify the User should be in Result list
        Assert.assertTrue(viewSystemUsersPage.getRecordFoundLabelText().contains("Record Found"), "The search results are not displayed.");

    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
//        Login to Application
        loginPage.loginToApplication("Admin", "admin123");

//        click On "Admin" Tab
        homePage.clickOnAdminTab();

//        Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUserHeadingText(), "System Users", "The user navigated to incorrect page");

        //Search user

        viewSystemUsersPage.searchUser("Annu.Som", "Admin", "Disabled");

        //        Verify the User should be in Result list.

        Assert.assertTrue(viewSystemUsersPage.getRecordFoundLabelText().contains("Record Found"), "The search results are not displayed.");
//        Click on Check box
        viewSystemUsersPage.clickOnUserNameCheckBox();

//        Click on Delete Button
        viewSystemUsersPage.clickOnDeleteIcon();


//        Popup will display
//        Click on Ok Button on Popup
        viewSystemUsersPage.clickOnConfirmDeleteButton();

//        verify message "Successfully Deleted"
        Assert.assertEquals(addUserPage.getSuccessToasterMessageText(), "Successfully Deleted", "Not deleted successfully.");

    }

    @Test(dataProvider = "systemuser", dataProviderClass = TestData.class,groups = "regression")
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userrole, String employeename, String status) {
//        Login to Application
        loginPage.loginToApplication("Admin","admin123");

//        click On "Admin" Tab
        homePage.clickOnAdminTab();

//        Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUserHeadingText(), "System Users", "The user navigated to incorrect page");

//        Enter Username <username>
//        Select User Role <userRole>
//         Enter EmployeeName <employeeName>
//        Select Status <status>
//         Click on "Search" Button
        viewSystemUsersPage.searchUser(username, userrole,employeename,status);
//        verify message "(1) Record Found"
Assert.assertEquals(viewSystemUsersPage.getRecordFoundLabelText().contains("Records Found"), "Invalid message");

//        Verify username <username>
        Assert.assertEquals(viewSystemUsersPage.getUserNameInRecordText(),"Admin", "Record not found");

//                Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();

    }


}
