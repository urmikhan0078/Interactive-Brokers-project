package com.interactivebrokers.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.interactivebrokers.Testbase;


public class PortfolioAnalystPage extends Testbase {
	
	
	By configutionLink = By.xpath("//a[@data-target='PaConfiguration']");
    By offlineaccount= By.xpath("//span[text()='Offline Account']");
   // WebElement searchBox = By.xpath("//input[@class='form-control form-search ng-pristine ng-untouched ng-valid ng-empty']");
    By bestMatchsection= By.xpath("//p[@text()='Best Match']");
    By othersection= By.xpath("//p[@class='text-gray' and text()='Other']");
    By closeButton = By.xpath("//i[@class='fas fa-xmark']");

   // Constructor
   public PortfolioAnalystPage(WebDriver driver) {
       this.driver = driver;
   }
   // ClickconfigutionLink function to click Configuration link
   public void ClickconfigutionLink() {
		  driver.findElement(configutionLink ).click();
  }
   
//Click on External Account 
//public void Clickexternalaccountplusbutton() {
		// driver.findElement(externalaccountplusbutton).click();
		
	//	}
//Search citibank on search box
   public void searchInstitution() {
	   WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Institutions']"));
	   searchBox.sendKeys("citibank");
	  // Actions actions = new Actions(driver);
	    
	    // Type the search query and press Enter using Actions class
	  //.sendKeys(searchBox,"citibank").sendKeys(Keys.ENTER).perform();
	 
	   
		try {
           Thread.sleep(5000); // Wait 5 seconds
       } catch (InterruptedException e) {
       	System.out.println("search cannot found");
           e.printStackTrace();
       }
	

		
	
   }
   //validate that ‘Costco Wholesale Credit Card’is shown under Other section

   public boolean validateCostcoInOtherSection() {
       List<WebElement> otherSectionResults = driver.findElements( othersection);
       for (WebElement result : otherSectionResults) {
           if (result.getText().contains("Costco Wholesale Credit Card")) {
               return true;
           }
       }
       return false;
   }
   // validate‘Costco Wholesale Credit Card’ not under Best Match.


   public boolean validateCostcoNotInBestMatch() {
       List<WebElement> bestMatchSectionResults = driver.findElements(bestMatchsection);
       for (WebElement result : bestMatchSectionResults) {
           if (result.getText().contains("Costco Wholesale Credit Card")) {
               return false;
           }
       }
       return true;
   }
   //Select offline account 
   public AddexternalPopuppage offlineaccount() {
	   driver.findElement(offlineaccount).click();
	return new AddexternalPopuppage(driver);
	   
   }
   
//Close search function
   public void closeSearch() {
      driver.findElement(closeButton).click();
	
   }


}
