package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CabsPages
{
	WebDriver driver;
	public CabsPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//header/ul[1]/li[4]/a[1]")
	WebElement cab;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCab() {
		return cab;
	}
	public WebElement getRadiobutton1() {
		return radiobutton1;
	}
	public WebElement getFrom() {
		return from;
	}
	public WebElement getHyderabad() {
		return Hyderabad;
	}
	public WebElement getTo() {
		return to;
	}
	public WebElement getBanglore() {
		return banglore;
	}
	public WebElement getPickupdateclicking() {
		return pickupdateclicking;
	}
	public WebElement getPickupdate() {
		return pickupdate;
	}
	public WebElement getSearchcabs() {
		return searchcabs;
	}
	public WebElement getSelectcar() {
		return selectcar;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getLocationlist() {
		return locationlist;
	}
	public WebElement getFirstname() {
		return Firstname;
	}
	public WebElement getMobilenumber() {
		return Mobilenumber;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPay() {
		return pay;
	}
	@FindBy(xpath="//body/div[@id='root']/section[1]/section[1]/section[1]/section[1]/div[1]/label[1]/span[1]")
	WebElement radiobutton1;	
	@FindBy(xpath="//input[@id='downshift-1-input']")
	WebElement from;
	@FindBy(xpath="//body/div[@id='root']/section[1]/section[1]/section[1]/section[1]/div[2]/section[1]/div[1]/div[1]/li[1]/div[1]/p[2]")
	WebElement Hyderabad;
	@FindBy(xpath="//input[@id='downshift-2-input']")
	WebElement to;
	@FindBy(xpath="//p[contains(text(),'Bangalore, Karnataka, India')]")
	WebElement banglore;
	@FindBy(xpath="//label[contains(text(),'Pickup Date')]")
	WebElement pickupdateclicking;
	@FindBy(xpath="//body[1]/div[1]/section[1]/section[1]/section[1]/section[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[2]/li[30]/span[1]")
	WebElement pickupdate;
	@FindBy(xpath="//button[contains(text(),'SEARCH CABS')]")
	WebElement searchcabs;
	@FindBy(xpath="//span[contains(text(),'Any Hatchback - Indica, WagonR or similar')]")
	WebElement filter;
	public WebElement getFilter()
	{
		return filter;
	}
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/span[1]/button[1]")
	WebElement selectcar;
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	WebElement location;
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/li[1]/div[1]/p[1]")
	WebElement locationlist;	
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement Firstname;
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[1]/input[1]")
	WebElement Mobilenumber;
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[3]/div[1]/div[4]/div[2]/div[3]/div[1]/input[1]")
	WebElement email;
	@FindBy(xpath="//button[@id='paymentButton']")
	WebElement pay;
	
	
	
}
