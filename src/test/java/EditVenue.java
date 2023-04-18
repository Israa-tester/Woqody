import Pages.VenuesPage;
import org.openqa.selenium.*;
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
        // Click on edit icon for special normal venue
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='venue test']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////

        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.VenueName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys("Venue-QC");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys("At Taif / الطائف");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys("H77W+29Q، شارع وادي مريخ (أم الذر)، الشروق، Ash Shorooq, Jeddah 23365, Saudi Arabia");
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(Keys.ENTER);
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
        // Click on edit icon for special delivery venue
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Map-delivery']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////

        VenuesPage.VenueName(dashAdmin.driver).sendKeys("SS");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(" Tabuk / تبوك");
        Thread.sleep(2000);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CarModel(dashAdmin.driver).sendKeys("S1");
        VenuesPage.ManufactureName(dashAdmin.driver).sendKeys("S2");
        VenuesPage.ManufaturedYear(dashAdmin.driver).sendKeys("2020");
        VenuesPage.ManufaturedYear(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys("S4");
        VenuesPage.ChassisNumber(dashAdmin.driver).sendKeys("S5");
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys("10");
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys("20");
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys("benzene 90");
        Thread.sleep(2000);
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.ENTER);
        /*VenuesPage.CoverageArea(dashAdmin.driver).click();
        Thread.sleep(2000);
        VenuesPage.CoverageArea(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New venue created successfully";
        Assert.assertEquals(actual, expected);*/
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
