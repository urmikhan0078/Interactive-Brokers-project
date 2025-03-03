package com.interactivebrokers.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.interactivebrokers.Testbase;

public class Addofflinetransactionpage extends Testbase {
	
	By amount = By.xpath("//input[@name='balance_0']");
	By continuebtn2 = By.xpath("//a[contains(text(), 'Continue')]");



public Addofflinetransactionpage(WebDriver driver) {
    this.driver = driver;
}

public boolean verifyamountisdisplayed() {
	return  driver.findElement(amount).isDisplayed();
	
}
// Click Continue Button
public AddofflineaccountreviewPage clickcontinuebtn() {
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='javascript:void(0)']" )));
	//if (element.isEnabled()) {
	 //   element.click();
	//}
	WebElement iframeElement = driver.findElement(By.xpath("//*[@id='PING_IFRAME_FORM_DETECTION']"));
    driver.switchTo().frame(iframeElement);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'panel-btn-right')]")));
	element.click();
	//WebElement button = driver.findElement(By.xpath("//a[@role='button' and contains(@class, 'btn-primary') and contains(@ng-click, 'onClick()')]"));

    // Use JavaScriptExecutor to click the button
	//WebElement element = driver.findElement(By.xpath("//a[@role='button' and contains(@class, 'btn-primary') and contains(@ng-click, 'onClick()')]"));
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//wait.until(ExpectedConditions.stalenessOf(element));
	//element = driver.findElement(By.xpath("//a[@role='button' and contains(@class, 'btn-primary') and contains(@ng-click, 'onClick()')]"));
	//element.click();;
	//int attempts = 0;
	//while (attempts < 3) {
	//    try {
	 //       WebElement element = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
	  //      element.click();
	    //    break;
	   // } catch (StaleElementReferenceException e) {
	        //attempts++;
	  //  }
	
	return new AddofflineaccountreviewPage(driver);

}}