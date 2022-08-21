package com.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseAnnotation.Base;


public class IMDBPage extends Base{
	
	    WebDriver driver ;
	//Page Factory - OR:
		@FindBy(xpath="//input[@type='text']")
		WebElement searchBox;
		
		@FindBy(id="iconContext-magnify")
		WebElement searchBuuton;
		
		@FindBy(xpath="//section[@data-testid='Details']")
		WebElement details;
		
		@FindBy(xpath="(//td[@class='result_text'])[1]//a")
		WebElement movieTitle;
		
		
		@FindBy(xpath="(//div[@data-testid='title-details-section']//ul//li)[4]//a")
		WebElement countryText;
		
		@FindBy(xpath="(//div[@data-testid='title-details-section']//ul//li)[1]")
		WebElement release;
		
		@FindBy(xpath="(//a[contains(text(),'India')]/parent::td)/following-sibling::td[1]")
		WebElement releaseText;
		
		//Initializing the Page Objects:
		public IMDBPage(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(String url){
			if(url.equals("IMDB")) {
				driver.get(prop.getProperty("url_IMDB"));
			}
			else{
				driver.get(prop.getProperty("url_WIKI"));
			}
			return driver.getTitle();
		}
		
		public String verifyTheCountyName(String movie){
			searchBox.sendKeys(movie);
			searchBuuton.click();
			movieTitle.click();
			Actions action = new Actions(driver);
			action.moveToElement(details).build().perform();
			String countryName = countryText.getText();
			return countryName;
		}
		
		public String verifyTheReleaseDate(){
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			release.click();
			String movieDate = releaseText.getText();
			return movieDate;
		}

}
