package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BusPages {
	
	WebDriver driver;
	
	@FindBy(linkText="Bus")
	WebElement BusLink;
	
	public WebElement getBusLink() {
		return BusLink;
	}
	
	@FindBy(id="autosuggestBusSRPSrcHome")
	WebElement FromField;
	
	public WebElement getFromField() {
		return FromField;
	}
	
	@FindBy(id="downshift-1-item-0")
	WebElement SelectFrom;
	
	public WebElement getSelectFrom() {
		return SelectFrom;
	}
	
	@FindBy(id="autosuggestBusSRPDestHome")
	WebElement ToField;
	
	public WebElement getToField() {
		return ToField;
	}
	
	@FindBy(id="downshift-2-item-0")
	WebElement SelectTo;
	
	public WebElement getSelectTo() {
		return SelectTo;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/input")
	WebElement TravelDateField;
	
	public WebElement getTravelDateFiled() {
		return TravelDateField;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/div[1]/div/div/div[1]/div/p")
	WebElement TravelMonthYear;
	
	public WebElement getTravelMonthYear() {
		return TravelMonthYear;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/div[1]/div/div/div[1]/div/div[2]/div")
	WebElement RightArrow;
	
	public WebElement getRightArrow() {
		return RightArrow;
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[3]/div/div[1]/div/div/div[2]/div/div/ul[2]")
	WebElement DateList;
	
	public List<WebElement> getDateList() {
		return DateList.findElements(By.tagName("li"));
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/section/section/section[1]/section/div[5]/button")
	WebElement SearchBusButton;
	
	public WebElement getSearchBusButton() {
		return SearchBusButton;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/label/span[3]")
	WebElement GoSafeFilter;
	
	public WebElement getGoSafeFilter() {
		return GoSafeFilter;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[2]/div[2]/div[4]/div/label/span[3]")
	WebElement LiveTrackFilter;
	
	public WebElement getLiveTrackFilter() {
		return LiveTrackFilter;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[3]/div[2]/div[1]")
	WebElement AcFilter;
	
	public WebElement getAcFilter() {
		return AcFilter;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[3]/div[2]/div[4]")
	WebElement SleeperFilter;
	
	public WebElement getSleeperFilter() {
		return SleeperFilter;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[4]/div[2]/div[4]")
	WebElement DepartTimeFilter;
	
	public WebElement getDepartTimeFilter() {
		return DepartTimeFilter;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[5]/div[2]/div[2]")
	WebElement ArrivalTimeFilter;
	
	public WebElement getArrivalTimeFilter() {
		return ArrivalTimeFilter;
	}
	
	@FindBy(id="boardingPointFilterSearch")
	WebElement BoardingFilterSearch;
	
	public WebElement getBoardingFilterSearch() {
		return BoardingFilterSearch;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[6]/div[4]/div/div/label/span[2]")
	WebElement BoardingFilterCheckBox;
	
	public WebElement getBoardingFilterCheckBox() {
		return BoardingFilterCheckBox;
	}
	
	@FindBy(id="droppingPointFilterSearch")
	WebElement DroppingFilterSearch;
	
	public WebElement getDroppingFilterSearch() {
		return DroppingFilterSearch;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayout\"]/section/div/div[2]/div[1]/div/div[7]/div[4]/div[1]/div/label/span[2]")
	WebElement DroppingFilterCheckBox;
	
	public WebElement getDroppingFilterCheckBox() {
		return DroppingFilterCheckBox;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayoutinner\"]/div[3]")
	WebElement NoBusFound;
	
	public WebElement getNoBusFound() {
		return NoBusFound;
	}
	
	@FindBy(xpath="//*[@id=\"srpCardLayoutinner\"]/div[3]/div[1]/div[1]/div[4]/div/div[2]/div/div")
	WebElement SelectSeatButton;
	
	public WebElement getSelectSeatButton() {
		return SelectSeatButton;
	}
	
	@FindBy(xpath="/html/body/div[1]/section/section/section/div/div[2]/div[2]/div[3]/div[1]/section/div[2]/div/section[2]/section/div[2]/div[3]/aside[2]/div/div[13]/div")
	WebElement SelectSeat;
	
	public WebElement getSelectSeat() {
		return SelectSeat;
	}
	
	@FindBy(xpath="/html/body/div[1]/section/section/section/div/div[2]/div[2]/div[3]/div[1]/section/div[2]/div/section[1]/div/div[2]/div[1]/div")
	WebElement BoardPoint;
	
	public WebElement getBoardPoint() {
		return BoardPoint;
	}
	
	public List<WebElement> getBoardPointList() {
		return BoardPoint.findElements(By.tagName("label"));
	}
	
	@FindBy(xpath="/html/body/div[1]/section/section/section/div/div[2]/div[2]/div[3]/div[1]/section/div[2]/div/section[1]/div/div[2]/div[2]/div")
	WebElement DropPoint;
	
	public WebElement getDropPoint() {
		return DropPoint;
	}
	
	public List<WebElement> getDropPointList() {
		return DropPoint.findElements(By.tagName("label"));
	}
	
	@FindBy(xpath="/html/body/div[1]/section/section/section/div/div[2]/div[2]/div[3]/div[1]/section/div[2]/div/section[2]/section/div[2]/div[3]/aside[2]/div")
	WebElement AvailableSeat;
	
	public List<WebElement> getAvailableSeatList(){
		return AvailableSeat.findElements(By.xpath("//*[local-name()='svg' and @class='BusSleeperIcon-sc-ha5qpg-0 cdzSbl']"));
	}
	
	@FindBy(xpath="/html/body/div[1]/section/section/section/div/div[2]/div[2]/div[3]/div[1]/section/div[2]/div/section[2]/section/div[2]/button")
	WebElement ContinueButton;
	
	public WebElement getContinueButton() {
		return ContinueButton;
	}
	
	@FindBy(xpath="//*[@id=\"reviewPageHead\"]/section/section/header[1]")
	WebElement ReviewBookingText;
	
	public WebElement getReviewBookingText() {
		return ReviewBookingText;
	}
	
	@FindBy(xpath="//*[@id=\"insuranceBlock\"]/section[1]")
	WebElement TripInsurance;
	
	public WebElement getTripInsurance() {
		return TripInsurance;
	}
	
	@FindBy(xpath="//*[@id=\"insuranceBlock\"]/section[3]")
	WebElement TravellerDetails;
	
	public WebElement getTravellerDetails() {
		return TravellerDetails;
	}
	
	@FindBy(id="insuranceNo")
	WebElement NoInsurance;
	
	public WebElement getNoInsurance() {
		return NoInsurance;
	}
	
	@FindBy(xpath="//*[@id=\"travellerForm1\"]/div/div/div[1]/div[1]/div/select")
	WebElement Gender;
	
	public Select getGender() {
		return new Select(Gender);
	}
	
	@FindBy(xpath="//*[@id=\"travellerForm1\"]/div/div/div[1]/div[2]/input")
	WebElement FullNameField;
	
	public WebElement getFullNameField() {
		return FullNameField;
	}
	
	@FindBy(xpath="//*[@id=\"travellerForm1\"]/div/div/div[1]/div[3]/input")
	WebElement AgeField;
	
	public WebElement getAgeField() {
		return AgeField;
	}
	
	@FindBy(xpath="//*[@id=\"TravllerContactBlock\"]/div[1]/input")
	WebElement EmailField;
	
	public WebElement getEmailField() {
		return EmailField;
	}
	
	@FindBy(xpath="//*[@id=\"TravllerContactBlock\"]/div[2]/div/input")
	WebElement MobileField;
	
	public WebElement getMobileField() {
		return MobileField;
	}
	
	@FindBy(xpath="//*[@id=\"insuranceBlock\"]/button")
	WebElement PayButton;
	
	public WebElement getPayButton() {
		return PayButton;
	}
	
	@FindBy(xpath="//*[@id=\"reviewPageHead\"]/section/section/header[1]")
	WebElement PaymentText;
	
	public WebElement getPaymentText() {
		return PaymentText;
	}
	
	public BusPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
