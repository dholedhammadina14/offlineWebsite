package com.jbk.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.repository.DashboardPageReository;
import com.jbk.utilites.Utility;

public class DashboardPage extends DashboardPageReository {
	public Logger log=Logger.getLogger(DashboardPage.class);
	WebDriver driver=null;

	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean dashboardTitle(ExtentTest test) {
		test.info("Verify The Title of the Page.");
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Dashboard";
		if(actTitle.equals(expTitle)) {
			pageLogs().info("DashboardPage Title is verified");
			test.info("DashboardPage Title is verified");
			return true;
		}else {
			pageLogs().info("DashboardPage Title is not verified.");
			test.info("DashboardPage Title is not verified");
			return false;
		}
	}
	public boolean dashboardText(ExtentTest test) {
		test.info("course title matching with expected data.");
		String actText=Utility.getTextData(text);
		pageLogs().info(actText);
		String exptext="Dashboard Courses Offered";
		if(actText.equals(exptext)) {
			pageLogs().info("Text is matched.");
			return true;
		}else {
			pageLogs().info("Text is not matched.");
			return false;
		}
			
	}
	public boolean verifyCourses(ExtentTest test) {
		test.info("To verify the actual course with expected course.");
		test.info("First we take actual data from website.");
		ArrayList<String> expCourse=new ArrayList<String>();
		test.info("Actual data in the form of list");
		expCourse.add("Selenium");
		expCourse.add("Java / J2EE");
		expCourse.add("Python");
		expCourse.add("Php");
		ArrayList<String> actCourses=new ArrayList<String>();
		for(WebElement course: courses )
		{
			String value=Utility.getTextData(course);
			actCourses.add(value);
		}
		pageLogs().info(actCourses);
		test.info("Expected data from excel");
		if(actCourses.equals(expCourse)) {
			test.info("If actual and expected are equal then courses are verified.");
			pageLogs().info("Courses are verified.");
			return true;
			}
		else {
			test.info("if not equal then not verified.");
			pageLogs().info("Courses are not verified");
			return false;
		}
	}
	public boolean verifyCourseColor(ExtentTest test) {
		test.info("To verify the different colour for courses.");
		test.info("We have list of colour for courses.");
		test.info("we iterate list using for each loop.");
		List<WebElement> course=driver.findElements(By.xpath("//div[contains(@class,'small-box')]"));
		for(WebElement e: course) {
			String text=e.getAttribute("class");
			String colour=text.substring(text.lastIndexOf('-')+1);
			test.info("");
			pageLogs().info(colour);
		}
		return true;
	}
	public boolean verifyCourseSymbol(ExtentTest test) {
		List<WebElement> icons=driver.findElements(By.xpath("//div[@class='icon']/i"));
		for(WebElement e: icons) {
			String text=e.getAttribute("class");
			String symbol=text.substring(text.lastIndexOf('-')+1);
			pageLogs().info(symbol);
		}
		return true;
	}
	public UsersPage navigateToUserPage(WebDriver driver) {
		users.click();
		return new UsersPage(driver);
	}
	public OperatorsPage navigateToOperatorPage(WebDriver driver) {
		operators.click();
		return new OperatorsPage(driver);
	}
	public UsefulLinksPage navigateToUsefulLinksPage(WebDriver driver) {
		usefulLinks.click();
		return new UsefulLinksPage(driver);
	}
	public DownloadsPage navigateToDownloadpage(WebDriver driver) {
		downloads.click();
		return new DownloadsPage(driver);
	}
}
