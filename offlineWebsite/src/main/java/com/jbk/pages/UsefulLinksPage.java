package com.jbk.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.repository.UsefulLInksRepository;
import com.jbk.utilites.ExcelUtils;
import com.jbk.utilites.Utility;

public class UsefulLinksPage extends UsefulLInksRepository{
	public Logger log=Logger.getLogger(UsefulLinksPage.class);
	public static WebDriver driver=null;

	public UsefulLinksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	String fileName="UsefulLinksTable.xls";
	String sheetName="links";
	
	public boolean validCUsefulLInksTitle() {
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Useful Links";
		if(actTitle.equals(expTitle)) {
			pageLogs().info("Title is matched.");
			return true;
		}else {
			pageLogs().info("Title is not matched.");
			return false;
		}
	}
	public boolean windowHandler() {
		String mainID=driver.getWindowHandle();
		for(WebElement ele:links) {
			ele.click();
		}
		Set<String>set=driver.getWindowHandles();
		Iterator<String>itr=set.iterator();
		while(itr.hasNext()) {
			List<String> list=new ArrayList<String>();
			String childID=itr.next();
			if(!mainID.equals(childID)) { 
				pageLogs().info("The ChildWindow Id"+childID);
				String title=driver.getTitle();
				driver.switchTo().window(childID);
				
				list.add(title);
				driver.close();
			}else {
				pageLogs().info("I am in Main Window.");
			}
		}
		driver.switchTo().window(mainID);
		return true; 
	}

	public void verifyGolinkClickwithWindowHandler()  {
		
		String mainWindow=driver.getWindowHandle();
		System.out.println(mainWindow);
		List<WebElement> listOfGoLink=driver.findElements(By.xpath("//span[text()='Go !']"));
		for(WebElement goLink:listOfGoLink) {
			System.out.println("print text of go link"+goLink.getText());
			goLink.click();
		}
		Set<String> set=driver.getWindowHandles();
		Iterator<String> itr=set.iterator();
		while(itr.hasNext()) {
			String childWindow=itr.next();
			System.out.println(childWindow);
			if(!mainWindow.equals(childWindow)) {
				String titleOfChildWindow=driver.switchTo().window(childWindow).getTitle();
				System.out.println("Title of child window::"+titleOfChildWindow);
				driver.close();
			}
			driver.switchTo().window(mainWindow);
	
		}
		
	}

	public boolean verifyTable() {
		String key=null;
		HashMap<String, List<String>> actHm=new HashMap<String, List<String>>();
		HashMap<String, List<String>> expHm=new HashMap<String, List<String>>();
		List<String> value=new ArrayList<String>();
		for(WebElement ele:headers) {
			
			if(headers.indexOf(ele)==0)
				 key=Utility.getTextData(ele);
			else
				value.add(Utility.getTextData(ele));
			}
		actHm.put(key, value);
		key=null;
		value=null;
		for(int i=2;i<row.size();i++) {
			List<WebElement> rowData = driver.findElements(By.xpath("//tr[" + i + "]/td"));
			value = new ArrayList<String>();
			for(WebElement data:rowData ) {
				if(rowData.indexOf(data)==0)
					key=Utility.getTextData(data);
				else
					value.add(Utility.getTextData(data));
			}
			actHm.put(key, value);
			}
		log.info(actHm);
		String key1=null;
		for(int i=0;i<7;i++) {
			 key1=ExcelUtils.getCellData(i, 0, fileName, sheetName);
			List<String>value1=new ArrayList<String>();
			for(int j=1;j<3;j++) {
				 value1.add(ExcelUtils.getCellData(i, j, fileName, sheetName));
			}
			expHm.put(key1, value1);
			}
		pageLogs().info(expHm);
		return true;
	}
}
