package com.jbk.tests;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public LoginPage lp=null;
	WebDriver driver=null;
	ExtentTest extenttestPerPage = null;
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		lp=new LoginPage(driver);
		//driver.manage().window().maximize();
	}
	@BeforeClass
	public void perPage() {
		extenttestPerPage=extent.createTest("Login Page Test Casses::");
	}
	@Test
	public void validateText() {
		logger=extent.createTest("To verify the login page Text Before textBox ");
		Assert.assertTrue(lp.verifyText());
	}
	@Test
	public void verifyTitle() {
		ExtentTest extentTest1=extenttestPerPage.createNode("test case  :: checkTitle");
		extentTest1.info("To verify Title of LOgin Page.");
		testLogs().info("here we verify Title of app LoginPage");
		Assert.assertTrue(lp.verifyApplicationLoginTitle(extentTest1));
	}
	@Test
	public void verifyLogin(){
	logger = extent.createTest("To verify Dashboard page is open after Log in ");
		Assert.assertTrue(lp.verifyLogin());
	}
	@Test
	public void verifyLogo() {
	logger = extent.createTest("To verify the Logo of login page.");
		Assert.assertTrue(lp.verifyAppLogo());
	}

	@Test
	public void verifyHeading() {
		//logger = extent.createTest("To verify heading in login page.");
		Assert.assertTrue(lp.validHeading());
	}
	@Test
	public void verifyHeading1() {
		logger = extent.createTest("To verify headings.");
		Assert.assertTrue(lp.validHeading1());
	}
	@Test
	public void verifyRegLink() {
		logger = extent.createTest("To verify whether link is working or not.");
		Assert.assertTrue(lp.validRegisterLink());
	}
	@Test
	public void verifyRegText() {
		logger = extent.createTest("To verify text in register page after click on RegisterLink");
		Assert.assertTrue(lp.validRegisterText());
	}
	
}