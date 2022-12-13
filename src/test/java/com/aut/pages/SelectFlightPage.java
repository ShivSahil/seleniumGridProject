package com.aut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "reserveFlights")
	private WebElement continueutton;
	
	@FindBy(name = "buyFlights")
	private WebElement buyFinglightButton;
	
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	public void clickContinueButton() {
		this.continueutton.click();
	}
	
	public void clickCbuyFinglightButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFinglightButton));
		this.buyFinglightButton.click();
	}
}
