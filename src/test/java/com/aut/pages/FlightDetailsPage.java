package com.aut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;


	@FindBy(name = "passCount")
	private WebElement passCountDropdown;
	
	@FindBy(name = "findFlights")
	private WebElement findFlightsButton;
	
	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void flightsDetailsSection(String NoOfpasscount) throws InterruptedException {
		Thread.sleep(12000);
		Select select = new Select(passCountDropdown);
		select.selectByValue(NoOfpasscount);
		//System.out.println(NoOfpasscount);
	}
	
	public void clickContinueButton() {
		this.findFlightsButton.click();
	}
	
}
