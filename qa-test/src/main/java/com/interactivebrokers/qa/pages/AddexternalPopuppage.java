package com.interactivebrokers.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.interactivebrokers.Testbase;

public class AddexternalPopuppage extends Testbase  {
	
	By continuelink = By.xpath("//a[normalize-space(text())='Continue']");
  //  By addexternalacoounttex= By.xpath("//a[normalize-space(text())='Continue']");
    
    
    public AddexternalPopuppage(WebDriver driver) {
        this.driver = driver;
    }
    //ClickconfigutionLink function to click Configuration link
    public Addacountpage  continuelink() {
 		  driver.findElement( continuelink ).click();
		return new Addacountpage(driver);
    }
    
 //Click on External Account 
    public String validateaddexternalaccpageTitle() {
		return driver.getTitle();
		}
}
