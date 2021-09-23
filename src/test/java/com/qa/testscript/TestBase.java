package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.BusPages;
import com.qa.pages.CabsPages;
import com.qa.pages.FlightPages;
import com.qa.pages.HotelsPages;
import com.qa.pages.TrainPages;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	WebDriver driver;
	CabsPages cabs;
	HotelsPages hotels;
	BusPages busPage;
	TrainPages trainPage;
	FlightPages flight;
	JavascriptExecutor js;
	public ExcelUtility XData;
	Actions action;
	String DatePattern;
	@Parameters({"webdriver","url"})
	@BeforeClass
	public void setUp(String webdriver,String url)
	{
		if(webdriver.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(webdriver.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();			
		}
		else if(webdriver.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		cabs = new CabsPages(driver);
		hotels = new HotelsPages(driver);
		busPage = new BusPages(driver);
		trainPage = new TrainPages(driver);
		flight = new FlightPages(driver);
		js = (JavascriptExecutor)driver;
		action = new Actions(driver);
		XData = new ExcelUtility();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String Target = System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Source, new File(Target));
		System.out.println("Screen Shot Captured");
	}

}
