package basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsExample

{

	@BeforeSuite

	public void beforeSuite() {
		System.out.println("Executed Before Suite ");
	}

	@BeforeTest

	public void beforeTest() {
		System.out.println("Executed before Test");
	}

	@BeforeClass

	public void beforeClass() {
		System.out.println("Executed before Class");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executed before Method");
	}
	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("Executed before Method2");
	}

	@Test
	public void testcase1() {
		System.out.println("Executed test case1");
	}
	
	@Test
	public void testcase2()
	{
		System.out.println("Executed testcase 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Executed after Method");
	}
	@AfterMethod
	public void afterMethod2() {
		System.out.println("Executed after Method 2");
	}

	@AfterClass

	public void afterClass() {
		System.out.println("Executed after Class");

	}

	@AfterTest

	public void afterTest() {
		System.out.println("Executed after Test");
	}

	@AfterSuite

	public void afterSuite() {
		System.out.println("Executed After Suite ");
	}

}
