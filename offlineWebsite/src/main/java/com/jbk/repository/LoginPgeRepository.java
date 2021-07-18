package com.jbk.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.utilites.PageBase;

public  class LoginPgeRepository extends PageBase {
	@FindBy (id="email")
	public WebElement uname;
	@FindBy (id="password")
	public WebElement password;
	@FindBy (xpath="//button")
	public WebElement btnLogin;
	@FindBy  (xpath="//img[contains(@src,'jbk')]")
	public WebElement image;
	@FindBy (partialLinkText="Register")
	public WebElement regLink;
	@FindBy (xpath="//b")
	public WebElement  heading;
	@FindBy (xpath="//h4")
	public WebElement heading1;
	@FindBy (xpath="//p")
	public WebElement text;
}
