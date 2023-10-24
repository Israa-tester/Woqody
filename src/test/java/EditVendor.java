import Pages.VendorsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.vendorName +"']//parent::tr//td[12]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Vendor')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(dashAdmin.vendorNameEdit);
        VendorsPage.VendorPaymentMethod(dashAdmin.driver).click();
        dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space()='Nearpay (SPOS)']")).click();
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.vendorNameFuelBack +"']//parent::tr//td[12]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Vendor')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.SelectVenue(dashAdmin.driver).sendKeys(dashAdmin.venueOfVendorEdit);
        Thread.sleep(1000);
        WebElement venue = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.venueOfVendorEdit+"')]"));
        venue.click();
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.VendorName(dashAdmin.driver).sendKeys(dashAdmin.vendorNameFuelBackEdit);
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.FuelBackLimitperVendor(dashAdmin.driver).sendKeys(dashAdmin.vendorFuelBackLimitEdit);
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(Keys.DELETE);
        VendorsPage.FuelBackPercentageforEndUser(dashAdmin.driver).sendKeys(dashAdmin.vendorFuelBackPercentageForUserEdit);
        VendorsPage.VendorSave(dashAdmin.driver).click();
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
