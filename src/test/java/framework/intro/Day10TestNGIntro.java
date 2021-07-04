package framework.intro;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day10TestNGIntro {
	@BeforeSuite
	private void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	private void afterSuite() {
		System.out.println("AfterSuite");
	}
	@BeforeTest
	private void beforeTest() {
		System.out.println("BeforeTest");
	}
	@AfterTest
	private void afterTest() {
		System.out.println("AfterTest");
	}
	@AfterClass
	private void afterClass() {
		System.out.println("AfterClass");
	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("AfterMethod");
	}
	@Test
	private void test1() {
		System.out.println("Test1");
	}
	@Test
	private void test2() {
		System.out.println("Test2");
	}
}
