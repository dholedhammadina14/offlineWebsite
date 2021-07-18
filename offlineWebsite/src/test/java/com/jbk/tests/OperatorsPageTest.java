package com.jbk.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jbk.pages.DashboardPage;
import com.jbk.pages.OperatorsPage;

public class OperatorsPageTest extends TestBase {
	WebDriver driver = null;
	public OperatorsPage op = null;
	public DashboardPage dp = null;

	@BeforeClass
	public void setUp() {
		driver=initialization();
		op=loadLoginPage(driver).navigateToDashboardPage(driver).navigateToOperatorPage(driver);
		//op = new OperatorsPage(driver);
	}

	@Test
	public void verifyTitle() {

		Assert.assertTrue(op.operatorsPageTitle());
	}

	@Test
	public void verifyIsPersonNameIsSorted() {
		Assert.assertTrue(op.jbkTeachersNameSort());
	}

	@Test
	public void verifyContainsString() {
		Assert.assertTrue(op.jbkTeachersAssistance());
	}
	@Test
	public void verifypersonWithWhatsappOnly() {
		Assert.assertTrue(op.jbkPersonsUsesPreferedWayToConnect());
	}
	@Test
	public void verifyHeaderOfTable() {
		Assert.assertTrue(op.verifyHeaderOfTable());
	}
	@Test
	public void verifytableId() {
		Assert.assertTrue(op.verifyIdWithexTableId());
	}
	@Test
	public void verifyPersonEnquiry() {
		Assert.assertTrue(op.verifyPersonWithEnquiryRole());
	}
	@Test
	public void verifyAllDayAvailablePerson() {
		Assert.assertTrue(op.verifyUserAvailableOnAlldays());
	}
	@Test
	public void verifyPersonWithContactAndTime() {
		Assert.assertTrue(op.verifyUserWithAndTimingContact());
	}

}
