package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	// Test Annotations go here...

	@Test
	public void titleValidation() throws Exception {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title Validation Passed!");
		} else {
			System.out.println("Title Validation Failed");
			throw new Exception();
		}

		wait(2);
	}

	@Test
	public void logoValidation() throws Exception {

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));

		boolean isDisplayed = logo.isDisplayed();

		if (isDisplayed) {
			System.out.println("Logo Validation Passed!");
		} else {
			System.out.println("Logo Validation Failed!");
			throw new Exception();
		}
		wait(2);
	}

	@Test
	public void loginValidation() throws Exception {

		WebElement username = driver.findElement(By.id("txtUsername"));

		sendText(username, ConfigsReader.getProperty("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));

		sendText(password, ConfigsReader.getProperty("password"));

		click(driver.findElement(By.id("btnLogin")));

		// Validate that Welcome Admin message is there
		// If not displayed, then the TestNG report must show it.

		String expected = "Welcome";
		
		String actual = driver.findElement(By.id("welcome1")).getText();
		
		
		if(actual.contains(expected))
		{
			System.out.println("Successfully Logged In!");
		}
		else
		{
			System.out.println("Login Failed!");
			throw new Exception();
		}
		
		
		wait(3);

	}

}
