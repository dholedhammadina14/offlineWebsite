package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jbk.pages.DashboardPage;
import com.jbk.pages.LoginPage;

import com.jbk.pages.UsersPage;

public class UsersPageTest extends TestBase {
	WebDriver driver = null;
	public UsersPage up = null;
	public DashboardPage dp = null;
	public LoginPage lp = null;

	@BeforeClass
	public void setUp() {
		driver = initialization();
		up = loadLoginPage(driver).navigateToDashboardPage(driver).navigateToUserPage(driver);
		up=new UsersPage(driver);
	}

	@Test
	public void verifyUsersPageTitle() {

		Assert.assertTrue(up.usersPageTitle());
	}

	@Test
	public void verifyExcelWithWeb() {
		Assert.assertTrue(up.verifyExcelDataWithWebdata());
	}

	@Test
	public void verifyTable() {
		Assert.assertTrue(up.verifyWebTableWithExcelTable());
	}

	@Test
	public void verifyEmailcode() {
		Assert.assertTrue(up.verifyEmailcode());
	}
	@Test
	public void mobileTest() {
		org.testng.asserts.SoftAssert sa = new org.testng.asserts.SoftAssert();
		for(boolean b :up.mobileLength()) {
			sa.assertTrue(b);
		}
		sa.assertAll();
	}
}
