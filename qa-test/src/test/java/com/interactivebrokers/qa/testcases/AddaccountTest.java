package com.interactivebrokers.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.interactivebrokers.Testbase;
import com.interactivebrokers.qa.pages.Addacountpage;
import com.interactivebrokers.qa.pages.AddexternalPopuppage;
import com.interactivebrokers.qa.pages.AddofflineaccountreviewPage;
import com.interactivebrokers.qa.pages.Addofflinetransactionpage;
import com.interactivebrokers.qa.pages.LoginPage;
import com.interactivebrokers.qa.pages.PortfolioAnalystPage;
import com.interactivebrokers.qa.testutil.TestUtil;

public class AddaccountTest extends Testbase{
	LoginPage  loginpage;
	TestUtil testutil;
	PortfolioAnalystPage portfolioAnalystpage;
	AddexternalPopuppage addexternalpopuppage;
	Addacountpage addacountpage;
	Addofflinetransactionpage addofflinetransactionpage;
	AddofflineaccountreviewPage addofflineaccountreviewpage;

	
	
	@BeforeMethod
	public void setup() {
		//initialize browser
		initialization();
		 loginpage = new LoginPage(driver);
	
		// Initialize page objects
		
        loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil =new TestUtil();
		portfolioAnalystpage =new PortfolioAnalystPage(driver);
		addexternalpopuppage=new AddexternalPopuppage(driver);
		addacountpage=new Addacountpage(driver);
		addofflinetransactionpage=new Addofflinetransactionpage(driver);
		addofflineaccountreviewpage = new AddofflineaccountreviewPage(driver);
		}
		@Test(priority=1) 
		
		public void createBrokerageaccountTest () {
			
			//click offline account button
			portfolioAnalystpage.offlineaccount();
			//String title=addexternalpopuppage.validateaddexternalaccpageTitle();
			//Assert.assertEquals(title,"Add External Account");
			//Click continue button
			 addacountpage.continuebtnLink();
			//String tittle=	addacountpage.validateHeaderTextonaccountpage();
			//Assert.assertEquals(tittle, "Add External Account");
			 //Create broker account
			addacountpage.createBrokerageaccount(); 
			//Click continue button and landed add offline account enter transaction 
			addacountpage.clickcontinuebtn();
			//click continue button and go to account review page
			addofflinetransactionpage.clickcontinuebtn();
			//addofflineaccountreviewpage.clickreviewcontinuebtn();
			
			
			
			
			}
		
		
		@Test(priority=2) 
	    
	    public void ValidateHeaderTextonaccountpageText() {
			portfolioAnalystpage.offlineaccount();
			addacountpage.continuebtnLink();
	         // Assuming you have an AccountPage class
	        String actualTitle = addacountpage.validateHeaderTextonaccountpage();
	        String expectedTitle ="PortfolioAnalyst";
	        
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
	    }
		
	//	@AfterMethod
	//		  public void teardown() {
		//	driver.quit();
		//	}
		}
			
		
			
			
			
		
		 
		
		
		
		
	


