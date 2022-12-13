package com.aut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "(//table[@id='confirm-table']/tbody/tr/td/font)[1]")
	private WebElement flightConfirmationText;
	

	@FindBy(id = "sign-on")
	private WebElement signOnLink;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public String verifyConfirmation()
	{
		this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationText ));
		System.out.println(this.flightConfirmationText.getText());
		return this.flightConfirmationText.getText();
	}
	
	public void signOff()
	{
		this.signOnLink.click();
	}

}
