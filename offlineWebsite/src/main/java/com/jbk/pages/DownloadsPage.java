package com.jbk.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.repository.DownloadsPageRepository;

public class DownloadsPage  extends DownloadsPageRepository{
	public Logger log=Logger.getLogger(DownloadsPage.class);
	WebDriver driver=null;
	public DownloadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean verifyGoogleChromeWithVersion() {
		 for(int i=0;i<vendors.size();i++) {
			List<String> vendVerList=new ArrayList<String>();
			String vendor=vendors.get(i).getText();
			String version=versions.get(i).getText();
			if(vendor.contains("Google Chrome")) {
				vendVerList.add(vendor);
				vendVerList.add(version);
				pageLogs().info(vendVerList);	
			}
		}
		
		return true;
	}
	public boolean vendorWithout32bitAnd64bit() {
		for(int i=0;i<vendors.size();i++) {
			List<String> vendorlist=new ArrayList<String>();
			String vendor=vendors.get(i).getText();
			String b32=bit32.get(i).getText();
			String b64=bit64.get(i).getText();
			if(!(b32.contains("32bit")||b64.contains("64bit"))) {
				vendorlist.add(vendor);
				pageLogs().info(vendorlist );
			}
				
		}
		return true;
	}

}
