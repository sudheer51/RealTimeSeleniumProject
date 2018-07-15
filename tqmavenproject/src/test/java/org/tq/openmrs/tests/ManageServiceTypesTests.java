package org.tq.openmrs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tq.openmrs.pages.HomePage;
import org.tq.openmrs.pages.LoginPage;
import org.tq.openmrs.pages.ManageServiceTypesPage;
import org.tq.util.AppLibrary;
import org.tq.util.TestBaseClass;

public class ManageServiceTypesTests extends TestBaseClass{

	@Parameters({"username","password"})
	@BeforeMethod
	public void login(String username,String password)
	{
		driver.get(url);
		LoginPage lPage = new LoginPage(driver);
		System.out.println("username" + username);
		System.out.println("password" + password);
		String actual = lPage.login(username,password);
		Assert.assertTrue(actual.contains("Logged"));
	}
	@Test
	public void verifyAddServiceType()
	{
		String svcName = AppLibrary.randomString();
		HomePage hPage = new HomePage(driver);
		hPage.navigatetoManageSvcTypes();
		ManageServiceTypesPage m1 = new ManageServiceTypesPage(driver);
		System.out.println("Adding the Svc Name:::"+ svcName);
		m1.addServiceType(svcName);
		m1.deleteServiceType(svcName);
		boolean result = m1.verifyServiceType(svcName);
		Assert.assertFalse(result);
		
	}
	@AfterMethod
	public void logoutApp()
	{
		HomePage hPage = new HomePage(driver);
		hPage.logoutApp();
	}
}
