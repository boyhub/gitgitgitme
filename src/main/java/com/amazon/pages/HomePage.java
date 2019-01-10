package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.TestBase;

public class HomePage extends TestBase {
//	Homepage elements
	static By signIn = By.cssSelector("a#nav-link-yourAccount > span.nav-line-1");
	By deliverTo = By.cssSelector("span#glow-ingress-line1");
	By change = By.cssSelector("div>a#GLUXChangePostalCodeLink");
	By enterPin = By.cssSelector("input#GLUXZipUpdateInput");
	By apply = By.cssSelector("span#GLUXZipUpdate > span > input");
	By done = By.cssSelector("button#a-autoid-3-announce");

	static WebElement element;

	public HomePage() { // Initialize driver from TestBase Class
		PageFactory.initElements(driver, this);
	}

	public static void signInLink() { // Validate Sign Link method
		element = driver.findElement(signIn);
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("alert ('Sign Link is Working')");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
		} else {
			System.out.println("Sign Link have problem");
		}
	}

	public static void numberOfBanners() { // Collecting number of banners method
		List<WebElement> listOfBanners = driver.findElements(By.cssSelector("ol>li"));
		System.out.println("Number of Banners = " + listOfBanners.size());
	}

	public static void goToLoginPage() { // Navigate to Login page method
		element = driver.findElement(signIn);
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void clickPincodeBlock() { // Clicking Pincode block method
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(deliverTo));
		driver.findElement(deliverTo).click();
	}

	public void clickChangeLink() { // Clicking ChangeLink method
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(change));
		WebElement changeClick = driver.findElement(change);
		new Actions(driver).moveToElement(changeClick).click().perform();
	}

	public void enterPincode(String pincode) { // Enter Pincode in the textBox method
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(enterPin));
		driver.findElement(enterPin).clear();
		driver.findElement(enterPin).sendKeys(pincode);
	}

	public void clickApplyButton() { // Click Apply button method
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(apply));
		driver.findElement(apply).click();
	}

	public void clickDoneButton() { // Click Done button method
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(done));
		driver.findElement(done).click();
	}
}
