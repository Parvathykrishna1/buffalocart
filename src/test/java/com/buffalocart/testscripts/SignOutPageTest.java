package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SignOutPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SignOutPageTest extends Base {
    HomePage home;
    LoginPage login;
    SignOutPage signOut;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button")
    public void verify_Whether_User_Is_Navigating_To_Login_Page_By_Clicking_On_Sign_Out_Button() {
        extentTest.get().assignCategory("Smoke");
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("User Management Page");
        String uname = data.get(1).get(0);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String pswd = data.get(1).get(1);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        home.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "clicked on End Tour button successfully");
        String dropdown = data.get(0).get(3);
        login = home.clickOnUserAccountName(dropdown);
        extentTest.get().log(Status.PASS, "clicked on User account name successfully");
        String option = data.get(1).get(3);
        login = home.selectFromDropDownForSignOut(option);
        extentTest.get().log(Status.PASS, "clicked on sign out button successfully");
    }
}


