package org.tq.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBaseClass {

	protected WebDriver driver;
	protected String url;
	@Parameters({"browserType","url"})
	@BeforeTest
	public void getDriverInstance(String browserType,String url)
	{
		if(browserType.equals("IE"))
		{
			//zoom should be set to 100%
			//Enable protected mode should be selected for all the four secutiry zones..
			System.out.println("Executing IE");
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserType.equals("FF"))
		{
			System.out.println("Executing FF");
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("Exeucting CH");
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			 
		}
		this.url=url;
	}
}
