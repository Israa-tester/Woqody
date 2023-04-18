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
		element = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[3]/span[1]/a[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewVenueslink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'Add New Venue')]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  SelectOrg (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//body/div/div[@class='ant-drawer ant-drawer-right ant-drawer-open drawer-btn-component']/div[@class='ant-drawer-content-wrapper']/div[@class='ant-drawer-content']/div[@class='ant-drawer-wrapper-body']/div[@class='ant-drawer-body']/form[@class='ant-legacy-form ant-legacy-form-horizontal']/div[@class='ant-row ant-legacy-form-item']/div[@class='ant-col ant-legacy-form-item-control-wrapper']/div[@class='ant-legacy-form-item-control']/span[@class='ant-legacy-form-item-children']/div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']/div[@class='ant-select-selector']/span[@class='ant-select-selection-search']/input[1]"));
			return element;		
		}
	//-----------------------------------------------------------------------------------------
	public static WebElement  VenueType (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_venue_type']"));
			return element;		
		}	
	//-----------------------------------------------------------------------------------------
	public static WebElement  VenueName (WebDriver driver ) 

		{
			element = driver.findElement(By.xpath("//input[@id='venues_form_name']"));
			return element;		
		}	
	//-----------------------------------------------------------------------------------------
		public static WebElement  VenueCity (WebDriver driver ) 

			{
				element = driver.findElement(By.xpath("//input[@id='venues_form_city']"));
				return element;		
			}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NumberWorkingShifts (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//input[@id='venues_form_numberOfWorkingPeriods']"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  WorkFrom (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//input[@id='venues_form_workingHours1']"));
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
				element = driver.findElement(By.xpath("//input[@id='searchBox']"));
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
		public static WebElement  ManufaturedYear (WebDriver driver ) 

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
			element = driver.findElement(By.xpath("//input[@id='venues_form_productId1']"));
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
		element = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
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
