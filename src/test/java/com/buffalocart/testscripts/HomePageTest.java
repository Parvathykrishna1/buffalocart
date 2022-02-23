package com.buffalocart.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel = new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1, description = "TC_006_Verification of home page title")
    public void Verification_of_home_page_title() {
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("HomePage");
        String uname = data.get(1).get(0);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String pswd = data.get(1).get(1);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String expectedHomePageTitle = data.get(1).get(2);
        String actualHomePageTitle = home.getHomePageTitle();
        extentTest.get().log(Status.PASS, "Login page title received");
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "ERROR:Invalid HomePageTitle");
        extentTest.get().log(Status.PASS, "Expected title is matched with actual home page title");
    }

    @Test(priority = 2, description = "TC_007_Verify date displayed in home page ")
    public void Verify_date_displayed_in_home_page(){
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("HomePage");
        String uname = data.get(1).get(0);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name entered successfully");
        String pswd = data.get(1).get(1);
        login.enterPassword(pswd);
        extentTest.get().log(Status.PASS, "Password entered successfully");
        home = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualDate=home.getDateDisplayedOnHomePage();
        String expectedDate= home.getSystemDate();
        extentTest.get().log(Status.PASS, "Home page date received");
        Assert.assertEquals(actualDate,expectedDate,"ERROR ::Date displayed is not matched with system Date ");
        extentTest.get().log(Status.PASS, "Expected date is matched with actual home page date");
    }

    @Test(priority = 3,description ="TC_008_Verify whether user is navigating to login page by clicking on Sign out button")
    public void  verify_Whether_User_Is_Navigating_To_Login_Page_By_Clicking_On_Sign_Out_Button(){
        login = new LoginPage(driver);
        List<List<String>> data = excel.excelDataReader("HomePage");
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
        String dropdown=data.get(0).get(3);
        login=home.selectFromDropDownForSignOut(dropdown);
        extentTest.get().log(Status.PASS, "clicked on User account name successfully");
        String option=data.get(1).get(0);
        login=home.selectFromDropDownForSignOut(option);
        extentTest.get().log(Status.PASS, "clicked on sign out button successfully");
    }
}

