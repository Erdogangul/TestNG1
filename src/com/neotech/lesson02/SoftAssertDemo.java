package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {
	// Open Application
	// Verify logo is displayed
	// Enter valid credentials
	// Verify user successfully logged in by verifying welcome message

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void logoAndWelcomeValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		boolean logoDisplayed = logo.isDisplayed();

		// I am manually setting this variable to false, to fail to test
		logoDisplayed = false;

		// if (hard) assertions is used, the code will NOT continue executing
		// if (soft) assertions is used, the code will continue executing

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed, "Logo is not displayed!");

		// Logging in
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();

		boolean msgDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		soft.assertTrue(msgDisplayed, "Welcome msg not diplayed!");

		// This will collect all soft test assertions
		// and will decide if test case passed or failed
		soft.assertAll();

		// If test case failed, execution will stop after assertAll
		// This statement will not be executed
		System.out.println("After assertAll");
	}

}
