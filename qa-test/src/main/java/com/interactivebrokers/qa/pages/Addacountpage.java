package com.interactivebrokers.qa.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.interactivebrokers.Testbase;

public class Addacountpage extends Testbase {
	
	
	By accountheaderText = By.xpath("//div[contains(@class, 'col-8') and contains(@class, 'col-sm-10')]/h3");
	By accountype = By.xpath("//select[contains(@class, 'form-control')]");
	By accounnum = By.xpath("//input[@name='acctNumber']");
	
	By accountitle = By.xpath("//input[@name='acctTitle']");
	By accoundate = By.xpath("//input[@name='date' and contains(@class, 'form-control')]");
	By currency = By.xpath("/html/body/div/am-page/div/div[2]/div/component-include/div/am-dynamic-sequence/div/component-include/div/section/div/div/div/div/am-form-select[2]/div/div/div[2]/am-select/select");
	By continuebtn = By.xpath("//*[@id=\"amPageContent\"]/div[2]/div/component-include/div/am-dynamic-sequence/section/div/div/div[2]/div/p/am-button/a");
	By amount = By.xpath("//input[@name='balance_0']");
	By successfulmessage = By.xpath("//h1[text()='Your account has been added!']");
	By configutionLink = By.xpath("//a[@data-target='PaConfiguration']");
	By cashbalnce=By.xpath("//input[@name='balance_0' and @ng-model='amInputModel']");
	By manuallybtn=By.xpath("//a[contains(@class, 'btn') and @role='radio' and @ng-click=\"$ctrl.setModel(false)\"]");
	By continuebtn2 = By.xpath("//a[contains(text(), 'Continue')]");
	By continuebtn1=By.xpath("/html/body/div/am-page/div/div[2]/div/component-include/div/am-dynamic-sequence/section/div/div/div[2]/div/p/am-button");
	public Addacountpage(WebDriver driver) {
        this.driver = driver;
    }
	public String validateHeaderTextonaccountpage() {
		WebElement header = driver.findElement(accountheaderText);

	    // Get and return the text
	    return header.getText();
	}

		
	
	
	public boolean verifysuccessfulmessage() {
		return  driver.findElement(successfulmessage).isDisplayed();}
	//ClickconfigutionLink function to click Configuration link
	  public void continuebtnLink() {
	
		// Store the main window handle
           String mainWindow = driver.getWindowHandle();

           // Wait for the popup window to open
           try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

           // Get all window handles
           Set<String> windowHandles = driver.getWindowHandles();
           for (String handle : windowHandles) {
               if (!handle.equals(mainWindow)) {
                   driver.switchTo().window(handle);
                   break;
               }
           }

           // Click the "Continue" button
           WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"amModalFooter\"]/button-list/div/div[2]/div/p/am-button"));
           continueButton.click();

           // Optionally, switch back to the main window
           driver.switchTo().window(mainWindow);

	            

       
	   } 
	   public void ClickconfigutionLink() {
			  driver.findElement(configutionLink ).click();
	   }
	
	
  public void createBrokerageaccount(){
// Select Account Type
    Select accountTypeDropdown = new Select(driver.findElement(accountype)); 
    accountTypeDropdown.selectByVisibleText("Brokerage");


// Enter Account Number
   driver.findElement(accounnum).sendKeys("1234"); 

// Enter Account Title
   driver.findElement(accountitle).sendKeys("Testaccount");
// Enter Date
   driver.findElement(accoundate ).click();
   WebElement dateToSelect = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[4]/td[4]"));
   dateToSelect.click();
   driver.findElement(currency).click(); 
   Select basecurrencyDropdown = new Select(driver.findElement(currency));
   basecurrencyDropdown.selectByVisibleText("USD");

// Select Currency

   driver.findElement(amount).sendKeys("100");
   driver.findElement(manuallybtn).click(); 
  }
// Click Continue Button
  public Addofflinetransactionpage clickcontinuebtn() {
	  driver.findElement(continuebtn).click();
	return new Addofflinetransactionpage (driver);
	  
  }
 // driver.findElement(continuebtn).click(); 
 //driver.findElement(continuebtn).click(); 
 // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'panel-btn-right')]//a[contains(@class, 'btn-primary') and contains(text(), 'Continue')]")));
 // element.click();
 //WebElement continueButton = driver.findElement(By.xpath("//div[contains(@class, 'panel-btn-right')]//a[contains(@class, 'btn-primary') and contains(text(), 'Continue')]"));

 // Use JavaScript Executor to click the element
 //JavascriptExecutor js = (JavascriptExecutor) driver;
 //js.executeScript("arguments[0].click();", continueButton);
  
//  driver.findElement( continuebtn2).click(); 




}


