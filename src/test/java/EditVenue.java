import Pages.VenuesPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class EditVenue {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditVenue(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VenuesPage.Venueslink(dashAdmin.driver).click();

    }

    @Test(priority = 0)
    public void EditNormalVenue() throws InterruptedException
    {
        // Click on Edit icon for special Normal venue
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.venueNormalName +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////

        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys("Venue-QC");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys("At Taif / الطائف");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "venue updated successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void EditDeliveryVenue() throws InterruptedException
    {
        // Click on Edit icon for special delivery venue
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.venueDeliveryName +"']//parent::tr//td[12]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Venue')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////

        VenuesPage.VenueName(dashAdmin.driver).sendKeys(dashAdmin.venueNameEditD);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'" + dashAdmin.venueCityEdit + "')]")).click();
        VenuesPage.CarModel(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        VenuesPage.CarModel(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.CarModel(dashAdmin.driver).sendKeys(dashAdmin.carModelEdit);
        VenuesPage.ManufactureName(dashAdmin.driver).sendKeys(dashAdmin.manufactureNameEdit);
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(dashAdmin.manufacturedYearEdit);
        VenuesPage.ManufacturedYear(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys(dashAdmin.plateNumberEdit);
        VenuesPage.ChassisNumber(dashAdmin.driver).sendKeys(dashAdmin.chassisNumberEdit);
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(dashAdmin.deliveryFeesEdit);
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(dashAdmin.tankCapacityEdit);
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(dashAdmin.tankProductEdit);
        Thread.sleep(2000);
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CoverageArea(dashAdmin.driver).click();
        Thread.sleep(2000);
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.area1+"')]")).click();
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "venue updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void EditFuelBackVenue() throws InterruptedException {

        // Click on Edit icon for special fuelBack venue
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='" + dashAdmin.venueFuelBackName + "']//parent::tr//td[12]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Venue')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(500);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(dashAdmin.venueFuelBackEditName);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(dashAdmin.numberWorkingShiftsEdit);
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.VenueEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "venue updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
