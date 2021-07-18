package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public class AddUserRepository extends PageBase {
	@FindBy (id="username")
	public WebElement uname;
	@FindBy (id="mobile")
	public WebElement mobile;
	@FindBy (id="email")
	public WebElement email;
	@FindBy (id="course")
	public WebElement course;
	@FindBy (id="password")
	public WebElement pass;
	@FindBy (id="submit")
	public WebElement submitbtn;
	@FindBy (id="Male")
	public WebElement male;
	@FindBy (id="Female")
	public WebElement female;
	@FindBy (tagName="select")
	public WebElement selecttag;
	@FindBy (id="mobile")
	public List<WebElement> mobile1;

}
