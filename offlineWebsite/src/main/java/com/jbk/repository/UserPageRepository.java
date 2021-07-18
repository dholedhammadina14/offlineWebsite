package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class UserPageRepository extends PageBase {
	@FindBy(xpath = "//td[2]")
	public List<WebElement> usernames;
	@FindBy(xpath = "//td[6]")
	public List<WebElement> genders;
	@FindBy(tagName = "th")
	public List<WebElement> headers;
	@FindBy(tagName = "td[1]")
	public List<WebElement> keys;
	@FindBy (xpath="//td[3]")
	public List<WebElement> emails;
	@FindBy (xpath="//button[text()='Add User']")
	public WebElement adduserbutton;
	@FindBy (xpath="//td[4]")
	public List<WebElement> mobiles;
}
