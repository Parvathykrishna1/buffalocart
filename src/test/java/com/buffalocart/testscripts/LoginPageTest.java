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
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<String> data = excel.readDataFromExcel("LoginPage");
        String expectedLoginPageTitle = data.get(1);
        String actualLoginPageTitle = login.getLoginPageTitle();
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "ERROR:Invalid LoginPageTitle");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual login page title");

    }

    @Test(priority = 1, description = "TC_002_Verification of user login")
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
}
