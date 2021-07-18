package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class DownloadsPageRepository  extends PageBase{
	@FindBy (xpath="//td[3]")
	public List<WebElement> vendors;
	@FindBy (xpath="//td[4]")
	public List<WebElement> versions;
	@FindBy (xpath="//td[5]")
	public List<WebElement> bit32;
	@FindBy (xpath="//td[6]")
	public List<WebElement> bit64;
}
