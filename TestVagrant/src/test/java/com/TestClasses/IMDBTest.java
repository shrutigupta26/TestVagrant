package com.TestClasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.IMDBPage;
import com.BaseAnnotation.Base;

public class IMDBTest extends Base{
	IMDBPage IMDBPage;
	
	public IMDBTest(){
		super();// Calling the super class constructor
	}
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional String browser){
		initialization(browser);// Initiating the browser session
		IMDBPage = new IMDBPage(driver);		
	}
	
	@Test
	public void Test01_loginPageTitleTest(){
		String title = IMDBPage.validateLoginPageTitle("IMDB");
		Assert.assertEquals(title, "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
	}
	
	@Test
	public void Test02_verifyTheCountryName(){
		String countryName = IMDBPage.verifyTheCountyName("Pushpa:The Rise");
		Assert.assertEquals(countryName, "India");
		Reporter.log("[ASSERT PASSED]: Country Name is "+countryName);
	}
	
	@Test
	public void Test03_verifyTheReleaseDate(){
		String releaseDate = IMDBPage.verifyTheReleaseDate();
		Assert.assertEquals(releaseDate, "17 December 2021");
		Reporter.log("[ASSERT PASSED]: Release Date is "+releaseDate);
	}	
	
	
	@AfterClass// Clossing the browser session
	public void tearDown(){
			driver.quit();
	}
	
	

}
