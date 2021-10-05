package com.neotech.lesson02;

import org.testng.annotations.Test;

public class DependsDemo {

	@Test
	public void firstTest() {
		System.out.println("firstTest Method");
	}

	@Test
	public void secondTest() {
		System.out.println("secondTest Method");
	}

	@Test(dependsOnMethods = { "firstTest", "secondTest" })
	public void thirdTest() throws Exception {
		System.out.println("thirdTest Method");

		throw new Exception(); // We are failing the test
	}

	@Test(dependsOnMethods = "thirdTest")
	public void fourthTest() {
		System.out.println("fourthTest Method");
	}

}
