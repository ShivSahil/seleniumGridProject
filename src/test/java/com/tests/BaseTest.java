package com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;
	
	
	@BeforeTest
	@Parameters({ "expectedTestResult" })
	public void setDriver() throws InterruptedException, MalformedURLException {
		
		//In the BaseTest.java class, we are passing which browser we want and also passing selenium grid's url 
		
		
		// below are default values which is given to host and
        String host = "172.16.18.24";
        // DesiredCapabilities dc=DesiredCapabilities.chrome();

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
        	dc = DesiredCapabilities.chrome();
        }else{
            
            dc = DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

       // String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        //dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        
        	// earlier implementations
			//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver");
			//		this.driver = new ChromeDriver();
					Thread.sleep(10000);
			//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void quit() {
		this.driver.quit();
	}

}
