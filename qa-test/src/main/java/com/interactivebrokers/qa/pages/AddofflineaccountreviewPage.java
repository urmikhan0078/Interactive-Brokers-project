package com.interactivebrokers.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.interactivebrokers.Testbase;

public class AddofflineaccountreviewPage extends Testbase{

	
	By continuebtn2 = By.xpath("//a[@role='button' and contains(@class, 'btn-primary') and contains(@class, 'white-space-normal')]");
	
	public AddofflineaccountreviewPage (WebDriver driver) {
	    this.driver = driver;
	
	
	}
	public void clickreviewcontinuebtn() {
		  driver.findElement(continuebtn2 ).click();
	}

}

