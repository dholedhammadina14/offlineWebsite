package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.repository.LoginPgeRepository;
import com.jbk.utilites.Utility;

public class LoginPage extends LoginPgeRepository {
	// public Logger log=Logger.getLogger(LoginPage.class);
	WebDriver driver;
	ExtentTest test;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyApplicationLoginTitle(ExtentTest test) {
		test.info("Verify the Title of the Application. ");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		String expTitle = "JavaByKiran | Log in";
		test.info("check the Title of the Application.");
		if (actTitle.equals(expTitle)) {
			pageLogs().info("ApplicationLoginTitle is match.");
			//test.info("ApplicationLoginTitle is matched");
			return true;
		} else {
			pageLogs().info("ApplicationLoginTitle is not match.");
			//test.info("ApplicationLoginTitle is not matched");
			return false;
		}

	}

	public boolean verifyText() {
		System.out.println(3);
		String actualText = Utility.getTextData(text);
		pageLogs().info(actualText);
		String expectedText = "Sign in to start your session";
		if (actualText.equals(expectedText)) {
			pageLogs().info("Text is match");
			return true;
		} else {
			pageLogs().info("Text is not match");
			return false;
		}
	}

	public boolean verifyLogin() {
		Utility.EnterTextToSendkeys(uname, "kiran@gmail.com");
		Utility.EnterTextToSendkeys(password, "123456");
		Utility.click(btnLogin);
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Dashboard";
		if (actTitle.equals(expTitle)) {
			pageLogs().info("Login verified.open dashboard page.");
			return true;
		} else {
			pageLogs().info("email or password is wrong");
			return false;
		}

	}

	public boolean validRegisterText() {
		String actText = Utility.getTextData(regLink);
		String expText = "Register a new membership";
		if (actText.equals(expText)) {
			pageLogs().info("link text is verified");
			return true;
		} else {
			pageLogs().info("link text not verified.");
			return false;
		}
	}

	public boolean validRegisterLink() {
		regLink.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Registration Page";
		if (actTitle.equals(expTitle)) {
			pageLogs().info("Registration page is open.");
			return true;
		} else {
			pageLogs().info("Registration page is not open.");
			return false;
		}
	}

	public boolean verifyAppLogo() {
		boolean flag = image.isDisplayed();
		if (flag = true) {
			pageLogs().info("image is displayed.");
			return true;
		} else {
			pageLogs().info("image is not displayed.");
			return false;
		}
	}

	public boolean validHeading() {
		String actHed = Utility.getTextData(heading);
		String expHed = "Java By Kiran";
		if (actHed.equals(expHed)) {
			pageLogs().info("heading is verified.");
			return true;
		} else {
			pageLogs().info("heading is  not verified");
			return false;
		}
	}

	public boolean validHeading1() {
		String actHed1 = Utility.getTextData(heading1);
		String expHed1 = "JAVA | SELENIUM | PYTHON";
		if (actHed1.equals(expHed1)) {
			pageLogs().info("heading1 is verified.");
			return true;
		} else {
			pageLogs().info("heading1 is  not verified");
			return false;
		}
	}

	public DashboardPage navigateToDashboardPage(WebDriver driver) {
		Utility.EnterTextToSendkeys(uname, "kiran@gmail.com");
		Utility.EnterTextToSendkeys(password, "123456");
		Utility.click(btnLogin);
		return new DashboardPage(driver);

	}

}
