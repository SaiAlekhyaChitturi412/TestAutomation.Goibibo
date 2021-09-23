package com.qa.testscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_BusModule_001 extends TestBase{

	@Test(dataProvider = "excelData")
	public void BusModule(String From,String To,String TravelDate,String BoardPointFilter,String DropPointFilter,String BoardPoint,String DropPoint,String Gender,String Name,String Age,String Email,String Mobile) throws IOException, InterruptedException {
		
		//Navigate to Bus module
		busPage.getBusLink().click();
		boolean contain= driver.getTitle().contains("Bus");
		if(contain) {
			Assert.assertTrue(true);
		}else {
			captureScreenShot(driver, "BusModule");
			Assert.assertTrue(false);
		}
		
		//Enter details to search Bus
		Thread.sleep(2000);
		busPage.getFromField().click();
		busPage.getFromField().sendKeys(From);
		Thread.sleep(2000);
		busPage.getSelectFrom().click();
		
		busPage.getToField().click();
		busPage.getToField().sendKeys(To);
		Thread.sleep(2000);
		busPage.getSelectTo().click();
		
		//Select Travel Date from Date Picker
		busPage.getTravelDateFiled().click();
		Thread.sleep(1000);
		String[] travelDate=TravelDate.split("-");
		String date=travelDate[0]; 
		String month=travelDate[1];
		String year=travelDate[2];
		
		//Select Given Month and Year
		while(true) {
			if(busPage.getTravelMonthYear().getText().startsWith(month) &&
					busPage.getTravelMonthYear().getText().endsWith(year) ) {
				break;
			}else {
				busPage.getRightArrow().click();
			}
		}
		
		//Select Given Date
		List<WebElement> dateList= busPage.getDateList();
		int dateListSize= dateList.size();
		int i = 0;
		boolean cont=true;
		while(i<dateListSize && cont) {
			if(dateList.get(i).getText().equals(date)) {
				dateList.get(i).click();
				cont=false;
			}i++;
		}
		Thread.sleep(2000);
		busPage.getSearchBusButton().click();
		
		boolean valid= driver.getCurrentUrl().contains(From+"-"+To);
		if(valid) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "BusModule");
			Assert.assertTrue(false);
		}
		
		
		//Add filters to search
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		busPage.getGoSafeFilter().click();
		busPage.getLiveTrackFilter().click();
		
		busPage.getAcFilter().click();
		busPage.getSleeperFilter().click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		busPage.getDepartTimeFilter().click();
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		busPage.getArrivalTimeFilter().click();
		
		js.executeScript("window.scrollBy(0,700)");
		busPage.getBoardingFilterSearch().sendKeys(BoardPointFilter);
		Thread.sleep(1000);
		busPage.getBoardingFilterCheckBox().click();
		
		js.executeScript("window.scrollBy(0,700)");
		busPage.getDroppingFilterSearch().sendKeys(DropPointFilter);
		Thread.sleep(1000);
		busPage.getDroppingFilterCheckBox().click();
		Thread.sleep(3000);
		
		boolean noBus = busPage.getNoBusFound().getText().contains("No bus found");
		if(noBus) {
			captureScreenShot(driver, "BusModule");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
		
		//Select Board point
		busPage.getSelectSeatButton().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> boardList= busPage.getBoardPointList();
		action.moveToElement(busPage.getBoardPoint());
		for(int j=0;j<boardList.size();j++) {
			if(boardList.get(j).getText().contains(BoardPoint)) {
				js.executeScript("arguments[0].scrollIntoView()",boardList.get(j));
				js.executeScript("arguments[0].click()", boardList.get(j).findElement(By.tagName("label")));
			}
		}
		Thread.sleep(1000);
		
		//Select Drop point
		action.moveToElement(busPage.getDropPoint());
		List<WebElement> dropList= busPage.getDropPointList();
		for(int j=0;j<dropList.size();j++) {
			if(dropList.get(j).getText().contains(DropPoint)) {
				js.executeScript("arguments[0].scrollIntoView()",dropList.get(j));
				js.executeScript("arguments[0].click()", dropList.get(j).findElement(By.tagName("label")));
			}
		}
		Thread.sleep(1000);
		
		//Select Available seat
		List<WebElement> availableSeatList=busPage.getAvailableSeatList();
		availableSeatList.get(0).click();
		Thread.sleep(3000);
		busPage.getContinueButton().click();
		
		boolean booked= busPage.getReviewBookingText().isDisplayed();
		if(booked) {
			Assert.assertTrue(true);
		}else {
			captureScreenShot(driver, "BusModule");
			Assert.assertTrue(false);
		}
		
		//Review Details 
		js.executeScript("arguments[0].scrollIntoView()",busPage.getTripInsurance());
		busPage.getNoInsurance().click();
		js.executeScript("arguments[0].scrollIntoView()",busPage.getTravellerDetails());
		
		//Enter passenger details
		busPage.getGender().selectByValue(Gender);
		busPage.getFullNameField().sendKeys(Name);
		busPage.getAgeField().sendKeys(Age);
		busPage.getEmailField().sendKeys(Email);
		String mobileNum= Mobile.substring(0, Mobile.indexOf("."))+ Mobile.substring((Mobile.indexOf("."))+1);
		busPage.getMobileField().sendKeys(mobileNum);
		Thread.sleep(2000);
		busPage.getPayButton().click();
		
		boolean payText= busPage.getPaymentText().isDisplayed();
		if(payText) {
			Assert.assertTrue(true);
		}else {
		captureScreenShot(driver, "BusModule");
			Assert.assertTrue(false);
		}
		
	}
	
	@DataProvider(name="excelData")
	public Object[][] data() throws IOException
	{
		Object[][] obj = XData.getData("TestData","Sheet5");
		return obj;
	}
	
}
