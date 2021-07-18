package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class UsefulLInksRepository extends PageBase{
	@FindBy (xpath="//td[3]")
	public List<WebElement>  links;
	@FindBy (tagName="th")
	public List<WebElement> headers;
	@FindBy (tagName="td")
	public List<WebElement> tableData;
	@FindBy (tagName="tr")
	public List<WebElement> row;
}
