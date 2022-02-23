package com.buffalocart.pages;

import com.aventstack.extentreports.ExtentTest;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignOutPage extends TestHelperUtility {
    WebDriver driver;

    /**Page Constructors**/

    public SignOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
