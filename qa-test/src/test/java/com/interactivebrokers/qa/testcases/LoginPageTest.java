package com.interactivebrokers.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.interactivebrokers.Testbase;
import com.interactivebrokers.qa.pages.LoginPage;
import com.interactivebrokers.qa.pages.PortfolioAnalystPage;
import com.interactivebrokers.qa.testutil.TestUtil;



public class LoginPageTest extends Testbase {
	LoginPage  loginpage;
	TestUtil testutil;
	PortfolioAnalystPage portfolioAnalystpage;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		// Initialize page objects
        loginpage = new LoginPage(driver);
		testutil =new TestUtil();
		portfolioAnalystpage =new PortfolioAnalystPage(driver);
		
}
	//validate login test
	@Test(priority=1)
	public void loginTest()
	 {
	
		portfolioAnalystpage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	//verify IBKlogo
	
    @Test(priority=2)
    public void verifyIBKRlogo() {
	loginTest();
	boolean flag=loginpage.validateRBKRlogo();
	Assert.assertTrue(flag);
}
    @AfterMethod
    public void teardown() {
	driver.quit();
}

}
