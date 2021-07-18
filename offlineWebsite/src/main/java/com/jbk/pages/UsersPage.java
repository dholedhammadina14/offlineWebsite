package com.jbk.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.jbk.utilites.Utility;
import com.jbk.utilites.ExcelUtils;

import com.jbk.repository.UserPageRepository;

public class UsersPage extends UserPageRepository {
	public Logger log=Logger.getLogger(UsersPage.class);
	WebDriver driver = null;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean usersPageTitle() {
		String actTitle = driver.getTitle();
		String exptTitle = "JavaByKiran | User";
		if (actTitle.equals(exptTitle)) {
			pageLogs().info("UsersPageTitle is verified.");
			return true;
		} else {
			pageLogs().info("UsersPageTitle is not matched.");
			return false;
		}
	}

	public boolean verifyExcelDataWithWebdata() {
		String fileName = "UserTable.xls";
		String sheetName = "user";
		HashMap<Integer, List<String>> exphm = new HashMap<Integer, List<String>>();
		HashMap<Integer, List<String>> acthm = new HashMap<Integer, List<String>>();

		for (int i = 0; i < usernames.size(); i++) {
			String uname=Utility.getTextData(usernames.get(i));
			String gender = Utility.getTextData(genders.get(i));
			List<String> al = new ArrayList<String>();
			al.add(uname);
			al.add(gender);

			acthm.put(i, al);

		}

		pageLogs().info("---->>>" + acthm);
		for (int j = 1; j <= 4; j++) {
			String uname = ExcelUtils.getCellData(j, 1, fileName, sheetName);
			String gender =ExcelUtils.getCellData(j, 5, fileName, sheetName);
			List<String> al = new ArrayList<String>();
			al.add(uname);
			al.add(gender);
			exphm.put(j - 1, al);
		}
		if (acthm.equals(exphm)) {
			pageLogs().info("data is matched.");
			return true;
		} else {
			pageLogs().info("not matched.");
			return false;
		}

	}

	public boolean verifyWebTableWithExcelTable() {
		String fileName = "UserTable.xls";
		String sheetName = "user";
		HashMap<String, List<String>> actTable = new HashMap<String, List<String>>();
		HashMap<String, List<String>> expTable = new HashMap<String, List<String>>();
		List<String> value = new ArrayList<String>();
		String key = null;
		for (WebElement ele : headers) {
			if (headers.indexOf(ele) == 0) {
				key = Utility.getTextData(ele);
			} else {
				value.add(Utility.getTextData(ele));
			}
		}
		actTable.put(key, value);
		key = null;
		value = null;
		int rows = driver.findElements(By.tagName("tr")).size();
		for (int i = 2; i < rows + 1; i++) {
			List<WebElement> rowData = driver.findElements(By.xpath("//tr[" + i + "]/td"));
			value = new ArrayList<String>();
			for (WebElement data : rowData) {
				if (rowData.indexOf(data) == 0) {
					key = Utility.getTextData(data);
				} else {
					value.add(Utility.getTextData(data));
				}

			}
			actTable.put(key, value);
		}
		pageLogs().info(actTable);
		String expKey = null;
		for (int i = 0; i < 5; i++) {

			ArrayList<String> expAl = new ArrayList<String>();
			expKey = ExcelUtils.getCellData(i, 0, fileName, sheetName);
			for (int j = 1; j < 8; j++) {
				expAl.add(ExcelUtils.getCellData(i, j, fileName, sheetName));
			}
			expTable.put(expKey, expAl);
		}
		pageLogs().info(expTable);

		if (actTable.equals(expTable)) {
			pageLogs().info("Both tables are matched with eaach other.");
			return true;
		} else {
			pageLogs().info("not matched.");
			return false;
		}
	}

	public boolean verifyEmailcode() {
		boolean flag = false;
		ArrayList<Boolean> al = new ArrayList<Boolean>();
		for (WebElement element : emails) {
			String perEmail = Utility.getTextData(element);
			pageLogs().info(perEmail);
			if (perEmail.contains("gmail.com"))
				return true;
			else
				return false;

		}
		return flag;
	}

	public List<Boolean> mobileLength() {
		boolean flag = false;
		ArrayList<Boolean> al = new ArrayList<Boolean>();
		for (WebElement mob : mobiles) {
			String text =Utility.getTextData(mob);
			if (text.length() == 10) {
				pageLogs().info("correct mobile number is :" + text);
				al.add(!flag);
			} else {
				pageLogs().info("Incorrect mobile number is :" + text);
				al.add(flag);
			}
		}
		return al;
	}

	public AddUserPage clickAddUser() {
		adduserbutton.click();
		return new AddUserPage(driver);
	}

}
