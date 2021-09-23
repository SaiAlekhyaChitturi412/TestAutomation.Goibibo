package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightPages{

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"gosuggest_inputSrc\"]")
	WebElement departLocation;
	
	public WebElement getDepartLocation() {
		return departLocation;
	}
	
	

	@FindBy(id = "gosuggest_inputDest")
	WebElement arrivalLocation;
	
	public WebElement getArrivalLocation() {
		return arrivalLocation;
	}
	
	
	
	@FindBy(xpath="//span[text()='Mumbai, India']")
	WebElement autoSuggest1;
	
	public WebElement getAutoSuggest1() {
		return autoSuggest1;
	}

	
	@FindBy(xpath="//span[text()='Delhi, India']")
	WebElement autoSuggest2;
	
	public WebElement getAutoSuggest2() {
		return autoSuggest2;
	}
	
	
	
	@FindBy(id="departureCalendar")
	WebElement departDate;
	
	public WebElement getDepartCalendar() {
		return departDate;
	}
	
	
	@FindBy(id="returnCalendar")
	WebElement returnDate;
	
	public WebElement getReturnCalendar() {
		return returnDate;
	}
	
	@FindBy(xpath="//div[text()='20']")
	WebElement dDate;

	public WebElement getdDate() {
		return dDate;
	}
	
	
	@FindBy(xpath="//div[text()='29']")
	WebElement rDate;
	
	public WebElement getrDate() {
		return rDate;
	}


	@FindBy(id="pax_label")
	WebElement passengerAndTravelClass;

	public WebElement getPassengerAndTravelClass() {
		return passengerAndTravelClass;
	}

	
	@FindBy(id="adultPaxPlus")
	WebElement adult;

	public WebElement getAdult() {
		return adult;
	}

   
	@FindBy(id="gi_class")
	WebElement travelClass;

	public Select getTravelClass() {
		return new Select(travelClass);
	}


	@FindBy(id="pax_close")
	WebElement closeTravelClassTab;
	
	public WebElement getCloseTravelClass() {
		return closeTravelClassTab;
	}

 
	@FindBy(id="gi_search_btn")
	WebElement findFlights;
	
	public WebElement getFindFlights() {
		return findFlights;
	}
	
	
	@FindBy(xpath="//span[text()='Vistara']/preceding-sibling::span[@class='alignItemsCenter dF padT5']/parent::span[@class='flexCol padL5']/parent::div[@class='dF justifyBetween flex1 alignItemsCenter']")
	WebElement flightpreference;
	
	public WebElement isFlightPreferenceVisible() {
		return flightpreference;
	}
	
	
	@FindBy(xpath="//span[text()='Vistara']//parent::span[@class='flexCol padL5']//parent::div[@class='dF justifyBetween flex1 alignItemsCenter']")
	WebElement checkFlightByPreference;
	
	public WebElement getFlightPreference() {
		return checkFlightByPreference;
	}

	
	
	@FindAll({@FindBy(xpath="//div[@class='roundTripResultCardstyles__RoundTripCol1-sc-j11urj-8 brNvul dF justifyBetween alignItemsEnd']")})
	List<WebElement> AllFights;
	
	public List<WebElement> getAllFlights(){
		return AllFights;
	}
	
	
	
	@FindBy(xpath="//*[@id=\"root\"]/div[3]/div[2]/div[3]/div[3]")
    WebElement paymentMethods;
	
	public WebElement getPaymentMethods() {
		return paymentMethods;
	}
	
	
	
	@FindBy(xpath="//input[@class='srp-card-uistyles__Fltbook-sc-3flq99-35 iyZbYk fb quicksand widthF105']")
	WebElement bookFlight;
	
	public WebElement getBookFlight() {
		return bookFlight;
	}
	
	
	@FindBy(xpath="//select[@class='common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9 cSiGky']")
	WebElement nameTitle;
	
	public Select getNameTitle() {
		return new Select(nameTitle);
	}
	
	
	@FindBy(xpath="//input[@class='common-elementsstyles__IpTxt-sc-ilw4bs-11 iFankY width100' and @name='givenname']")
	WebElement name;
	
	public WebElement getName() {
		return name;
	}
	
	
	@FindBy(xpath="//input[@class='common-elementsstyles__IpTxt-sc-ilw4bs-11 iFankY width100' and @name='givenname']")
	WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}
	
	
	@FindBy(xpath="//input[@class='common-elementsstyles__IpTxt-sc-ilw4bs-11 sdBQQ width100']")
	WebElement email;
	
	public WebElement getEmail() {
		return email;
	}
	
	
	
	@FindBy(xpath="//input[@class='common-elementsstyles__IpTxt-sc-ilw4bs-11 iFankY width100' and @name='mobile']")
	WebElement mobile;
	
	public WebElement getMobileNo() {
		return mobile;
	}
	
	
	@FindBy(xpath="//button[text()='Proceed']")
    WebElement proceed;
	
	public WebElement getProceedBtn() {
		return proceed;
	} 
	
	
	@FindBy(xpath="//button[text()='Proceed To Payment']")
	WebElement proceedToPayment;
	
	public WebElement getProceedToPayment() {
		return proceedToPayment;
		
	}
	

	public FlightPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
