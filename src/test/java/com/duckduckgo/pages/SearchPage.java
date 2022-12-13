package com.duckduckgo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "q")
	private WebElement searchBox;
	
	@FindBy(xpath="(//article[@id='r1-0']//span)[3]")
	private WebElement firstsearch;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("https://duckduckgo.com/");
	}

	public String doSearch(String keyword)
	{
		this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
		this.searchBox.sendKeys(keyword);
		this.searchBox.sendKeys(Keys.ENTER);
		this.wait.until(ExpectedConditions.visibilityOf(this.firstsearch));
		System.out.println(this.firstsearch.getText());
		return this.firstsearch.getText();
	}

}
