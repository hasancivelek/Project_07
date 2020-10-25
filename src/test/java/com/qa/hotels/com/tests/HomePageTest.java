package com.qa.hotels.com.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic -07 : Select valid criteria")
@Feature("US -99 : create tests for ..........")
public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	
	Logger log=Logger.getLogger(HomePageTest.class);
	
@BeforeMethod
@Parameters(value= {"browser"})

public void setUp(String browser) {
	String browserName=null;
	 basePage=new BasePage();
	prop= basePage.init_properties();
	if(browser.equals(null)) {
		browserName=prop.getProperty("browser");
	}else {
		browserName=browser;
	}
	driver=basePage.init_driver(browserName);
	//driver=basePage.init_driver(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	homePage=new HomePage(driver);
	
}

@Test(priority=1, description="Select date , room , childage ", enabled=true)
@Description("Select valid date  room destination and child age ")
@Severity(SeverityLevel.CRITICAL)
public void selectDate() {
	log.info("select location date...........>");
	homePage.choseLocation();
	
}

@Test(priority=2, description="Verify Page Title", enabled=true)
@Description("Verify page title")
@Severity(SeverityLevel.NORMAL)
public void verifyHomePageTitle(){
	log.info("verify page title...........>");
	String title = homePage.verifyTitle();
	System.out.println(title);
	Assert.assertEquals(title,"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");
	log.info("ending verify home page title.........>");

}

@AfterMethod
public void tearDown() {
	driver.close();
}

}
