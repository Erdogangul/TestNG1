package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This method runs before class!");
		
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("This method runs after class!");
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This method runs before the method!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This method runs after the method!");
	}
	
	@Test
	public void test1()
	{
		System.out.println("This is test1!");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is test2!");
	}
	
	@Test
	public void test3()
	{
		System.out.println("This is test3!");
	}
}