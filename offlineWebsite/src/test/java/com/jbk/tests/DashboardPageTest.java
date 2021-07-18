package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.pages.DashboardPage;
import com.jbk.pages.LoginPage;

public class DashboardPageTest extends TestBase{
	WebDriver driver=null;
	public LoginPage lp=null;
    public	DashboardPage dp=null;
    public ExtentTest extenttestPerPage=null;
   
	@BeforeMethod
	public void setUp()
	{
		driver=initialization();
		 dp=loadLoginPage(driver).navigateToDashboardPage(driver);
		 lp=new LoginPage(driver);		
	}
	@BeforeClass
	public void perPage() {
		extenttestPerPage=extentTest.createNode("DashboardPage Test Cases");
	}

	@Test(priority=0)
	public void verifyDashboardPageTitle() {
		ExtentTest extentTest1 =extenttestPerPage.createNode(" Test Case:: Verify Title");
		extentTest1.info("Verify the title of the Dashboard Page.");		
		Assert.assertTrue(dp.dashboardTitle(extentTest1));
	}
	@Test(priority=2)
	public void verifyJBKCourses() {
		ExtentTest extentTest1=extenttestPerPage.createNode("Test Case:: Verify courses present in Dashboard Page");
		extentTest1.info("To verify courses available in jbk OflineWebsite.");
		Assert.assertTrue(dp.verifyCourses(extentTest1));
	}
	@Test(priority=1)
	public void verifyText() {
		ExtentTest extentTest1=extenttestPerPage.createNode("Test Case:: Verify Course Title");
		extentTest1.info("To verify the text in dashboard.");
		Assert.assertTrue(dp.dashboardText(extentTest1));
	}
	@Test(priority=3)
	public void verifyCourseColour() {
		ExtentTest extentTest1=extenttestPerPage.createNode("Test Case:: Verify Course Textbox colour.");
		extentTest1.info("To verify the colour of courses.");
		Assert.assertTrue(dp.verifyCourseColor(extentTest1));
	}
	@Test(priority=4)
	public void verifyCourseSymbol() {
		ExtentTest extentTest1=extenttestPerPage.createNode("Test Case:: Verify courseSymbol in courseTexbox");
		extentTest1.info("To verify the symbol of the course");
		Assert.assertTrue(dp.verifyCourseSymbol(extentTest1));
	}
}
