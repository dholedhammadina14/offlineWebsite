package com.jbk.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.RegisterPage;

public class RegisterPageTest extends TestBase {
	RegisterPage rp=null;
	WebDriver driver=null;
	@BeforeMethod
	public void setUp() {
		driver=initialization();
		driver.findElement(By.partialLinkText("Register")).click();
		//rp=new RegisterPage(driver);
	}
	@Test
	public void verifyTitle() {
		Assert.assertTrue(rp.verifyTitle());
	}
}
