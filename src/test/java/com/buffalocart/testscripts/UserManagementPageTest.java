package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UserManagementPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UserManagementPageTest extends Base {
    HomePage home;
    LoginPage login;
    UserManagementPage userManagement;
    // UsersPage users;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, description = "TC_009_Verify the User management sub tabs")
    public void verify_the_User_management_sub_tabs() {
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("UserManagementPage");
        String uname = data.get(1).get(0);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String pswd = data.get(1).get(1);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        home.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "End tour clicked successfully");
        userManagement = new UserManagementPage(driver);
        userManagement.clickOnUserManagementTab();
        extentTest.get().log(Status.PASS, "Clicked on user management Tab successfully");
        List<String> expectedSubTabs = new ArrayList<>();
        expectedSubTabs.add(data.get(2).get(2));
        expectedSubTabs.add(data.get(3).get(2));
        expectedSubTabs.add(data.get(4).get(2));
        List<String> actualSubTabs = userManagement.getAllUserSubManagementTab();
        Assert.assertEquals(actualSubTabs, expectedSubTabs, "Error ::SubTabs not match");
        extentTest.get().log(Status.PASS, "Actual and Expected userManagement subTabs matched");
    }

}

