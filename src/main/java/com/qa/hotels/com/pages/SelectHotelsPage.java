package com.qa.hotels.com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.com.util.ElementUtil;
import com.qa.hotels.com.util.JavaScriptUtil;


public class SelectHotelsPage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jSUtil;
	SelectHotelsPage hotelsPage;
	
	
	By chooseStar3 = By.cssSelector("#f-star-rating-3");
	By chooseStar4 = By.cssSelector("#f-star-rating-4");
	By chooseStar5 = By.cssSelector("#f-star-rating-5");
	By hotelName = By.cssSelector("#f-name");
	By clickhotelName = By.id("f-name-cta");
	By listingHotel = By.className("p-name");
	By chooselandmarks = By.cssSelector("#filter-landmarks");
	By chooseairrport = By.id("f-lid-1664964");
	By mile= By.cssSelector("#f-distance");
	
	By loadBtn = By.cssSelector(".listings-pagination-cta");

	
	public SelectHotelsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		jSUtil=new JavaScriptUtil(driver);
		
	}
	
	public void verifyHilton() {
		elementUtil.doSendKeys(hotelName, "Hilton");
		elementUtil.doClick(clickhotelName);

		elementUtil.doClick(chooseStar3);

		List<WebElement> list = elementUtil.getElements(listingHotel);

		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println(text);
			if (text.contains("Hilton")) {
				System.out.println("Hilton is 3 star hotel");
			}
		}

	}

	public void chooseHotelsFeature(){
		
		JavaScriptUtil.specificScrollPageDown(driver);
		elementUtil.doClick(chooselandmarks);
		elementUtil.doClick(chooseairrport);
		elementUtil.doClick(mile);

		elementUtil.handleDropDownMenuByValue(mile, "5.0");

	}

	public List<String> getAll3StarsHotels()  {
		
		elementUtil.doClick(chooseStar3);
		hotelsPage=new SelectHotelsPage(driver);
		hotelsPage.chooseHotelsFeature();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		JavaScriptUtil.scrollPageDown(driver);
	
		List<WebElement> listhotel = elementUtil.getElements(listingHotel);
		System.out.println(listhotel.size());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingHotel));
		ArrayList<String> hotels = new ArrayList<String>();
		for (WebElement elements : listhotel) {
			hotels.add(elements.getText());
		}
		List<String> list = hotels;
		System.out.println(list + "3 star hotels list");
		return list;
	}

	public List<String> getAll4StarHotels(){
		elementUtil.doClick(chooseStar4);
		hotelsPage=new SelectHotelsPage(driver);
		
		hotelsPage.chooseHotelsFeature();
		JavaScriptUtil.scrollPageDown(driver);
		
		
		List<WebElement> listhotel = elementUtil.getElements(listingHotel);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingHotel));
		ArrayList<String> hotels = new ArrayList<String>();
		for (WebElement elements : listhotel) {
			hotels.add(elements.getText());
		}
		List<String> list = hotels; // just tried to store as a List
		System.out.println(list + "4 star hotels list");
		return list;


	}

	public List<String> getAll5StarsHotels() {

	if(  elementUtil.doIsSelected(chooseStar5)) { 
			elementUtil.doClick(chooseStar5);
			hotelsPage=new SelectHotelsPage(driver);
			hotelsPage.chooseHotelsFeature();

		

	WebDriverWait wait = new WebDriverWait(driver, 20);

			JavaScriptUtil.scrollPageDown(driver);
			List<WebElement> listhotel = elementUtil.getElements(listingHotel);
			System.out.println(listhotel.size());
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listingHotel));
			ArrayList<String> hotels = new ArrayList<String>();
			for (WebElement elements : listhotel) {
				hotels.add(elements.getText());
			}
			List<String> list = hotels;
			System.out.println(list + "3 star hotels list");
			
			return list;
	}
	else {
		System.out.println("no choose hotel");
	}
	return null;
	}
	
	
	
}
