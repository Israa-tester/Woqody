import Pages.LoginPage;
import Pages.VendorsPage;
import Pages.VenuesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DeleteVenue {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenVendorPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VenuesPage.Venueslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void DeleteNormalVendor() throws InterruptedException
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='dss']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        VenuesPage.DeleteButton(dashAdmin.driver).click();
        VenuesPage.VenueDeleteMessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.VenueDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void DeleteFualBackVendor() throws InterruptedException
    {
        // Click on edit icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='deliveryVenue']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        VenuesPage.DeleteButton(dashAdmin.driver).click();
        VenuesPage.VenueDeleteMessage(dashAdmin.driver).getText();
        String actual  = VenuesPage.VenueDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
