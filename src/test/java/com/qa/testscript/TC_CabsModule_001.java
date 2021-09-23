package com.qa.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_CabsModule_001 extends TestBase
{
	@Test(dataProvider="excelData")
	public void cabsTesting(String From,String To,String Location,String FirstName,String phonenumber1,String email) throws InterruptedException, IOException
	{
		//moves to cab page
		cabs.getCab().click();
		Thread.sleep(4000);
		String title = driver.getCurrentUrl();
		if(title.contains("cars"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"cabsTesting");
			Reporter.log("User is not landed on Cabs pages");
			Assert.assertFalse(true);
		}
		//RadioButton
		cabs.getRadiobutton1().click();
		Thread.sleep(4000);
		//From
		cabs.getFrom().sendKeys(From);
		Thread.sleep(4000);
		cabs.getHyderabad().click();
		Thread.sleep(4000);
		//To
		cabs.getTo().sendKeys(To);
		Thread.sleep(4000);
		cabs.getBanglore().click();
		Thread.sleep(4000);
		//Date
		cabs.getPickupdateclicking().click();
		Thread.sleep(4000);
		cabs.getPickupdate().click();
		Thread.sleep(4000);
		//search Cabs
		cabs.getSearchcabs().click();
		Thread.sleep(4000);
		String secondtitle = driver.getCurrentUrl();
		if(secondtitle.contains("review"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"cabsTesting");
			Reporter.log("User is not landed on Results Page");
			Assert.assertFalse(true);
			
		}
		js.executeScript("window.scrollBy(0,350)", "");	
		//Filters
		cabs.getFilter().click();
		Thread.sleep(4000);
		if(cabs.getFilter().isEnabled())
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"cabsTesting");
			Reporter.log("Filter is not selected");
			Assert.assertFalse(true);
			
		}
		//Select the car from the suggested list
		cabs.getSelectcar().click();
		Thread.sleep(4000);		
		js.executeScript("window.scrollBy(0,1000)", "");	
		Thread.sleep(300);
		//location
		cabs.getLocation().sendKeys(Location);
		Thread.sleep(300);
		cabs.getLocationlist().click();
		Thread.sleep(300);
		//FirstName
		cabs.getFirstname().sendKeys(FirstName);
		Thread.sleep(300);
		//Mobile Number
		int index1 = phonenumber1.indexOf(".");
		int index2 = phonenumber1.indexOf("E");
		phonenumber1 = phonenumber1.substring(0,index1)+phonenumber1.substring(index1+1,index2);
		cabs.getMobilenumber().sendKeys(phonenumber1);
		Thread.sleep(300);
		//Email
		cabs.getEmail().sendKeys(email);
		Thread.sleep(300);
		//Payment
		cabs.getPay().click();
		Thread.sleep(300);
		Thread.sleep(4000);

	}
	@DataProvider(name="excelData")
	public Object[][] data() throws IOException
	{
		Object[][] obj = XData.getData("TestData","Sheet2");
		return obj;
	}

}
