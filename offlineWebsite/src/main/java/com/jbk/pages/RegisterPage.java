package com.jbk.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jbk.utilites.PageBase;


public class RegisterPage extends PageBase {
	public Logger log=Logger.getLogger(RegisterPage.class);
	WebDriver driver=null;
	public RegisterPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle() {
		String actTitle=driver.getTitle();
		String expectTitle="JavaByKiran | Registration Page";
		if(actTitle.equals(expectTitle)) {
			pageLogs().info("Title of RegisterPage is verified.");
			return true;
		}else {
			pageLogs().info("actTitle and expectTitle not equal.");
			return false;
		}
		
	}
}
