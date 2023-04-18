
import Pages.VenuesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterVenue {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenVenuePage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VenuesPage.Venueslink(dashAdmin.driver).click();
        VenuesPage.FilterPart(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void FilterNormalVenue() throws InterruptedException {

        VenuesPage.CreationDateFrom(dashAdmin.driver).sendKeys("2023-02-20");
        VenuesPage.CreationDateFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CreationDateTo(dashAdmin.driver).sendKeys("2023-02-24");
        VenuesPage.CreationDateTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CityVenue(dashAdmin.driver).sendKeys("الرياض");
        Thread.sleep(1000);
        VenuesPage.CityVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueTypeFilter(dashAdmin.driver).click();
        VenuesPage.VenueTypeFilter(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.OrgName(dashAdmin.driver).sendKeys("shellout badr");
        VenuesPage.OrgName(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueNameFilter(dashAdmin.driver).sendKeys("VenueB");
        VenuesPage.VenueNameFilter(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueCodeFilter(dashAdmin.driver).sendKeys("150000");
        VenuesPage.FilterApply(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='VenueB']")).isDisplayed());
    }

    @Test(priority = 1)
    public void FilterDeliveryVenue() throws InterruptedException {

        VenuesPage.CreationDateFrom(dashAdmin.driver).sendKeys("2023-02-20");
        VenuesPage.CreationDateFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CreationDateTo(dashAdmin.driver).sendKeys("2023-02-24");
        VenuesPage.CreationDateTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CityVenue(dashAdmin.driver).sendKeys("الرياض");
        Thread.sleep(1000);
        VenuesPage.CityVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueTypeFilter(dashAdmin.driver).click();
        VenuesPage.VenueTypeFilter(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.OrgName(dashAdmin.driver).sendKeys("shellout badr");
        VenuesPage.OrgName(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueNameFilter(dashAdmin.driver).sendKeys("VenueB");
        VenuesPage.VenueNameFilter(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueCodeFilter(dashAdmin.driver).sendKeys("150000");
        VenuesPage.FilterApply(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='VenueB']")).isDisplayed());
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
