
import Pages.OrganizationsPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FilterOrgs extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
        OrganizationsPage.FilterPart(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void FilterNormalOrg()
    {
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys("20-02-2023");
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys("24-02-2023");
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.OrgType(dashAdmin.driver).click();
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.FilterApply(dashAdmin.driver).click();
        String actual  = dashAdmin.driver.findElement(By.xpath("//td[.='NormalQQ']")).getText();
        System.out.println(actual);
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='NormalQQ']")).isDisplayed());
    }

    @Test(priority = 1)
    public void FilterEnterpriseOrg()
    {
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys("20-01-2023");
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys("24-01-2023");
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.OrgType(dashAdmin.driver).click();
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.FilterApply(dashAdmin.driver).click();
        String actual  = dashAdmin.driver.findElement(By.xpath("//td[.='test']")).getText();
        System.out.println(actual);
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='test']")).isDisplayed());
    }

    @Test(priority = 2)
    public void FilterFuelBackOrg()
    {
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys("15-01-2023");
        OrganizationsPage.CreationDateFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys("15-02-2023");
        OrganizationsPage.CreationDateTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.OrgType(dashAdmin.driver).click();
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        OrganizationsPage.OrgType(dashAdmin.driver).sendKeys(Keys.ENTER);
        OrganizationsPage.FilterApply(dashAdmin.driver).click();
        WebElement actual  = dashAdmin.driver.findElement(By.xpath("//td[.='الواقواق']"));
        Assert.assertTrue(actual.isDisplayed());
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
