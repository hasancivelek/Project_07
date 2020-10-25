package com.qa.hotels.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	//WebDriver driver;
	Properties prop;

	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public WebDriver init_driver(String browserName){
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		//	driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
			
		}else{
			
		}
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//return driver;
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	public Properties init_properties(){
		prop=new Properties();
		String path="/Users/mrs.z./Desktop/HasanNew/Hotels.com-Hasan/src/main/java/com/qa/hotels/com/config/config.properties";
		
		try {
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);
			
		} catch (NoSuchFileException e) {
			System.out.println("some problem occured while prop loading. Please check your config");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}


}
