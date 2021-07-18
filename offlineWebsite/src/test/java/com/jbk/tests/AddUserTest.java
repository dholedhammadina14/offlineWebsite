package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jbk.pages.AddUserPage;
import com.jbk.pages.UsersPage;

public class AddUserTest  extends TestBase{
	WebDriver driver =null;
	public AddUserPage aup=null;
	public UsersPage up=null;
	@BeforeClass
	public void setUp() {
		driver=initialization();
		aup=loadLoginPage(driver).navigateToDashboardPage(driver).navigateToUserPage(driver).clickAddUser();
		aup=new AddUserPage(driver);
	}
	@Test
	public void verifyTitle() {
		Assert.assertTrue(aup.verifyAddUserTitle());
	}
	@Test
	public void verifyAddUser() {
		Assert.assertTrue(aup.verifyAddUser());
	}
}
