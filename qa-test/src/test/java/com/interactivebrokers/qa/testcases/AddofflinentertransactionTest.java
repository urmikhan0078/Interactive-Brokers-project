package com.interactivebrokers.qa.testcases;

import org.testng.Assert;
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

public class AddofflinentertransactionTest extends Testbase{
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
				 	//addofflinetransactionpage.clickcontinuebtn();
				 
				
		}
	@Test(priority=1) 
	
	public void verifyaddedamount () {
		boolean flag=addofflinetransactionpage.verifyamountisdisplayed();
		Assert.assertTrue(flag);
}}
