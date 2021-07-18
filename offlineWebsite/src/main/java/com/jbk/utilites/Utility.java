package com.jbk.utilites;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import jxl.Sheet;
import jxl.Workbook;

public class Utility {

	public static int WaitTime = 30;

	public static void clearText(WebElement ele) {
		ele.clear();
	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void EnterTextToSendkeys(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public static String getTextData(WebElement ele) {
		return ele.getText();

	}

	public static void waitBeforeCloseBrowser() throws Exception {
		Thread.sleep(WaitTime);
	}

	public ArrayList<String> readDataOdCol(String fileName, String sheetName, int colNo) throws Exception {
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for (int i = 1; i < row; i++) {
			expList.add(sh.getCell(colNo, i).getContents());
		}
		System.out.println(expList);
		return expList;
	}
}
