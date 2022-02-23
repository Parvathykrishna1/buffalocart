package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends TestHelperUtility {
    WebDriver driver;

    /**
     * Page Constructor
     **/
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Page elements
     **/
    private final String _emailAddress = "email";
    @FindBy(id = _emailAddress)
    private WebElement emailAddress;

    private final String _sendPasswordResetLinkButton = "//div[@class='col-md-6 col-md-offset-4']/button[@type='submit']";
    @FindBy(xpath = _sendPasswordResetLinkButton)
    private WebElement sendPasswordResetLinkButton;

    private final String _errorMsg = "//span[@class='help-block']/strong";
    @FindBy(xpath = _errorMsg)
    private WebElement errorMsg;

    /**
     * User action methods
     **/
    public void enterEmailAddress(String email) {
        page.enterText(emailAddress, email);
    }

    public void clickOnSendPasswordResetLinkButton() {
        page.clickOnElement(sendPasswordResetLinkButton);
    }

    public String getErrorMsgDisplayed() {
        return page.getElementText(errorMsg);
    }

}

