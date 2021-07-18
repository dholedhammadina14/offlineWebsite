package com.jbk.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jbk.pages.LoginPage;

public class TestBase {
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	public static WebDriver driver=null;
	LoginPage lp=null;
	FileInputStream fis=null;
	Properties prob=null;
	public Logger log;
	public static  ExtentTest extentTest;
	public static ExtentTest extentTest1;
	/////////////
//	public ExtentHtmlReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest extentTest;
//	public static ExtentTest testlogger;
//	public ExtentTest extentTest1;
//	ITestResult result;
	///////
	public String readPropertyFile(String fileName,String probName) {
		String value=null;
		try{
			fis=new FileInputStream(fileName);
			prob=new Properties();
			prob.load(fis);
			value=prob.getProperty(probName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public WebDriver initialization() {
		String url=readPropertyFile("config.properties", "url");
		String browser=readPropertyFile("config.properties", "browser");
		if("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);

		return driver;
	}
	public  LoginPage loadLoginPage(WebDriver driver) {
		lp=new LoginPage(driver);
		return lp;
	}
	public Logger testLogs() {
		log=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir")+"/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return log;
	}
	//This method is to capture the screenshot and return the path of the screenshot.
	 public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
	 }
	@BeforeSuite
	public void StartReport() {
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
     	// Create an object of Extent Reports
		 extent = new ExtentReports();  
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
     	extent.setSystemInfo("Environment", "Production");
     	extent.setSystemInfo("User Name", "Dhamma ");
     	htmlReporter.config().setDocumentTitle("JBK Ofline Website "); 
             // Name of the report
     	htmlReporter.config().setReportName("Extent Report of Project "); 
             // Dark Theme
     	htmlReporter.config().setTheme(Theme.STANDARD);		
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	@AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
	 //MarkupHelper is used to display the output in different colors
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	 //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
	 //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
	 String screenshotPath = getScreenShot(driver, result.getName());
	 //To add it in the extent report 
	 logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	 }
	 else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	 } 
	 else if(result.getStatus() == ITestResult.SUCCESS)
	 {
	 extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	 }
	// driver.quit();
	 }
	@BeforeTest
	public void allPages() {
		extentTest=extent.createTest("All Pages","All Pages Test Cases............");
	}
}
