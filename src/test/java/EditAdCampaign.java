import Pages.AdCampaignPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EditAdCampaign {

    BeforeAndAfter dashAdmin;

    @BeforeMethod
    public void OpenCampaign(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement CampaignMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[19]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        CampaignMenu.click();
        //////////////////////////////////////

        AdCampaignPage.AdCampaignLink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void EditAdCampaign() throws InterruptedException
    {
        // Click on Edit icon for special campaign
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AddQC']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        AdCampaignPage.CampaignStatus(dashAdmin.driver).click();
        AdCampaignPage.CampaignName(dashAdmin.driver).sendKeys("33");
        AdCampaignPage.ValidForm(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        AdCampaignPage.ValidForm(dashAdmin.driver).sendKeys(Keys.DELETE);
        AdCampaignPage.CampaignvalidUntilWeek(dashAdmin.driver).click();
        AdCampaignPage.CampaignSave(dashAdmin.driver).click();
        AdCampaignPage.CampaignEditMessage(dashAdmin.driver).getText();
        String actual  = AdCampaignPage.CampaignEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "AddQC33 updated successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
