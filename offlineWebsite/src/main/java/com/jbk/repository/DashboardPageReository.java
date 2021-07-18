package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class DashboardPageReository extends PageBase {

	@FindBy (xpath="//span[text()='Users']")
	public WebElement users;
	@FindBy (xpath="//span[text()='Operators']")
	public WebElement operators;
	@FindBy (xpath="//span[text()='     Useful Links']")
	public WebElement usefulLinks;
	@FindBy (xpath="//span[text()='Downloads']")
	public WebElement downloads;
	@FindBy (xpath="//h3")
	public List<WebElement> courses;
	@FindBy (xpath="//h1")
	public WebElement text;
	@FindBy (xpath="")
	public List <WebElement> navigation;
}
