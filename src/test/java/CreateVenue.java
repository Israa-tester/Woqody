import Pages.VenuesPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CreateVenue {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewVenue(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VenuesPage.Venueslink(dashAdmin.driver).click();
        VenuesPage.NewVenueslink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void CreateNormalVenue() throws InterruptedException
    {
        VenuesPage.VenueType(dashAdmin.driver).sendKeys("Normal");
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(dashAdmin.venueOrgNormal);
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(dashAdmin.venueNormalName);
        VenuesPage.VenueCity(dashAdmin.driver).click();
        Thread.sleep(500);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.venueCity+"')]")).click();
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(dashAdmin.numberWorkingShifts);
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(dashAdmin.workFrom);
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(dashAdmin.workTo);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        ///////select special location from the map///////
        VenuesPage.VenueLocation(dashAdmin.driver).click();
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(" Khashm Al Aan, Riyadh Saudi Arabia");
        Thread.sleep(1000);
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(Keys.ENTER);
/////////////////////////////////////////////////////////////////////////////////
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New venue created successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void CreateDeliveryVenue() throws InterruptedException
    {
        Thread.sleep(1000);
        VenuesPage.VenueType(dashAdmin.driver).click();
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(dashAdmin.venueOrgDelivery);
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(dashAdmin.venueDeliveryName);
        VenuesPage.VenueCity(dashAdmin.driver).click();
        Thread.sleep(500);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.venueCity+"')]")).click();
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(dashAdmin.workFrom);
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(dashAdmin.workTo);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CarModel(dashAdmin.driver).sendKeys(dashAdmin.carModel);
        VenuesPage.ManufactureName(dashAdmin.driver).sendKeys(dashAdmin.manufactureName);
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(dashAdmin.manufacturedYear);
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys(dashAdmin.plateNumber);
        VenuesPage.ChassisNumber(dashAdmin.driver).sendKeys(dashAdmin.chassisNumber);
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(dashAdmin.DeliveryFees);
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(dashAdmin.tankCapacity);
        VenuesPage.TankProduct(dashAdmin.driver).click();
        Thread.sleep(1000);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.tankProduct+"')]")).click();
        //VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CoverageArea(dashAdmin.driver).click();
        Thread.sleep(1000);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.area1+"')]")).click();
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.area2+"')]")).click();
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New venue created successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 2)
    public void CreateFuelBackVenue() throws InterruptedException {
        VenuesPage.VenueType(dashAdmin.driver).click();
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(dashAdmin.venueOrgFuelBack);
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(dashAdmin.venueFuelBackName);
        VenuesPage.VenueCity(dashAdmin.driver).click();
        Thread.sleep(1000);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'" + dashAdmin.venueCity + "')]")).click();
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(dashAdmin.numberWorkingShifts);
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(dashAdmin.workFrom);
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(dashAdmin.workTo);
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        String actual = VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New venue created successfully";
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
