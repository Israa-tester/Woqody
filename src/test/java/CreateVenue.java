import Pages.LoginPage;
import Pages.VenuesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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

        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys("Map");
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueType(dashAdmin.driver).click();
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys("Map-Venue22");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys("Riyadh / الرياض");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys(Keys.DELETE);
        VenuesPage.NumberWorkingShifts(dashAdmin.driver).sendKeys("1");
        VenuesPage.WorkFrom(dashAdmin.driver).sendKeys("3:03 am");
        VenuesPage.WorkTo(dashAdmin.driver).sendKeys("3:30 pm");
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys("RBMA4070، 4070 عبدالله بن أبي المظفر، 8128، حي المعذر، Riyadh 12721, Saudi Arabia");
        VenuesPage.VenueLocation(dashAdmin.driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
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
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys("Map");
        Thread.sleep(2000);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.SelectOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueType(dashAdmin.driver).click();
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        VenuesPage.VenueType(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.VenueName(dashAdmin.driver).sendKeys("Map-Venue");
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(" الرياض");
        Thread.sleep(2000);
        VenuesPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CarModel(dashAdmin.driver).sendKeys("Toyta2000");
        VenuesPage.ManufactureName(dashAdmin.driver).sendKeys("Toyota");
        VenuesPage.ManufaturedYear(dashAdmin.driver).sendKeys("2020");
        VenuesPage.ManufaturedYear(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.PlateNumber(dashAdmin.driver).sendKeys("WWW - 444");
        VenuesPage.ChassisNumber(dashAdmin.driver).sendKeys("ASDER2345");
        VenuesPage.DeliveryFees(dashAdmin.driver).sendKeys("10");
        VenuesPage.TankCapacity(dashAdmin.driver).sendKeys("50");
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys("oils");
        Thread.sleep(2000);
        VenuesPage.TankProduct(dashAdmin.driver).sendKeys(Keys.ENTER);
        VenuesPage.CoverageArea(dashAdmin.driver).click();
        Thread.sleep(2000);
        dashAdmin.driver.findElement(By.xpath("//body/div/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        dashAdmin.driver.findElement(By.xpath("//body/div/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).sendKeys(Keys.ENTER);
        VenuesPage.Venuesave(dashAdmin.driver).click();
        VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.Venuesaveconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New venue created successfully";
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
