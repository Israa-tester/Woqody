package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrganizationsPage 
{
	String xpathMonthFualBack = "(//table[@class='ant-picker-content'])[1]//td";
	private static WebElement element = null;
	//-----------------------------------------------------------------------------------	
	public static WebElement  Organizationslink (WebDriver driver)

	{
		element = driver.findElement(By.xpath("//a[@href='/organizations']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationslink (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationSettingsCollapse (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//div[@class='ant-collapse ant-collapse-icon-position-left']//div[@role='button']"));
		
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationstopup (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("(//button[@role='switch'])[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationFuelBack (WebDriver driver ) 

	{
		element = driver.findElement(By.id("orgs_form_cashBackIsActive"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  NewOrganizationEnterprise (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("(//button[@role='switch'])[3]"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  Organizationname (WebDriver driver ) 

	{
		element = driver.findElement(By.id("orgs_form_name"));
		return element;		
	}
	
	//-----------------------------------------------------------------------------------------
	public static WebElement  Organizationaddress (WebDriver driver ) 

	{
		element = driver.findElement(By.id("orgs_form_address"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationEnterpriseBalance (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("(//div[normalize-space()=\"Enterprise organization's Balance\"])[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationEditEnterpriseBalance (WebDriver driver )

	{
		element = driver.findElement(By.xpath("//body/div/div[@class='ant-modal-root']/div[@role='dialog']/div[@role='document']/div[@class='ant-modal-content']/div[@class='ant-modal-body']/form[@class='ant-legacy-form ant-legacy-form-horizontal']/div[@role='tablist']/div[2]/div[1]"));
		return element;
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  OrganizationBalanceUpdate (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@role='spinbutton']"));
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
		element = driver.findElement(By.xpath("//div[contains(text(),'Fuel Back and Top-Up balance')]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	
	public static WebElement  OrganizationChargeLimit (WebDriver driver ) 

	{
		element = driver.findElement(By.id("orgs_form_topupChargeLimit"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	
	//-------------FuelBack Configuration------------------------------
	public static WebElement  FuelBackLimitOrganization (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("(//input[@placeholder='0'])[1]"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  FuelBackPercentageForUser (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@placeholder='0%']"));
		return element;		
	}
	//-----------------------------------------------------------------------------------------
	public static WebElement  ValidUntilFrom (WebDriver driver ) 

	{
		element = driver.findElement(By.xpath("//input[@placeholder='From']"));
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
		element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-dangerous']"));
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
		element = driver.findElement(By.xpath("(//div[@class='ant-tabs-tab'])[1]"));
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
		element = driver.findElement(By.xpath("//div[@class='ant-modal-root']//button[2]//span[1]"));
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
		element = driver.findElement(By.xpath("//input[@id='update-user_lastName']"));
		return element;
	}
	//------------------------------------------------------------------------------------------
	public static WebElement FirstNameEmployee(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='update-user_firstName']"));
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
