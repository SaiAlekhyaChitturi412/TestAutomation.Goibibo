package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_TrainsModule_001 extends TestBase {

	@Test(priority = 1, dataProvider = "excelData")
	public void bookTrain(String fromLoc, String toLoc, String selectTrain, String name, String age, String address,
			String pincode, String mobileno, String emailId, String irctcId, String coach)
			throws InterruptedException, IOException {

		// Navigate to Train category
		trainPage.getTrainsCategory().click();
		if (driver.getTitle().contains("Book Train Tickets")) {
		Reporter.log("Navigated to Train category successfully.");
			Assert.assertTrue(true);
		} else {
			
			captureScreenShot(driver, "BookTrain");
			Assert.assertTrue(false);
		}

		// Search train
		trainPage.getFromTextbox().sendKeys(fromLoc);
		Thread.sleep(3000);
		clickElement(trainPage.getFromLocation());
		Thread.sleep(3000);

		trainPage.getToTextbox().sendKeys(toLoc);
		Thread.sleep(2000);
		clickElement(trainPage.getToLocation());
		Thread.sleep(3000);

		trainPage.getChooseTrainTextbox().sendKeys(selectTrain);
		Thread.sleep(1000);
		clickElement(trainPage.getChooseTrain());
		Thread.sleep(3000);

		clickElement(trainPage.getDate());
		Thread.sleep(3000);

		trainPage.getSearchTrainButton().click();
		Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("selected_train")) {
			Reporter.log("Searched the train successfully.");
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "BookTrain");
			Assert.assertTrue(false);
		}

		
		//Choose the first suggested train
		clickElement(trainPage.getChooseTrainOption());
		Thread.sleep(5000);

		if (driver.getCurrentUrl().contains("review")) {
			Reporter.log("Choosen the train successfully.");
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "BookTrain");
			Assert.assertTrue(false);
		}
		
        //Enter the required details
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		clickElement(trainPage.getGender());
		Thread.sleep(1000);

		/*
		 * clickElement(trainPage.getBerth()); Thread.sleep(1000);
		 * 
		 * clickElement(trainPage.getUpperBerth()); Thread.sleep(1000);
		 */

		trainPage.getName().sendKeys(name);
		Thread.sleep(1000);

		int index = age.indexOf(".");
		String Age = age.substring(0, index);
		trainPage.getAge().sendKeys(Age);
		Thread.sleep(1000);

		clickElement(trainPage.getSaveButton());
		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		trainPage.getAddress().sendKeys(address);
		Thread.sleep(1000);

		trainPage.getPincode().sendKeys(pincode);
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);

		int index1 = mobileno.indexOf(".");
		int index2 = mobileno.indexOf("E");
		String mobile = mobileno.substring(0, index1) + mobileno.substring(index1 + 1, index2 + 1);
		trainPage.getMobileNo().sendKeys(mobile);
		Thread.sleep(1000);

		trainPage.getEmailId().sendKeys(emailId);
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		trainPage.getIrctcId().sendKeys(irctcId);
		Thread.sleep(3000);

		clickElement(trainPage.getVerifyButton());
		Thread.sleep(5000);

		clickElement(trainPage.getReservationPreverence());
		Thread.sleep(5000);

		clickElement(trainPage.getBookOnlyifOption());
		Thread.sleep(1000);

		trainPage.getPreferredCoach().sendKeys(coach);
		Thread.sleep(1000);

		clickElement(trainPage.getAutoupgradationCheckbox());
		Thread.sleep(1000);

		clickElement(trainPage.getBerthAllocatedCheckBox());
		Thread.sleep(1000);

		clickElement(trainPage.getSecuremytripCheckbox());
		Thread.sleep(3000);

		clickElement(trainPage.getFreeCancellationOptoin());
		Thread.sleep(3000);

		//Proceed to payment
		clickElement(trainPage.getPayButton());
		Thread.sleep(3000);

		if (trainPage.getDepitcardOption().isDisplayed()) {
			Reporter.log("The payment page is displayed successfully.");
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "BookTrain");
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "excelData")
	public Object[][] data() throws IOException {
		Object[][] obj = XData.getData("TestData", "Sheet4");
		return obj;
	}

	public void clickElement(WebElement element) {
		action.moveToElement(element).click().build().perform();

	}
}