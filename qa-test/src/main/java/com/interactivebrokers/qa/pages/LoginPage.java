package com.interactivebrokers.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.interactivebrokers.Testbase;


public class LoginPage extends Testbase {
	      WebDriver driver;
	     
	     //Element Locators
	     
	      By usernameField = By.xpath("//input[@type='text' or @name='username']");
	      By passwordField= By.xpath("//input[@type='test' or @name='password']");
	      By loginButton=By.xpath("//button[contains(@class, 'btn btn-lg btn-primary')]");
	      By IBKRPortfolioLogo=By.xpath("//a[@ng-switch-when='STANDALONE_PA' and contains(@class, 'navbar-brand')]");

	     // Constructor
	     public LoginPage(WebDriver driver) {
	         this.driver = driver;
	     }
	     //verify IBKR logo 
	     public boolean validateRBKRlogo() {
	 		return  driver.findElement(IBKRPortfolioLogo).isDisplayed();
	 		}

	     // Login Method
	     public PortfolioAnalystPage login(String username, String password) {
	         driver.findElement(usernameField).sendKeys(username);
	         driver.findElement(passwordField).sendKeys(password);
	         driver.findElement(loginButton).click();
			return new PortfolioAnalystPage(driver);
	         
	     }
	 }