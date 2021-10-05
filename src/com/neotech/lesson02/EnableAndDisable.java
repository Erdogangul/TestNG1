package com.neotech.lesson02;

import org.testng.annotations.Test;

public class EnableAndDisable {

	@Test(enabled = false)
	public void firstTest() {
		System.out.println("firstTest Method");
	}

	@Test(enabled = true, priority = 1)
	public void secondTest() {
		System.out.println("secondTest Method");
	}

	@Test(enabled = false, priority = 2)
	public void thirdTest() {
		System.out.println("thirdTest Method");
	}

	@Test(priority = 3)
	public void fourthTest() {
		System.out.println("fourthTest Method");
	}
}
