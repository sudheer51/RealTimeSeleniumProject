package org.tq.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigatetoManageSvcTypes()
	{
		//Clicks on Appointment Scheduling
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		//Manage Service Types
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
		
	}
	public void logoutApp()
	{
		driver.findElement(By.xpath("html/body/header/ul/li[3]/a")).click();
	}

}
