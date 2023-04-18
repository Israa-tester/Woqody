import Pages.VendorsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class EditVendor {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditVendor(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VendorsPage.Vendorlink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void EditNormalVendor() throws InterruptedException
    {
        // Click on edit icon for special normal vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoNormalOrg']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.SelectVenue(dashAdmin.driver).clear();
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys("map-another");
        Thread.sleep(2000);
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys("vendorMap");
        VendorsPage.VendorSave(dashAdmin.driver).click();
        VendorsPage.VendorEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.VendorEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Vendor updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void EditFuelBackVendor() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='MapFuel']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys("map-another");
        Thread.sleep(2000);
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(Keys.ENTER);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys("FuelMap");
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys("600");
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys("1.5");
        /////// Valid until/////////
        String fromDay = "25";
        String toDay= "27";
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
        VendorsPage.VendorEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.VendorEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Vendor updated successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
