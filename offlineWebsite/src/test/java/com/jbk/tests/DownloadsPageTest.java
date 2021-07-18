package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jbk.pages.DownloadsPage;

public class DownloadsPageTest extends TestBase{
	WebDriver driver=null;
	public DownloadsPage dp=null;
		@BeforeClass
		public void setUp() {
			driver=initialization();
			dp=loadLoginPage(driver).navigateToDashboardPage(driver).navigateToDownloadpage(driver);
			//dp=new DownloadsPage(driver);
		}
	@Test
	public void verifyVendorWithVersion() {
		Assert.assertTrue(dp.verifyGoogleChromeWithVersion());
	}
	@Test
	public void verifyVendorWithout32And64bit(){
		Assert.assertTrue(dp.vendorWithout32bitAnd64bit());
	}

}
