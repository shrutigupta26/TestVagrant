package com.BaseAnnotation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	
	protected WebDriver driver;
	public static Properties prop;

	//Fetching the data from the config file
	public Base(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/com/configProperty/configProperty");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialization(String browser) {
		DesiredCapabilities dc = new DesiredCapabilities();
		browser = prop.getProperty("browser");
		String seleniumserver = prop.getProperty("seleniumserver");
		if(seleniumserver.equalsIgnoreCase("local")) {
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/test/resources/Driver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/src/test/resources/Driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	}
		else if(seleniumserver.equalsIgnoreCase("remote")) {
			if(browser.equals("chrome")) {
				try {
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL(prop.getProperty("seleniumserverhost")), dc);
				}
				catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	

}
