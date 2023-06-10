import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.OrganizationsPage;
import java.util.List;


public class CreateOrg {
    BeforeAndAfter dashAdmin;

    @BeforeMethod
    public void CreateNewOrg(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
        OrganizationsPage.NewOrganizationslink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void CreateNormalOrg(){

        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.OrgNormalName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.OrgAddress);
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New organization successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 1)
    public void CreateTopUpOrg(){


        OrganizationsPage.OrganizationSettingsCollapse(dashAdmin.driver).click();
        OrganizationsPage.NewOrganizationstopup(dashAdmin.driver).click();
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.OrgTopupName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.OrgAddress);
        OrganizationsPage.OrganizationFualAndTopupBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.OrganizationChargeLimitTopup));
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New organization successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 2)
    public void CreateEnterpriseOrg() throws InterruptedException {

        OrganizationsPage.OrganizationSettingsCollapse(dashAdmin.driver).click();
        OrganizationsPage.NewOrganizationEnterprise(dashAdmin.driver).click();
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.OrgEnterpriseName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.OrgAddress);
        OrganizationsPage.OrganizationEnterpriseBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationBalanceUpdate(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.OrganizationBalanceUpdateEnterprise));
        OrganizationsPage.OrganizationBalanceEnterpriseAttachment(dashAdmin.driver).sendKeys(dashAdmin.OrganizationBalanceEnterpriseAttachment);
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New organization successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void CreateFuelBackOrg(){
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        jes.executeScript("arguments[0].click()", OrganizationsPage.OrganizationSettingsCollapse(dashAdmin.driver));
        //OrganizationsPage.OrganizationSettingsCollapse(dashAdmin.driver).click();
        OrganizationsPage.NewOrganizationFuelBack(dashAdmin.driver).click();
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.OrgFuelBackName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.OrgAddress);
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.FuelBackLimit));
        OrganizationsPage.FuelBackPercentageForUser(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.FuelBackPercentageForUser));
        /////// Valid until/////////

        OrganizationsPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath( dashAdmin.xpathMonthFualBack));
        for(WebElement ele1:allDatesFrom){
            String dt1= ele1.getText();
            if (dt1.equals(dashAdmin.fromDayFualBack))  ele1.click();
        }
        for(WebElement ele2:allDatesFrom){
            String dt2= ele2.getText();
            if (dt2.equals(dashAdmin.toDayFualBack))  ele2.click();
        }
        //////////////////////////////
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New organization successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
