package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest extends Base {
    LoginPage login;
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
}
