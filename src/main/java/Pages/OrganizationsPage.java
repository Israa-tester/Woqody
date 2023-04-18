package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrganizationsPage 
{
	private static WebElement element = null;
	//-----------------------------------------------------------------------------------	
	public static WebElement  Organizationslink (WebDriver driver)

	{
		element = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/a[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationslink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'New Organization')]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationSettingsCollapse (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]"));
		
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationstopup (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//*[@id=\"orgs_form_canAddTopupMembers\"]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationFuelBack (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'Fuel Back Disabled')]"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationEnterprise (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'Enterprise disabled')]"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  Organizationname (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//*[@id=\"orgs_form_name\"]"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  Organizationaddress (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_address']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationEnterpriseBalance (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[4]/div[2]/div[1]/div[1]/span[1]/*[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationBalanceUpdate (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_balance']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationBalanceEnterpriseAttachment (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[@class='ant-legacy-form-item-children']//input[@type='file']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationFualAndTopupBalance (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[4]/div[3]/div[1]/div[1]/span[1]/*[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	
	public static WebElement  OrganizationChargeLimit (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_topupChargeLimit']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	
	//-------------FuelBack Configuration------------------------------
	public static WebElement  FuelBackLimitOrganization (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_maxLimit']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  FuelBackPercentageForUser (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_trxLimit']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  ValidUntilFrom (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@id='orgs_form_validUntil']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  ValidUntilTo (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[8]/div[2]/div[4]/div[2]/div[1]/span[1]/div[1]/div[3]/input[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  Organizationsave (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------

	public static WebElement  Organizationsaveconfirmationmessage (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'New organization successfully')]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationEditconfirmationmessage (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//span[contains(text(),'Organization updated successfully')]"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	//////////////////////////Delete Organizaton//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement DeleteButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement OrgDeleteMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	/////////////////////////Filter Organizaton//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement FilterPart(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(@role,'button')]"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement OrgType(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_type']"));
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
	public static WebElement OrgName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='rc_select_29']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FilterApply(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	/////////////////////////View Organizaton//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement InformationTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-3']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement TransactionTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-2']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement StuffMembersTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-3']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement POSDevicesTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-6']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement EmployeesTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-4']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement CardStocksTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-5']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement BalanceHistoryTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-7']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	/////////////////////////Adding employee Organizaton//////////////////////////////////////
	//------------------------------------------------------------------------------------------

	public static WebElement SingleEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='Add New Employee']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement BulkOfEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='ant-drawer ant-drawer-right ant-drawer-open drawer-btn-component']//button[2]"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement CellPhoneEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FileEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@type='file']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement LastNameEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='update-user_firstName']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FirstNameEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='update-user_lastName']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement SaveEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		return element;
	}
	//------------------------------------------------------------------------------------------

	public static WebElement EmpAddingMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='User add to organization successfully']"));
		return element;
	}
	//------------------------------------------------------------------------------------------

	public static WebElement EmpBulkMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[normalize-space()='bulk Emplyee created successfully.']"));
		return element;
	}
}
