package com.TestClasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseAnnotation.Base;
import com.Pages.WIKIPage;

public class WIKITest extends Base{
	
	WIKIPage WIKIPage;
	
	public WIKITest(){
		super();// Calling the super class constructor
	}
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional String browser){
		initialization(browser);// Initiating the browser session
		WIKIPage = new WIKIPage(driver);	
		
	}
	
	@Test
	public void Test01_loginPageTitleTest(){
		String title = WIKIPage.validateLoginPageTitle("WIKI");
		Assert.assertEquals(title, "Wikipedia, the free encyclopedia");
	}
	
	@Test
	public void Test02_verifyTheCountryName(){
		String countryName = WIKIPage.verifyTheCountyName("Pushpa: The Rise");
		Assert.assertEquals(countryName, "India");
		Reporter.log("[ASSERT PASSED]: Country Name is "+countryName);
	}
	
	@Test
	public void Test03_verifyTheReleaseDate(){
		String releaseDate = WIKIPage.verifyTheReleaseDate();
		Assert.assertEquals(releaseDate, "17 December 2021");
		Reporter.log("[ASSERT PASSED]: Release Date is "+releaseDate);
	}	
	
	
	@AfterClass// Clossing the browser session
	public void tearDown(){
		driver.quit();
	}

}
