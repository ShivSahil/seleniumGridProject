package com.duckduckgo.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.duckduckgo.pages.SearchPage;
import com.tests.BaseTest;

public class SearchTests extends BaseTest{

	private String expectedTestResult;


	@Test
	@Parameters({ "expectedTestResult" })
	public void duckduckgo(String expectedTestResult) {
		this.expectedTestResult = expectedTestResult;
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		Assert.assertTrue(searchPage.doSearch(expectedTestResult).toLowerCase().contains("java"));
	}


}
