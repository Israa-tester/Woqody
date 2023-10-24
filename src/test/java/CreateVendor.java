import Pages.VendorsPage;
import org.openqa.selenium.By;
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
        Thread.sleep(1000);
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(dashAdmin.venueOfVendor);
        Thread.sleep(1000);
        WebElement venue = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.venueOfVendor+"')]"));
        venue.click();
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(dashAdmin.vendorName);
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
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(dashAdmin.venueOfVendorFuelBack);
        Thread.sleep(1000);
        WebElement venue = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.venueOfVendorFuelBack+"')]"));
        venue.click();
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(dashAdmin.vendorNameFuelBack);
        VendorsPage.VendorPaymentMethod(dashAdmin.driver).click();
        WebElement paymentMethod = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space()='Mada']"));
        paymentMethod.click();
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(dashAdmin.venueFuelBackLimit);;
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(dashAdmin.venueFuelBackPercentageForUser);
        /////// Valid until/////////
        VendorsPage.VendorValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(dashAdmin.venuefromDayFualBack))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(dashAdmin.venuetoDayFualBack))  ele1.click();
        }
        //////////////////////////////
        Thread.sleep(1000);
        VendorsPage.VendorSave(dashAdmin.driver).click();
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
