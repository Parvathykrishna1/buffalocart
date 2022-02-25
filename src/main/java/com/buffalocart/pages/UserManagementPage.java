package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserManagementPage extends TestHelperUtility {
    private final String _userManagementAllTabs="//ul[@class='treeview-menu menu-open']//span";
    private final String _userManagementTab="//li[starts-with(@class,'treeview')]//a[@href='#']//span[@class='title']";

    /**Page Elements**/
    WebDriver driver;
    @FindBy(xpath = _userManagementAllTabs) private List<WebElement> userManagementAllTabs;
    @FindBy(xpath = _userManagementTab) private WebElement userManagementTab;

    /**page constructor**/
    public UserManagementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**User action methods**/

    public void clickOnUserManagementTab() {
        page.clickOnElement(userManagementTab);
    }
    public List<String> getAllUserSubManagementTab() {
        wait.waitForElementToBeVisible(driver, _userManagementAllTabs, WaitUtility.LocatorType.Xpath);
        List<String> subTabValues = new ArrayList<>();
        for (int i = 0; i < userManagementAllTabs.size(); i++) {
            subTabValues.add(userManagementAllTabs.get(i).getText());
        }
        return subTabValues;


    }
}
