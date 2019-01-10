package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends HomePage {

	static By email = By.cssSelector("input#ap_email");

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public static void validateLoginFlow() {
		WebElement element = driver.findElement(email);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(element)).isEnabled();
	}

	public static void backToHomePage() {
		driver.navigate().back();
	}
}
