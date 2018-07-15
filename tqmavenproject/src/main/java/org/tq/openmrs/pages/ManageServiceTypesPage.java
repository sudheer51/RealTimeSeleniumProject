package org.tq.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServiceTypesPage {

	WebDriver driver;
	public ManageServiceTypesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyServiceType(String svcName)
	{
		boolean result = false;
		List<WebElement> pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		outer:
			for(int i = 0 ;i<pagesList.size();i++)
			{
				for(int j=0;j<trList.size();j++)
				{
					if(trList.get(j).getText().contains(svcName))
					{
						System.out.println("svcName Found");
						result = true;
						break outer; 
					}
				}
				pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
				pagesList.get(i+1).click();
				trList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			}

		return result;
	}
	public void addServiceType(String svcName)
	{
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/button")).click();
		driver.findElement(By.id("name-field")).clear();
		driver.findElement(By.id("name-field")).sendKeys(svcName);
		driver.findElement(By.id("duration-field")).sendKeys("123");
		driver.findElement(By.id("save-button")).click();

	}
	public void deleteServiceType(String svcName)
	{
		List<WebElement> pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		for(int i = 0 ;i<pagesList.size();i++)
		{
			try{
				String dynamicXpath = ".//*[@id='appointmentschedulingui-delete-"+svcName+"']";
				driver.findElement(By.xpath(dynamicXpath)).click();
				System.out.println("Service Name Found!!!");
				 	 
				break;
			}
			catch(Exception e)
			{
				System.out.println("Service Name Not Found" + e.getMessage());
				pagesList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
				pagesList.get(i+1).click();
			}
		}
		////Clicking on Yes button
	//	driver.findElement(By.xpath(".//*[@id='delete-appointment-type-dialog']/div[2]/button[1]")).click();

       driver.findElement(By.xpath("//div[@id='simplemodal-container']/div/div/div[2]/button[1]")).click();
		

	}
}
