package com.jbk.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jbk.repository.AddUserRepository;
import com.jbk.utilites.ExcelUtils;
import com.jbk.utilites.Utility;

public class AddUserPage extends AddUserRepository {
	public Logger log = Logger.getLogger(AddUserPage.class);
	WebDriver driver = null;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddUserTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Add User";
		if (actTitle.equals(expTitle)) {
			pageLogs().info("AddUserTitle is verified.");
			return true;
		} else {
			pageLogs().info(" Title is not verified.");
			return false;
		}
	}

	public boolean verifyAddUser() {
		String fileName = "addUserSheet.xls";
		String sheetName = "add";
		String msg = null;
		String expMsg = null;
		for (int i = 1; i < 5; i++) {
			Utility.EnterTextToSendkeys(uname, ExcelUtils.getCellData(i, 0, fileName, sheetName));
			Utility.EnterTextToSendkeys(mobile, ExcelUtils.getCellData(i, 1, fileName, sheetName));
			Utility.EnterTextToSendkeys(email, ExcelUtils.getCellData(i, 2, fileName, sheetName));
			Utility.EnterTextToSendkeys(course, ExcelUtils.getCellData(i, 3, fileName, sheetName));
			// uname.sendKeys(ExcelUtils.getCellData(i, 0, fileName, sheetName));
			// mobile.sendKeys(ExcelUtils.getCellData(i, 1, fileName, sheetName));
			// email.sendKeys(ExcelUtils.getCellData(i, 2, fileName, sheetName));
			// course.sendKeys(ExcelUtils.getCellData(i, 3, fileName, sheetName));

			if (ExcelUtils.getCellData(i, 4, fileName, sheetName).equals("Male"))
				Utility.click(male);
			else
				Utility.click(female);

			Select sel = new Select(selecttag);
			sel.selectByVisibleText(ExcelUtils.getCellData(i, 5, fileName, sheetName));

			Utility.EnterTextToSendkeys(pass, ExcelUtils.getCellData(i, 6, fileName, sheetName));

			Utility.click(submitbtn);

			Alert al = driver.switchTo().alert();
			msg = al.getText();

			al.accept();
			expMsg = "User Added Successfully. You can not see added user.";

		}
		if (msg.equals(expMsg)) {
			pageLogs().info("User Added Successfully.");
			return true;
		} else {
			pageLogs().info("User not added.");
			return false;
		}
	}

}
