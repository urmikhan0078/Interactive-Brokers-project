//Created by:Urmi Khan
//InteractiveBrokers Website

package com.interactivebrokers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.interactivebrokers.qa.testutil.TestUtil;


public class Testbase {
	public static WebDriver driver;
	public static Properties prop;

	public Testbase() {
		//initialize property file
		prop=new Properties();
		try {
			FileInputStream ip= new FileInputStream("C:\\Users\\moham\\eclipse-workspace\\qa-test\\src\\main\\java\\com\\interactivebrokers\\qa\\confiq\\confiq.properties");
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}


//Initialize browser
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"));
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\moham\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		driver= new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//page load and implicitlywait
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timrout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		
	}


	}




