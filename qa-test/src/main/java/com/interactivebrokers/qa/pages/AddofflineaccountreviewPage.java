package com.interactivebrokers.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.interactivebrokers.Testbase;

public class AddofflineaccountreviewPage extends Testbase{

	
	By continuebtn2 = By.xpath("//a[contains(@class, 'btn') and contains(@class, 'btn-primary')]");
	
	public AddofflineaccountreviewPage (WebDriver driver) {
	    this.driver = driver;
	
	
	}
	public void clickreviewcontinuebtn() {
		  driver.findElement(continuebtn2 ).click();
	}

}

