import org.openqa.selenium.By;
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

        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("AutoNormalOrg");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("Mansoura,Al-Galaa");
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
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("AutoTopup");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("Mansoura,Al-Galaa");
        OrganizationsPage.OrganizationFualAndTopupBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys("100");
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
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("AutoEnterprise");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("Mansoura,Al-Galaa");
        OrganizationsPage.OrganizationEnterpriseBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationBalanceUpdate(dashAdmin.driver).sendKeys("100");
        OrganizationsPage.OrganizationBalanceEnterpriseAttachment(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\spring-images-min.jpg");
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.Organizationsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New organization successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void CreateFuelBackOrg(){


        OrganizationsPage.OrganizationSettingsCollapse(dashAdmin.driver).click();
        OrganizationsPage.NewOrganizationFuelBack(dashAdmin.driver).click();
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("AutoFuelback");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("Mansoura,Al-Galaa");
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys("6000");;
        OrganizationsPage.FuelBackPercentageForUser(dashAdmin.driver).sendKeys("3");
        /////// Valid until/////////

        String fromDay = "25";
        String toDay= "31";
        OrganizationsPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(fromDay))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(toDay))  ele1.click();
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
