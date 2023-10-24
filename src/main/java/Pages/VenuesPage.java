package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VenuesPage 
{
	private static WebElement element = null;
	//-----------------------------------------------------------------------------------	
	public static WebElement  Venueslink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//li[@title='Venues']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewVenueslink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  VenueStatus (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//span[@class='ant-switch-inner']"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  SelectOrg (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("(//input[@role='combobox'])[3]"));
			return element;		
		}
	//-----------------------------------------------------------------------------------------
	public static WebElement  VenueType (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@aria-owns='venues_form_venue_type_list']"));
			return element;		
		}	
	//-----------------------------------------------------------------------------------------
	public static WebElement  VenueName (WebDriver driver ) 

		{
			element = driver.findElement(By.id("venues_form_name"));
			return element;		
		}	
	//-----------------------------------------------------------------------------------------
		public static WebElement  VenueCity (WebDriver driver ) 

			{
				element = driver.findElement(By.xpath("(//input[@role='combobox'])[5]"));
				return element;		
			}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NumberWorkingShifts (WebDriver driver )

	{
		element = driver.findElement(By.id("venues_form_numberOfWorkingPeriods"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  WorkFrom (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//input[@placeholder='From']"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  WorkTo (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//input[@placeholder='To']"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
		public static WebElement  VenueLocation (WebDriver driver )

			{
				element = driver.findElement(By.id("searchBox"));
				return element;		
			}
		//-----------------------------------------------------------------------------------------
		public static WebElement  Venuesave (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  Venuesaveconfirmationmessage (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//span[contains(text(),'New venue created successfully')]"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  VenueEditconfirmationmessage (WebDriver driver )

		{
			element = driver.findElement(By.xpath("//span[contains(text(),'venue updated successfully')]"));
			return element;
		}
	//-----------------------------------------------------------------------------------------
		                       // Delivery fields
		public static WebElement  CarModel (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_carModel']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  ManufactureName (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_manufactureName']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  ManufacturedYear (WebDriver driver )

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_manufacturedYear']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  PlateNumber (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_plateNumber']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  ChassisNumber (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_chassisNumber']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  DeliveryFees (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_deliveryFees']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  NumberOfTanks (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_numberOfTanks']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  NumberOfNozzle (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_numberofNozzle1']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  TankCapacity (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_capacity1']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  TankProduct (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("(//input[@role='combobox'])[6]"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
		public static WebElement  CoverageArea (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']"));
			return element;		
		}
		//-----------------------------------------------------------------------------------------
	//////////////////////////Delete Venue//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement DeleteButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-default ant-btn-dangerous')]"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VenueDeleteMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	/////////////////////////Filter Venue//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement FilterPart(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@role='button']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement CityVenue(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='rc_select_12']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement CreationDateFrom(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_created_at']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement CreationDateTo(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='To']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VenueTypeFilter(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_venue_type']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement OrgName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='rc_select_14']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VenueNameFilter(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='rc_select_15']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VenueCodeFilter(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_code']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FilterApply(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
		return element;
	}
	//------------------------------------------------------------------------------------------


}
