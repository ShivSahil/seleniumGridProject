package com.aut.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aut.pages.FlightDetailsPage;
import com.aut.pages.OrderConfirmationPage;
import com.aut.pages.RegistrationConfirmationPage;
import com.aut.pages.RegistrationPage;
import com.aut.pages.SelectFlightPage;
import com.tests.BaseTest;


public class BookFlightTest extends BaseTest{


	private String noOfPassengers;
	private String expectedTextConf;
	

	@Test 
	@Parameters({"noOfPassengers","expectedTextConf"})
	public void registrationPage(String noOfPassengers, String expectedTextConf) throws InterruptedException {
		this.noOfPassengers=noOfPassengers;
		this.expectedTextConf=expectedTextConf;
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.setContactInformationSection("shiv", "guleri");
		registrationPage.setUserInformationSection("shiv@tutanota.io", "12124", "12124");
		registrationPage.clickSubmitButton();
	}

	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmation() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.clickFlightsDetailsLink();
	}

	@Test(dependsOnMethods = "registrationConfirmation")
	public void flightDetailsPage() throws InterruptedException {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.flightsDetailsSection(noOfPassengers);
		flightDetailsPage.clickContinueButton();
	}

	@Test(dependsOnMethods = "flightDetailsPage")
	public void selectFlightPage() {
		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
		selectFlightPage.clickContinueButton();
		selectFlightPage.clickCbuyFinglightButton();
	}

	@Test(dependsOnMethods = "selectFlightPage")
	public void orderConfirmationPage() {
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		Assert.assertTrue(orderConfirmationPage.verifyConfirmation().contains(expectedTextConf));
		orderConfirmationPage.signOff();
	}
}
