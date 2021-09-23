package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainPages {
	WebDriver driver;

	public TrainPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Trains")
	WebElement TrainsCategory;

	public WebElement getTrainsCategory() {
		return TrainsCategory;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[1]/label[1]/div[1]/div[1]/input[1]")
	WebElement fromTextbox;

	public WebElement getFromTextbox() {
		return fromTextbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[1]/label[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/p[2]/span[1]/span[1]")
	WebElement fromLocation;

	public WebElement getFromLocation() {
		return fromLocation;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[1]/label[2]/div[1]/div[1]/input[1]")

	WebElement toTextbox;

	public WebElement getToTextbox() {
		return toTextbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[1]/label[2]/div[1]/div[1]/div[1]/ul[1]/li[1]")

	WebElement toLocation;

	public WebElement getToLocation() {
		return toLocation;
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/section[1]/section[1]/section[1]/aside[2]/label[1]/div[1]/div[1]/input[1]")
	WebElement chooseTrainTextbox;

	public WebElement getChooseTrainTextbox() {
		return chooseTrainTextbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[2]/label[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/p[1]")
	WebElement chooseTrain;

	public WebElement getChooseTrain() {
		return chooseTrain;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[1]/section[1]/section[1]/aside[3]/div[2]/div[1]/label[2]/span[1]/input[1]")
	WebElement date;

	public WebElement getDate() {
		return date;
	}

	@FindBy(xpath = "//button[contains(text(),'Search Trains')]")
	WebElement searchTrainButton;

	public WebElement getSearchTrainButton() {
		return searchTrainButton;
	}

	@FindBy(xpath = "//body[1]/div[2]/section[1]/section[1]/div[5]/label[1]/span[1]")
	WebElement updateDate;

	public WebElement getUpdateDate() {
		return updateDate;
	}

	@FindBy(xpath = "//*[@id=\"app\"]/section/section/div[5]/label/div/div/div[2]/div[3]/div[3]/div[1]/div")
	WebElement chooseDate;

	public WebElement getChooseDate() {
		return chooseDate;
	}

	@FindBy(xpath = "//*[@id=\"app\"]/section/section/div[6]/button")
	WebElement updateSearch;

	public WebElement getUpdateSearch() {
		return updateSearch;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[1]/div[2]/ul[1]/li[1]/label[1]/span[1]/span[1]//body[1]/div[2]/div[1]/section[1]/section[2]/aside[1]/div[2]/ul[1]/li[1]/label[1]/span[1]/span[1]")
	WebElement classCategory;

	public WebElement getClassCategory() {
		return classCategory;
	}

	@FindBy(xpath = "//span[contains(text(),'General Quota')]")
	WebElement quota;

	public WebElement getQuota() {
		return quota;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[3]/div[2]/ul[1]/li[1]/label[1]/span[1]")
	WebElement Amenities;

	public WebElement getAmenities() {
		return Amenities;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[7]/div[2]/ul[1]/li[3]/label[1]/span[1]")
	WebElement arrivalStation;

	public WebElement getArrivalStation() {
		return arrivalStation;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[4]/div[2]/ul[1]/li[4]/label[1]/span[1]")
	WebElement departureTime;

	public WebElement getDepartureTime() {
		return departureTime;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[5]/div[2]/ul[1]/li[3]/label[1]/span[1]")
	WebElement arrivalTime;

	public WebElement getArrivalTime() {
		return arrivalTime;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/aside[6]/div[2]/ul[1]/li[1]/label[1]/span[1]")
	WebElement departureStation;

	public WebElement getDepartureStation() {
		return departureStation;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[2]/div[1]/section[1]/div[1]/ul[1]/li[1]")
	WebElement acOnlyOption;

	public WebElement getAcOnlyOption() {
		return acOnlyOption;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[2]/div[1]/section[1]/div[1]/ul[1]/li[2]")
	WebElement availableOnlyOption;

	public WebElement getAvailableOnlyOption() {
		return availableOnlyOption;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[2]/div[1]/section[1]/div[1]/ul[1]/li[3]")
	WebElement departAfterOption;

	public WebElement getDepartAfterOption() {
		return departAfterOption;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[2]/section[1]/section[1]/aside[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement chooseTrainOption;

	public WebElement getChooseTrainOption() {
		return chooseTrainOption;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement gender;

	public WebElement getGender() {
		return gender;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[3]/div[2]/div[1]/div[1]")
	WebElement berth;

	public WebElement getBerth() {
		return berth;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[3]")
	WebElement upperberth;

	public WebElement getUpperBerth() {
		return upperberth;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[3]/div[1]/div[2]/div[2]/input[1]")
	WebElement name;

	public WebElement getName() {
		return name;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[3]/div[1]/div[3]/div[2]/div[1]/input[1]")
	WebElement age;

	public WebElement getAge() {
		return age;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[2]/div[4]/div[1]/button[1]")
	WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement pincode;

	public WebElement getPincode() {
		return pincode;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[4]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement mobileNo;

	public WebElement getMobileNo() {
		return mobileNo;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[4]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement emailId;

	public WebElement getEmailId() {
		return emailId;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[5]/div[2]/div[1]/div[2]/div[1]/input[1]")
	WebElement irctcId;

	public WebElement getIrctcId() {
		return irctcId;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]")
	WebElement verifyButton;

	public WebElement getVerifyButton() {
		return verifyButton;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement reservationPreverence;

	public WebElement getReservationPreverence() {
		return reservationPreverence;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[6]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]")
	WebElement bookOnlyifOption;

	public WebElement getBookOnlyifOption() {
		return bookOnlyifOption;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[6]/div[2]/div[2]/div[1]/p[1]/label[1]")
	WebElement autoupgradationCheckbox;

	public WebElement getAutoupgradationCheckbox() {
		return autoupgradationCheckbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[6]/div[2]/div[2]/div[2]/p[1]/label[1]")
	WebElement berthAllocatedCheckbox;

	public WebElement getBerthAllocatedCheckBox() {
		return berthAllocatedCheckbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[6]/div[2]/div[1]/div[2]/div[1]/input[1]")
	WebElement preferredCoach;

	public WebElement getPreferredCoach() {
		return preferredCoach;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[7]/div[2]/p[1]/label[1]")
	WebElement securemytripCheckbox;

	public WebElement getSecuremytripCheckbox() {
		return securemytripCheckbox;
	}

	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[2]/div[2]/div[2]/div[1]/label[1]/span[2]/span[1]")
	WebElement freeCancellationOption;

	public WebElement getFreeCancellationOptoin() {
		return freeCancellationOption;
	}
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[1]/div[8]/button[1]")
	WebElement payButton;

	public WebElement getPayButton() {
		return payButton;
	}
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/section[2]/section[2]/section[4]/div[1]/div[1]/div[1]/div[5]/div[4]/div[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement depitcardOption;

	public WebElement getDepitcardOption() {
		return depitcardOption;
	}
}
