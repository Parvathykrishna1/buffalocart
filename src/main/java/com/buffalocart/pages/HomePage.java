package com.buffalocart.pages;

import com.buffalocart.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestHelperUtility {
WebDriver driver;

 /**Page Constructor**/
 public HomePage(WebDriver driver){
     this.driver=driver;
     PageFactory.initElements(driver,this);
 }

 /**Page Elements**/

}
