package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VendorsPage {
	
	private static WebElement element;
	//------------------------------------------------------------------------------------------
	
	public static WebElement  Vendorlink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[4]/span[1]/a[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewVendorlink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/button[1]"));
		return element;		
	}
	//-------------------------------------------------------------------------------------------
	public static WebElement  SelectVenue (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='vendors_form_venueId']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorName (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='vendors_form_officialName']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorSave (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorFualBack (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//button[@id='vendors_form_cashBackIsActive']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  Vendorsaveconfirmationmessage (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'New vendor created successfully')]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  VendorEditconfirmationmessage (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'Vendor updated successfully')]"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	/////////////////////////////FuelBack Configuration ////////////////////////////////////
	public static WebElement  FuelBackLimitperVendor (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='vendors_form_maxLimit']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  FuelBackPercentageforEndUser (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='vendors_form_trxLimit']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorValidUntilFrom (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='vendors_form_validUntil']"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorValidUntilTo (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[7]/div[2]/div[4]/div[2]/div[1]/span[1]/div[1]/div[3]/input[1]"));
		return element;		
	}
    //-----------------------------------------------------------------------------------------
	public static WebElement  VendorSaveFuelBack (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[8]/div[1]/div[1]/span[1]/button[1]"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
      ///// For Edit Vendor////
	public static WebElement  EditIconVendorFuelBack (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/section/section/main/div[1]/div[3]/div[2]/div/div/div/div/div[1]/div[2]/table/tbody/tr[5]/td[9]/button[2]"));
		return element;
	}
	public static WebElement  EditIconVendorNormal (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]/button[2]"));
		return element;
	}
	//////////////////////////Delete Vendor//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement DeleteButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VendorDeleteMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	/////////////////////////Filter Vendors//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement FilterPart(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@role='button']"));
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
	public static WebElement VenueName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='To']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement VendorsName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='rc_select_29']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FilterApply(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FilterToday(WebDriver driver) {
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));
		return element;
	}


}
