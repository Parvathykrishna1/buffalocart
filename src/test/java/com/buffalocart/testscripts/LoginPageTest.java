package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, description = "TC_001_Verification of login page title")
    public void verifyLoginPageTitle() {
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("LoginPage");
        String actualLoginPageTitle = login.getLoginPageTitle();
        String expectedLoginPageTitle = data.get(1).get(0);
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "ERROR:Invalid LoginPageTitle");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual login page title");

    }

    @Test(priority = 2, description = "TC_002_Verification of user login")
    public void verify_user_login_with_valid_user_credentials() {
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("LoginPage");
        String uname = data.get(1).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        String pswd = data.get(1).get(2);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualUserAccountName = home.getUserAccountName();
        String expectedUserAccountName = data.get(1).get(3);
        Assert.assertEquals(actualUserAccountName, expectedUserAccountName, "ERROR::Invalid Username");
        extentTest.get().log(Status.PASS, "user logged in successfully");
    }

    @Test(priority = 3, description = "TC_003_Verification of user login with invalid credentials")
    public void verify_user_login_with_invalid_user_credentials() {
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("LoginPage");
        String uname = data.get(2).get(1);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "Invalid user name entered successfully");
        String pswd = data.get(2).get(2);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Invalid password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualErrorMsg = login.getErrorMessage();
        String expectedErrorMsg = data.get(1).get(4);
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "ERROR::Invalid credential");
        extentTest.get().log(Status.PASS, "user not able logged in successfully");
    }

    @Test(priority = 4,description = "TC_004_Verify whether the user is able to click on 'Remember me' checkbox")
    public void verify_Whether_User_Able_To_Click_On_RememberMe_CheckBox() {
        login = new LoginPage(driver);
        login.clickOnRememberMeCheckBox();
        extentTest.get().log(Status.PASS, "clicked on CheckBox successfully");
        login.rememberMeCheckBoxIsSelected();
        extentTest.get().log(Status.PASS, "CheckBox  selected successfully");
        Assert.assertTrue(login.rememberMeCheckBoxIsSelected());
        extentTest.get().log(Status.PASS, "Assertion True for checkbox selected ");
    }

}
