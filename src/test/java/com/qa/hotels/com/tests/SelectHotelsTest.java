package com.qa.hotels.com.tests;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.com.base.BasePage;
import com.qa.hotels.com.pages.HomePage;
import com.qa.hotels.com.pages.SelectHotelsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic -07 : Select Hotels.....")
@Feature("US -99 : create tests for ..........")
public class SelectHotelsTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	SelectHotelsPage hotelsPage;
	
	Logger log=Logger.getLogger(HomePageTest.class);

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	
	hotelsPage = homePage.choseLocation();
		

	}
	@Test(priority = 1, description = "verify Hilton is 3 star", enabled=true)
	@Description("Verify Hilton 3 stars")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyHiltonIs3Star() {
		log.info(" 3 statr hilton hotels.........>");
		hotelsPage.verifyHilton();
		log.info("ending method");
	}
	
	@Test(priority = 2, description = "Select hotels feature", enabled=true)
	@Description("Hotels Features")
	@Severity(SeverityLevel.CRITICAL)
	public void getHotelsFeature(){
		log.info("hotels feature.......>");
		hotelsPage.chooseHotelsFeature();
}


	@Test(priority = 3, description = "Get 3 star hotels ", enabled=true)
	@Description("3 star hotels")
	@Severity(SeverityLevel.NORMAL)
	public void verifyhotels3() {
		log.info("3 star hotels....>");
	  List<String> list=hotelsPage.getAll3StarsHotels();
		String hotelsLink=list.toString();
		Assert.assertTrue(true, hotelsLink);

	}
	@Test(priority = 4, description = "Get 4 star hotels ", enabled=true)
	@Description("4 star hotels")
	@Severity(SeverityLevel.NORMAL)
	public void get4StarHotels(){
		log.info("4 star hotels....>");
		List<String> list=hotelsPage.getAll4StarHotels();
		String hotelsLink=list.toString();
		Assert.assertTrue(true, hotelsLink);
		
	}
	@Test(priority=5, description="Get 5 star hotels", enabled=true)
	@Description("5 star hotels")
	@Severity(SeverityLevel.NORMAL)
	public void get5starHotelsList(){
		log.info("5 star hotels....>");
		hotelsPage.getAll5StarsHotels();

	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
