import Pages.VendorsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DeleteVendor {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenVendorPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VendorsPage.Vendorlink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void DeleteNormalVendor()
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='123']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.DeleteButton(dashAdmin.driver).click();
        VendorsPage.VendorDeleteMessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.VendorDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void DeleteFualBackVendor()
    {
        // Click on edit icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='FuelMap']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        VendorsPage.DeleteButton(dashAdmin.driver).click();
        VendorsPage.VendorDeleteMessage(dashAdmin.driver).getText();
        String actual  = VendorsPage.VendorDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
