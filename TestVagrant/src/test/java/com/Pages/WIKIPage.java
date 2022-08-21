package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseAnnotation.Base;

public class WIKIPage extends Base{
	
			WebDriver driver;
	//Page Factory - OR:
			@FindBy(xpath="//input[@type='search']")
			WebElement searchBox;
			
			@FindBy(id="searchButton")
			WebElement searchBuuton;
						
			@FindBy(xpath="//th[contains(text(),'Country')]/following-sibling::td")
			WebElement countryText;
			
			@FindBy(xpath="(//div[contains(text(),'Release date')]/parent::th)/following-sibling::td//ul//li")
			WebElement releaseText;
			
			//Initializing the Page Objects:
			public WIKIPage(WebDriver driver){
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
				String countryName = countryText.getText();
				return countryName;
			}
			
			public String verifyTheReleaseDate(){
				String movieDate = releaseText.getText();
				return movieDate;
			}

}
