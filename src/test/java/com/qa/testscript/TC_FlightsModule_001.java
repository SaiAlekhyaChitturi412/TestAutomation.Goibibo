package com.qa.testscript;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_FlightsModule_001 extends TestBase {

	String DatePattern;
	// choose destination_place and arrival_place as mumbai and dehli.

	@Test(dataProvider = "excelData")
	public void searchFlight(String departLoc, String arrivalLoc, String travelClass, String passenger, String nameTitle, String name, String lastName, String Email, String mobile)
			throws IOException, InterruptedException {
		
		String url = driver.getCurrentUrl();
		if(url.contains("goibibo")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

		flight.getDepartLocation().sendKeys(departLoc);
		Thread.sleep(2000);
		flight.getAutoSuggest1().click();

		flight.getArrivalLocation().sendKeys(arrivalLoc);
		Thread.sleep(2000);
		flight.getAutoSuggest2().click();

		Thread.sleep(3000);

		flight.getDepartCalendar().click();
		flight.getdDate().click();		
		Thread.sleep(3000);
		
		flight.getReturnCalendar().click();
		flight.getrDate().click();		
		Thread.sleep(3000);

		flight.getPassengerAndTravelClass().click();

		int totalPassenger = (int) Double.parseDouble(passenger);
		for (int i = 1; i < totalPassenger; i++) {
			flight.getAdult().click();
		}
		Thread.sleep(5000);

		flight.getTravelClass().selectByValue(travelClass);
		flight.getCloseTravelClass().click();
		Thread.sleep(5000);

		// click on update search.

		flight.getFindFlights().click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		
		if(title.contains("Flight")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
		
		
		Boolean fPrefence = flight.isFlightPreferenceVisible().isDisplayed();
		if(fPrefence) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
		flight.getFlightPreference().click();
		Thread.sleep(3000);

		List<WebElement> lists = flight.getAllFlights();
		for (int i = 0; i < lists.size(); i++) {
			js.executeScript("window.scrollBy(0,60)", lists.get(0));
			Thread.sleep(2000);
			Reporter.log(lists.get(0).getText());
		}

		Thread.sleep(3000);
		File paymentMethods = flight.getPaymentMethods().getScreenshotAs(OutputType.FILE);
		DatePattern = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "/Screenshots/" + "PaymentMethods" + DatePattern + ".png";
		FileUtils.copyFile(paymentMethods, new File(destination));
		
		js.executeScript("window.scrollTo(0,0)");
		
		flight.getBookFlight().click();
		Thread.sleep(2000);
		String bookingFlight = driver.getCurrentUrl();
		Assert.assertEquals(bookingFlight, bookingFlight);
		
		
		flight.getNameTitle().selectByVisibleText(nameTitle);
		flight.getName().sendKeys(name);
		flight.getLastName().sendKeys(lastName);
		flight.getEmail().sendKeys(Email);
		String num1 = (mobile.substring(0, mobile.indexOf(".")));
		String num2 = (mobile.substring(2, mobile.indexOf("E")));
		flight.getMobileNo().sendKeys((num1+num2));
		Thread.sleep(3000);
		flight.getProceedBtn().click();
		Thread.sleep(3000);
		Boolean paymentMethod = flight.getProceedToPayment().isDisplayed();
		if(paymentMethod) {
			Assert.assertTrue(true);
		}
		else {
			Thread.sleep(3000);
			captureScreenShot(driver, "searchFlight");
			Thread.sleep(3000);
			Assert.assertFalse(false);
		}		
	}
	@DataProvider(name="excelData")
	public Object[][] data() throws IOException
	{
		Object[][] obj = XData.getData("TestData","Sheet3");
		return obj;
	}
}
