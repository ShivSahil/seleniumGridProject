package com.aut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(name = "email")
	private WebElement userNameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(name = "register")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public void goTo() throws InterruptedException {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		Thread.sleep(20000);
		
		// this is how we would know that page has loaded
		PageFactory.initElements(driver, this);
		//this.wait.until(ExpectedConditions.visibilityOf(this.firstNameField));
	}

	public void setContactInformationSection(String firstname, String lastname) {
		this.firstNameField.sendKeys(firstname);
		this.lastNameField.sendKeys(lastname);
	}

	public void setUserInformationSection(String email, String password, String confirmPassword) {
		this.userNameField.sendKeys(email);
		this.passwordField.sendKeys(password);
		this.confirmPasswordField.sendKeys(confirmPassword);
	}

	public void clickSubmitButton() {
		this.submitButton.click();
	}

}
