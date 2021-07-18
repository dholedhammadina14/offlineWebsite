package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jbk.pages.UsefulLinksPage;

public class UsefulLinksPageTest extends TestBase{

	WebDriver driver=null;
	public UsefulLinksPage ulp=null;
	@BeforeClass
	public void setUp() {
		driver=initialization();
		ulp=loadLoginPage(driver).navigateToDashboardPage(driver).navigateToUsefulLinksPage(driver);
		ulp=new UsefulLinksPage(driver);
	}
	@Test
	public void verifyTitle() {
		Assert.assertTrue(ulp.validCUsefulLInksTitle());
	}
	@Test
	public void verifyTilteOfChildWindow() {
		Assert.assertTrue(ulp.windowHandler());
	}
	@Test
	public void verifyWebTableWithExcelTable() {
		Assert.assertTrue(ulp.verifyTable());
	}
	
	 

}
