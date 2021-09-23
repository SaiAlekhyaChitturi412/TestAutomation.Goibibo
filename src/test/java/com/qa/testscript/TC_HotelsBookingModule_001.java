package com.qa.testscript;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TC_HotelsBookingModule_001 extends TestBase 
{
	String currentdate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());	
	@Test(priority=1,dataProvider="excelData")
	public void HotelsBooking(String titleoftheperson ,String FirstName, String LastName, String email, String phonenumber,String Location,String FromDate,String ToDate) throws InterruptedException, IOException, ParseException
	{
		//selcting hotels page from index page
		hotels.getHotels().click();
		Thread.sleep(4000);					
		String title = driver.getCurrentUrl();
		if(title.contains("hotels"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("User not landed on Hotels Page");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);			
		}
		
		
		//Selecting the location-India	
		hotels.getIndia().click();
		Thread.sleep(4000);
		if(hotels.getIndia().isEnabled())
		{
			Reporter.log("India is selected");
		}
		else
		{
			Reporter.log("India is not selected");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		Thread.sleep(4000);
		
		//Sending the location from Excel Input
		hotels.getWhere().sendKeys(Location);
		List<WebElement> autosuggestionsofplaces = hotels.getautosuggestionsofplaces();
		for(WebElement names:autosuggestionsofplaces)
		{
			Reporter.log(names.getText());
		}
		hotels.getLocationList().click();
		Thread.sleep(4000);
		Thread.sleep(4000);	
		//Selcting the dates from the calendar
		hotels.getCalendar().click();
		Thread.sleep(4000);
		List<WebElement>dates = hotels.getDates1();		
		int from_date = get_date(FromDate);
		int from_month = get_month(FromDate);
		int from_year = get_year(FromDate);		
		int to_date = get_date(ToDate);
		int to_month = get_month(ToDate);
		int to_year = get_year(ToDate);
		Date fromDate = new SimpleDateFormat("dd-MMM-yyyy").parse(FromDate);
		Date toDate = new SimpleDateFormat("dd-MMM-yyyy").parse(ToDate);		
		long time_difference = toDate.getTime() - fromDate.getTime();  
        // Calucalte time difference in days  
        long days_difference = (time_difference / (1000*60*60*24)) % 365;        
        if(days_difference > 20) {
        	captureScreenShot(driver, "HotelsSearching");
        	Reporter.log("Number of days exceeded the limit of 20");
        	Assert.assertFalse(true);
        }
        int number_of_clicks = 0;    		
    	if(from_year == get_year(currentdate))
    	{
    		number_of_clicks = from_month - get_month(currentdate);
    	}		
    	else
    	{
    		number_of_clicks = 12 + get_month(currentdate) - from_month;
    	}
    		
    	if(number_of_clicks > 12) 
    	{
    		captureScreenShot(driver, "HotelsSearching");
    		Assert.assertFalse(false);
    	}    		
    	for(int i=0;i<number_of_clicks;i++)
    	{
    		hotels.getNext().click();
    	}
    	for(WebElement date:dates)
    	{
    		int current_item = Integer.parseInt(date.getText());
    		if(from_date == current_item)
    		{
    			date.click();
    			break;
    		}
    	}
    	Thread.sleep(4000);		
    	List<WebElement>datesafterclicking = hotels.getDates1();    	
    	for(WebElement date:datesafterclicking)
    	{
    		int current_item = Integer.parseInt(date.getText());
    		if(to_date == current_item)
    		{
    			date.click();
    			break;
    		}
    	}
    	
    	//Selecting the rooms,adults and clicking on done
		hotels.getRoomSelection().click();
		Thread.sleep(3000);
		hotels.getRoom().click();
		Thread.sleep(3000);
		hotels.getAdults().click();
		Thread.sleep(3000);
		hotels.getDone().click();
		Thread.sleep(3000);
		
		//clicking on SearchHotels
		hotels.getSearchHotels().click();
		Thread.sleep(3000);
		
		//New Page is opened with Title Results	
		String title1 = driver.getTitle();
		if(title1.contains("Results"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			captureScreenShot(driver,"HotelsBooking");
		}
		
		//selecting filter pay at hotel available	
		hotels.getPayathotel().click();
		Thread.sleep(4000);
		if(hotels.getPayathotel().isEnabled())
		{
			Reporter.log("Pay At hotel is Clicked");
		}
		else
		{
			Reporter.log("Pay At hotel is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selecting filter 2000-4000/-
		hotels.getPriceRange().click();
		Thread.sleep(4000);
		if(hotels.getPriceRange().isEnabled())
		{
			Reporter.log("Price Range Clicked");
		}
		else
		{
			Reporter.log("Price Range  is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selcting clear option
		hotels.getClear().click();
		Thread.sleep(4000);
		if(hotels.getClear().isEnabled())
		{
			Reporter.log("Clear is Clicked");
		}
		else
		{
			Reporter.log("Clear is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//Reporting all the suggested hotels along with their Prices in location
		List<WebElement> hotelslist = hotels.gethotellist();
		for(WebElement name:hotelslist)
		{
			Reporter.log(name.getText());
		}
		List<WebElement> prices = hotels.getPrices();
		for(WebElement name:prices)
		{
			Reporter.log(name.getText());
		}
		
		//selecting First suggested hotel
		hotels.gethotelone().click();
		Thread.sleep(4000);
		hotels.switchtowindows();
		
		//selecting room options
		hotels.getroomsinsecondpage().click();
		Thread.sleep(4000);
		if(hotels.getroomsinsecondpage().isEnabled())
		{
			Reporter.log("Room optionsis clicked");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Rooms option is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selecting Amenities
		hotels.getAmenities().click();
		Thread.sleep(4000);
		if(hotels.getAmenities().isEnabled())
		{
			Reporter.log("Amenities is clicked");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Amenities option is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selecting guestreviews
		hotels.getGuestreview().click();
		Thread.sleep(4000);
		if(hotels.getGuestreview().isEnabled())
		{
			Reporter.log("Guestreview is clicked");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Guestreview option is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selecting Hotel policies
		hotels.getHotelPolicies().click();
		Thread.sleep(4000);
		if(hotels.getHotelPolicies().isEnabled())
		{
			Reporter.log("hotelpolicies is clicked");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("hotelpolicies option is not clicked");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		//selecting the RoomsOptions
		hotels.getroomsinsecondpage().click();
		Thread.sleep(4000);
		
		//selecting the Selectrooms Button
		WebElement selectbutton = hotels.getSelectButton();
		js.executeScript("arguments[0].click();", selectbutton);
		Thread.sleep(4000);
		String titleofthepage = driver.getCurrentUrl();
		if(titleofthepage.contains("booking"))
		{
			Reporter.log("User in the Booking Page/Payment Page");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("User has  not landed in Booking Page/Payment Page");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		
		
		//sending the details for Payment(FirstName, LastName, Email, and Phonenumber)
		//title of the person
		hotels.getTitle().sendKeys(titleoftheperson);
		Thread.sleep(4000);
		hotels.getFirstName().sendKeys(FirstName);
		Thread.sleep(4000);	
		String attribute = hotels.getFirstName().getAttribute("value");
		//FirstName
		if(attribute.contains(FirstName))
		{
			Reporter.log("FirstName Input is Correctly Entered");
		}
		else
		{
			Reporter.log("FirstName Input is not Entered");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		//lastName
		hotels.getLastName().sendKeys(LastName);
		Thread.sleep(4000);
		String lastnameentered = hotels.getLastName().getAttribute("value");
		if(lastnameentered.contains(LastName))
		{
			Reporter.log("LastName Input is entered Correctly");
		}
		else
		{
			Reporter.log("LastName Input is not Entered Correctly");
			captureScreenShot(driver,"HotelsBooking");
			Assert.assertFalse(true);
		}
		//Email
		hotels.getEmail().sendKeys(email);
		Thread.sleep(4000);
		//Phone Number
		int index1 = phonenumber.indexOf(".");
		int index2 = phonenumber.indexOf("E");
		phonenumber = phonenumber.substring(0,index1)+phonenumber.substring(index1+1,index2);
		hotels.getPhonenumber().sendKeys(phonenumber);
		Thread.sleep(4000);
		
		//clicking the proceed to payment options
		hotels.getProceed().click();
		Thread.sleep(4000);
		driver.close();
		hotels.switchtoParent();
	}	
	
	
	public int get_year(String s)
	{
		return Integer.parseInt(s.substring(7));
	}	
	public int get_month(String s)
	{
		Map<String, Integer> my_map = new HashMap<String, Integer>();
		my_map.put("Jan", 1);
		my_map.put("Feb", 2);
		my_map.put("Mar", 3);
		my_map.put("Apr", 4);
		my_map.put("May", 5);
		my_map.put("Jun", 6);
		my_map.put("Jul", 7);
		my_map.put("Aug", 8);
		my_map.put("Sep", 9);
		my_map.put("Oct", 10);
		my_map.put("Nov", 11);
		my_map.put("Dec", 12);
		return my_map.get(s.substring(3, 6));
	}
	
	public int get_date(String s) 
	{
		return Integer.parseInt(s.charAt(0) + "" + s.charAt(1));
	}
	
	@DataProvider(name="excelData")
	public Object[][] data() throws IOException
	{
		Object[][] obj = XData.getData("TestData","Sheet1");
		return obj;
	}
}
