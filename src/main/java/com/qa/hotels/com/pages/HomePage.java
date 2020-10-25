package com.qa.hotels.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotels.com.util.ElementUtil;
import com.qa.hotels.com.util.JavaScriptUtil;

public class HomePage {

WebDriver driver;
ElementUtil elementUtil;
JavaScriptUtil jSUtil;

By destination=By.cssSelector("#qf-0q-destination");
//By element=By.xpath("//tr[@id='transportsqm-asi0-s0']");
By element=By.id("citysqm-asi0-s0");
By checkInBtn= By.cssSelector("#widget-query-label-2");
By checkOutBtn=By.cssSelector("#qf-0q-localised-check-out");
By checkInDate=By.xpath("//td[@data-date='2020-10-30']");
By checkOutDate=By.xpath("//td[@data-date='2020-11-15']");		

By selectRoom=By.id("qf-0q-rooms");
By selectAdult=By.id("qf-0q-room-0-adults");
By selectChild=By.id("qf-0q-room-0-children");
By selectChildAge1=By.id("qf-0q-room-0-child-0-age");
By selectChildAge2=By.id("qf-0q-room-0-child-1-age");
By searchBtn=By.xpath("//button[@type='submit']");


public HomePage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	jSUtil=new JavaScriptUtil(driver);
	
}

public SelectHotelsPage choseLocation() {
	
	
	elementUtil.doSendKeys(destination, "Cincinnati");
	elementUtil.doClick(destination);
	elementUtil.doClick(element);
	
	elementUtil.doClick(checkInBtn);
	elementUtil.doClick(checkInDate);
	elementUtil.doClick(checkOutBtn);
	elementUtil.doClick(checkOutDate);
	elementUtil.handleDropDownMenuByValue(selectRoom, "1");
	elementUtil.handleDropDownMenuByValue(selectAdult, "2");
	elementUtil.handleDropDownMenuByValue(selectChild, "2");
	elementUtil.handleDropDownMenuByValue(selectChildAge1, "4");
	elementUtil.handleDropDownMenuByValue(selectChildAge2, "9");
	elementUtil.doClick(searchBtn);
	return new SelectHotelsPage(driver);
	
}

public String verifyTitle() {
	return jSUtil.getTitleByJS(driver);
} 

}
