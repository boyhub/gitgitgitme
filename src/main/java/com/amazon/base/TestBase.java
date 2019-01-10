package com.amazon.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static void openBrowser(String b) { // Open browser method

		if (b.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (b.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
	}

	public static void maxiMizeAndClearCookies() { // Maximize and Cookies clearing method
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void inputURL(String url) { // Input URL method
		driver.get(url);
	}

	public static void closeBrowser() { // Close browser method
		driver.quit();
	}

	public static void takeScreenShot() throws Exception { // Take Screenshot method
		Thread.sleep(2000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screentShots/" + System.currentTimeMillis() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
