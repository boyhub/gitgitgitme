package com.amazon.tests;

import org.testng.annotations.Test;

import com.amazon.pages.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestAmazon extends LoginPage {

	@BeforeTest
	public void beforeTest() {
		openBrowser("Chrome");
		maxiMizeAndClearCookies();
		inputURL("https://www.amazon.in/");
	}

	@Test(priority = 1) // It will Validate Sign In Link and Throw an ALERT
	public void validateSignInLinkTest() {
		signInLink();
	}

	@Test(priority = 2) // It will print NUMBER of banners in the CONSOLE screen (i.e., O/P screen)
	public void numberOfBannersTest() {
		numberOfBanners();
	}

	@Test(priority = 3) // Navigate to LoginPage and take screenshot and return back to Home page
	public void validateLoginFlowTest() throws Exception {
		goToLoginPage();
		validateLoginFlow();
		takeScreenShot();
		backToHomePage();
	}

	@Test(priority = 4) // Click Pincode block and change the Pincode and apply
	public void validatePincodeChangeFlowTest() {
		clickPincodeBlock();
		clickChangeLink();
		enterPincode("400001");
		clickApplyButton();
		clickDoneButton();
	}

	@AfterTest
	public void afterTest() {
//		driver.quit();
	}
}
