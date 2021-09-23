package com.qa.pages;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class HotelsPages 
{
	WebDriver driver;
	String parent;
	public HotelsPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		parent = driver.getWindowHandle();
	}
	
	
	//selecting Hotels from the index page
	@FindBy(xpath="//header/ul[1]/li[2]/a[1]")
	WebElement hotels;
	public WebElement getHotels() throws InterruptedException
	{
		return hotels;
		
	}
	
	//selecting india or international radio buttons
	@FindBy(xpath="//h4[contains(text(),'India')]")
	WebElement india;
	public WebElement getIndia() throws InterruptedException
	{
		return india;
	}	
	
	
	//goa
	@FindBy(xpath="//p[contains(text(),'Goa')]")
	WebElement goa;
	public WebElement getGoa() throws InterruptedException
	{
		return goa;
	}
	
	
	//where-input field
	@FindBy(xpath="//input[@id='downshift-1-input']")
	WebElement where;
	public WebElement getWhere()
	{
		return where;
	}
	
	
	//selecting locations from the list	
	@FindBy(xpath="//ul[@role='listbox']//li[1]")
	WebElement locationlist;
	public WebElement getLocationList()
	{
		return locationlist;
	}
	//calendar
	@FindBy(xpath="//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-7 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-14 hAEfdZ kSflmU']")
	WebElement calendar1;
	public WebElement getCalendar()
	{
		return calendar1;
	}
	@FindAll({@FindBy(xpath="//li[@class='date_is_selectable_true']//span")})
	List<WebElement> dates;
	public List<WebElement> getDates()
	{
		return dates;
	}
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[28]/span[1]")
	WebElement date1;
	public WebElement getDate1()
	{
		return date1;
	}
	
	@FindBy(xpath="//input[@class='SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH']")
	WebElement roomselection;
	public WebElement getRoomSelection()
	{
		return roomselection;
	}
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement room;
	public WebElement getRoom()
	{
		return room;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]")
	WebElement adults;
	public WebElement getAdults()
	{
		return adults;
	}
	@FindBy(xpath="//button[contains(text(),'Done')]")
	WebElement done;
	public WebElement getDone()
	{
		return done;
	}
	@FindBy(xpath="//button[contains(text(),'Search Hotels')]")
	WebElement searchhotels;
	public WebElement getSearchHotels()
	{
		return searchhotels;
	}		
	@FindAll({ @FindBy(xpath="//ul[@role='listbox']//li")})
	List<WebElement> autosuggestionsofplaces;
	public List<WebElement> getautosuggestionsofplaces()
	{
		return autosuggestionsofplaces;
	}
		
	//clear Filters
	@FindBy(xpath="//span[contains(text(),'CLEAR')]")
	WebElement clear;
	public WebElement getClear() 
	{
		return clear;
	}
	
	//popular Filters
	@FindBy(xpath="//span[contains(text(),'Pay At Hotel Available')]")
	WebElement payathotel;
	public WebElement getPayathotel()
	{
		return payathotel;
	}
	public void getPayAtHotel()
	{
		payathotel.click();
	}
	//price range
	@FindBy(xpath="//span[contains(text(),'₹2001 - ₹4000')]")
	WebElement price;
	public WebElement getPriceRange()
	{
		return price;
	}	
	@FindBy(xpath="//span[contains(text(),'Villa')]")
	WebElement villa;
	public WebElement getVilla()
	{
		return villa;
	}
	//suggesting list of a hotels
	@FindAll({@FindBy(xpath="//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-7 hAEfdZ']")})
	List<WebElement> hotelslist;
	public List<WebElement>gethotellist()
	{
		return hotelslist;
	}
	
	//prices of the list
	@FindAll({@FindBy(xpath="//p[@class='HotelCardstyles__CurrentPrice-sc-1s80tyk-28 inUyrJ']")})
	List<WebElement> prices;
	public List<WebElement> getPrices()
	{
		return prices;
	}
	//Selecting the hotel from the suggested list
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/section[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement hotel1;
	public WebElement gethotelone()
	{
		return hotel1;
	}
	public void switchtoParent() throws InterruptedException
	{
		driver.switchTo().window(parent);
		Thread.sleep(4000);
	}
	public void switchtowindows() throws InterruptedException
	{
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		for(String child:windows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
			}
		}
		Thread.sleep(3000);
	}
	
	@FindBy(xpath="//a[contains(text(),'Room Options')]")
	WebElement rooms;
	public WebElement getroomsinsecondpage()
	{
		return rooms;
	}
	@FindBy(xpath="//a[contains(text(),'Amenities')]")
	WebElement amenities;
	public WebElement getAmenities()
	{
		return amenities;
	}
	@FindBy(xpath="//a[contains(text(),'Guest Reviews')]")
	WebElement guestreview ;
	public WebElement getGuestreview()
	{
		return guestreview;
	}
	@FindBy(xpath="//a[contains(text(),'Hotel Policies')]")
	WebElement hotelpolicies;
	public WebElement getHotelPolicies()
	{
		return hotelpolicies;
	}	
	@FindBy(xpath="//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-10 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 KETBj bIgcAI']")
	WebElement selectbutton;
	public WebElement getSelectButton()
	{
		return selectbutton;
	}
	
	//----------------------------------------payment Page-------------------------------------------------------------------------
	//selecting title of the person
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/select[1]")
	WebElement title;
	public WebElement getTitle()
	{
		return title;
	}
	public void getTitleofPerson(String miss) throws InterruptedException
	{
		Select s = new Select(title);
		s.selectByVisibleText(miss);
		Thread.sleep(4000);
	}
	//enter the name
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement firstname;
	public WebElement getFirstName()
	{
		return firstname;
	}
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/input[1]")
	WebElement lastname;
	public WebElement getLastName()
	{
		return lastname;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement email;
	public WebElement getEmail()
	{
		return email;
	}
	
	
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	WebElement phonenumber;
	public WebElement getPhonenumber()
	{
		return phonenumber;
	}
	@FindBy(xpath="//span[contains(text(),'Proceed To Payment Options')]")
	WebElement proceed;
	public WebElement getProceed()
	{
		return proceed;
	}	
	public void driverclose()
	{
		driver.close();
	}
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/span[2]")
	WebElement next;
	public WebElement getNext()
	{
		return next;
	}
	@FindAll({@FindBy(xpath="//ul[@class=\"dcalendar-newstyles__DateWrapDiv-sc-1i003by-17 bHpvYg\"]//li[@class=\"date_is_selectable_true\"]")})
	List<WebElement>dates1;
	public List<WebElement> getDates1()
	{
		return dates1;
	}
	
}
