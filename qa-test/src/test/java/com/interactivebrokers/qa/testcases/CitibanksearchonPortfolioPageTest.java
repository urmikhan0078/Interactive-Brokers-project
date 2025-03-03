package com.interactivebrokers.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.interactivebrokers.Testbase;

import com.interactivebrokers.qa.pages.LoginPage;
import com.interactivebrokers.qa.pages.PortfolioAnalystPage;
import com.interactivebrokers.qa.testutil.TestUtil;

public class CitibanksearchonPortfolioPageTest extends Testbase{
	
	//Initialize pages
	LoginPage  loginpage;
	TestUtil testutil;
	PortfolioAnalystPage portfolioAnalystpage;
	

	
	
	@BeforeMethod
	public void setup() {
		//initialize browser
		initialization();
		 loginpage = new LoginPage(driver);
	
		// Initialize page objects
		
       
		testutil =new TestUtil();
		portfolioAnalystpage =new PortfolioAnalystPage(driver);
		
	
		
		//**Test Look up ‘Citibank’ in the Search Institutions box and validate that ‘Costco Wholesale Credit Card’
		//is shown under Other section and not under Best Match.
		//	 Click on ‘X’.**//
}
	@Test(priority=1)
	public void citibankserchTest()
	
	 { 
		//login function
		portfolioAnalystpage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
		//type Citi Bank on search box
		portfolioAnalystpage.searchInstitution();
		  // Validate that ‘Costco Wholesale Credit Card’ is  under other
		
		portfolioAnalystpage.validateCostcoInOtherSection();
        

        // Validate that ‘Costco Wholesale Credit Card’ is NOT under Best Match
        portfolioAnalystpage.validateCostcoNotInBestMatch();
      
		//Click on ‘X’.**//
		portfolioAnalystpage.closeSearch();
		
	}
	@AfterMethod
	//close browser
	public void teardown() {
		driver.quit();
	}
	


	
		
	}

