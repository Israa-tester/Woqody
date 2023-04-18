import Pages.VendorsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class CreateVendor {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewVendor(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VendorsPage.Vendorlink(dashAdmin.driver).click();
        VendorsPage.NewVendorlink(dashAdmin.driver).click();
    }
    @Test(priority = 0)
    public void CreateNormalVendor() throws InterruptedException
    {
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys("Venue");
        Thread.sleep(2000);
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys("Testvendor");
        VendorsPage.VendorSave(dashAdmin.driver).click();
        VendorsPage.Vendorsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.Vendorsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New vendor created successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void CreateFuelBackVendor() throws InterruptedException
    {
        VendorsPage.VendorFualBack(dashAdmin.driver).click();
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys("Venue");
        Thread.sleep(2000);
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys("FuelBackvendor");
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys("6000");;
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys("3");
        /////// Valid until/////////
        String fromDay = "20";
        String toDay= "28";
        VendorsPage.VendorValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(fromDay))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(toDay))  ele1.click();
        }
        //////////////////////////////
        Thread.sleep(1000);
        VendorsPage.VendorSaveFuelBack(dashAdmin.driver).click();
        VendorsPage.Vendorsaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.Vendorsaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New vendor created successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
