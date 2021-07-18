package com.jbk.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.repository.OperatorsPageRepository;
import com.jbk.utilites.ExcelUtils;

public class OperatorsPage extends OperatorsPageRepository {
	public Logger log=Logger.getLogger(OperatorsPage.class);
	WebDriver driver;

	public OperatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String fileName = "OperatorPageTable.xls";
	String sheetName = "operator";

	public boolean operatorsPageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Operators";
		if (actTitle.equals(expTitle)) {
			pageLogs().info("operatorsPageTitle is verified.");
			return true;
		} else {
			pageLogs().info("not matched.");
			return false;
		}
	}

	public boolean jbkTeachersNameSort() {

		List<String> personSet = new ArrayList<String>();

		for (WebElement person : persons) {
			personSet.add(person.getText());
		}

		Collections.sort(personSet);
		pageLogs().info("Sorted elements: " + personSet);

		return true;
	}

	public boolean jbkTeachersAssistance() {
		List<String> personList = new ArrayList<String>();
		List<String> roleList = new ArrayList<String>();
		for (int i = 0; i < persons.size(); i++) {
			String person = persons.get(i).getText();
			String rol = roles.get(i).getText();
			personList.add(person);
			roleList.add(rol);
		}
		for (int i = 0; i < persons.size(); i++) {
			if (roleList.get(i).contains("Technical")) {
				pageLogs().info("person " + personList.get(i) + " Available for " + roleList.get(i));
			}
		}
		// String uname = usernames.get(i).getText();
		//
		// String gender = genders.get(i).getText();
		//
		//
		// List<String> al= new ArrayList<String>();
		//
		// al.add(uname);
		//
		// al.add(gender);
		//
		// Map<List<WebElement>, List<WebElement>> webElementMap = new
		// HashMap<List<WebElement>, List<WebElement>>();
		// webElementMap.put(persons, roles);
		//
		// Map<String, String> map = new HashMap<String, String>();
		//
		// String name = "";
		// String role = "";
		//
		// for (Map.Entry<List<WebElement>, List<WebElement>> listMap :
		// webElementMap.entrySet()) {
		// for (int i = 0; i < listMap.getKey().size(); i++) {
		// name = listMap.getKey().get(i).getText();
		// role = listMap.getValue().get(i).getText();
		// map.put(name, role);
		// }
		// }
		//
		// for (Map.Entry<String, String> data : map.entrySet()) {
		//
		// if (data.getValue().contains("Technical")) {
		// System.out.println("Name: " + data.getKey()+" " + " Role: " +
		// data.getValue());
		// }
		//
		// }

		return true;
	}

	public boolean jbkPersonsUsesPreferedWayToConnect() {
		List<String>actPerWithMediaWhatsAppOnly= new ArrayList<String>();
		List<String>expPerWithMediaWhatsAppOnly=new ArrayList<String>();
		for (int i = 0; i < persons.size(); i++) {
			String person = persons.get(i).getText();
			String connectionMedia = media.get(i).getText();
			if (connectionMedia.contains("Whats App Only"))
				actPerWithMediaWhatsAppOnly.add(person);
		}
		for(int i=1;i<6;i++) {
			String excelper=ExcelUtils.getCellData(i, 1, fileName, sheetName);
			String excelMedia=ExcelUtils.getCellData(i, 3, fileName, sheetName);
			if(excelMedia.contains("Whats App Only")) {
				expPerWithMediaWhatsAppOnly.add(excelper);
			}
		}
		if(actPerWithMediaWhatsAppOnly.equals(expPerWithMediaWhatsAppOnly)) {
			log.info("verified persons  uses whats App only");
			return true;
		}else {
			pageLogs().info("something wrong."); 
			return false;
		}

	
	}

	public boolean verifyHeaderOfTable() {

		List<String> actheader = new ArrayList<String>();
		for (WebElement header : headers) {
			String head = header.getText();
			actheader.add(head);
		}
		List<String> expHeader = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			String exHead = ExcelUtils.getCellData(0, i, fileName, sheetName);
			expHeader.add(exHead);
		}
		if (actheader.equals(expHeader)) {
			pageLogs().info("Table header is verified.");
			return true;
		} else {
			pageLogs().info("Table header is  not verified.");
			return false;
		}
	}

	public boolean verifyIdWithexTableId() {
		List<String> actId = new ArrayList<String>();
		String id;
		for (WebElement num : srno) {
			id = num.getText();
			actId.add(id);
		}
		List<String> expId = new ArrayList<String>();
		for (int i = 1; i <= srno.size(); i++) {
			String excelId = ExcelUtils.getCellData(i, 0, fileName, sheetName);
			expId.add("0" + excelId);
		}
		if (actId.equals(expId)) {
			pageLogs().info("OperatorTableId is verified.");
			return true;
		} else {
			pageLogs().info("not verifued.");
			return false;
		}
	}

	public boolean verifyPersonWithEnquiryRole() {
		List<String> actPersonWithEnq = new ArrayList<String>();
		List<String> expPersonWithEnq = new ArrayList<String>();
		for (int i = 0; i < persons.size(); i++) {
			String person = persons.get(i).getText();
			String role = roles.get(i).getText();
			if (role.contains("Enquiry")) {
				actPersonWithEnq.add(person);
			}
		}

		for (int i = 1; i < 6; i++) {
			String excelrole = ExcelUtils.getCellData(i, 2, fileName, sheetName);
			String excelPerson = ExcelUtils.getCellData(i, 1, fileName, sheetName);
			if (excelrole.contains("Enquiry")) {
				expPersonWithEnq.add(excelPerson);
			}
		}
		if(actPersonWithEnq.equals(expPersonWithEnq)) {
			pageLogs().info("Person with Enquiry Role is verified.");
				return true;
			}else {
				log.info("not verified.");
				return false;
			}
		}
	public boolean verifyUserAvailableOnAlldays() {
		List<String> actData=new ArrayList<String>();
		List<String> expectedData=new ArrayList<String>();
		for(int i=0;i<persons.size();i++) {
			String person=persons.get(i).getText();
			String weekdays=timingCol.get(i).getText();
			if(weekdays.contains("Monday-Sunday")||weekdays.contains("Saturday-Sunday")) {
				actData.add(person);
			}
		}
		System.out.println("Person available for weekdays and sat sunday"+actData);
		for(int i=1;i<6;i++) {
			String timing=ExcelUtils.getCellData(i, 5, fileName, sheetName);
			String perName=ExcelUtils.getCellData(i, 1, fileName, sheetName);
			if(timing.contains("Monday-Sunday")|| timing.contains("Saturday-Sunday")) {
				expectedData.add(perName);
			}
		}
		System.out.println("Expected persom available for weekdays and sat-sun"+expectedData);
		if(actData.equals(expectedData)) {
			log.info("Data is verified");
			return true;
		}else {
			log.info("not verified.");
			return false;
		}
		
	}
	public boolean verifyUserWithAndTimingContact() {
		HashMap<String, List<String>> actHm =new HashMap<String, List<String>>();
		
		for(int i=0;i<persons.size();i++) {
			String key=persons.get(i).getText();
			String contactNo=contacts.get(i).getText();
			String time=timingCol.get(i).getText();
			List<String> value=new ArrayList<String>();
			value.add(contactNo);
			value.add(time);
			actHm.put(key, value);
		}
		log.info("The Actual HashMap With Name,Contact,Time for available\n"+actHm);
		HashMap<String, List<String>> expHm=new HashMap<String, List<String>>();
		for(int i=1;i<6;i++) {
			String key1=ExcelUtils.getCellData(i, 1, fileName, sheetName);
			String ucontact=ExcelUtils.getCellData(i, 4, fileName, sheetName);
			String utime=ExcelUtils.getCellData(i, 5, fileName, sheetName);
			List<String > value1=new ArrayList<String>();
			value1.add(ucontact);
			value1.add(utime);
			expHm.put(key1, value1);
		}
		log.info("The Expected HashMap With Name,Contact,Time for available\n"+expHm);
		if(actHm.equals(expHm)) {
			log.info("Data is verified.");
			return true;
		}else {
			log.info("Data is not verified.");
			return false;
		}
	}
}
