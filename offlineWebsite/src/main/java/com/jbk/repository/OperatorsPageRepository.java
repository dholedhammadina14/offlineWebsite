package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class OperatorsPageRepository extends PageBase {
	@FindBy(xpath = "//td[2]")
	public List<WebElement> persons;
	@FindBy(xpath = "//td[3]")
	public List<WebElement> roles;
	@FindBy (xpath="//td[4]")
	public List<WebElement> media;
	@FindBy (xpath="//th")
	public List<WebElement> headers;
	@FindBy (xpath="//td[1]")
	public List<WebElement> srno;
	@FindBy (xpath="//td[6]")
	public List<WebElement> timingCol;
	@FindBy (xpath="//td[5]")
	public List<WebElement> contacts;
	
	
}
