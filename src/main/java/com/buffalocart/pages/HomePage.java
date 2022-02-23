package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestHelperUtility {
    WebDriver driver;

    /**
     * Page Constructor
     **/
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Page Elements
     **/
    private final String _userName = "//a[@class='dropdown-toggle']//span";
    @FindBy(xpath = _userName)
    private WebElement userName;

    private final String _dateDisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']/strong";
    @FindBy(xpath = _dateDisplayed) private WebElement dateDisplayed;

    /**
     * User action methods
     **/
    public String getUserAccountName() {
        String uname = page.getElementText(userName);
        return uname;
    }

    public String getHomePageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public String getDateDisplayedOnHomePage(){
        return page.getElementText(dateDisplayed);
    }
    public String getSystemDate(){
        return date.getDateOfSystem();
    }
}
