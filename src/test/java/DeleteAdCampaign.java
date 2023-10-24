import Pages.AdCampaignPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteAdCampaign {

    BeforeAndAfter dashAdmin;

    @BeforeMethod
    public void OpenCampaign() throws InterruptedException {
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement CampaignMenu = dashAdmin.driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[20]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        je.executeScript("arguments[0].click()", CampaignMenu);
        //////////////////////////////////////

        AdCampaignPage.AdCampaignLink(dashAdmin.driver).click();
        Thread.sleep(1000);

    }
    @Test(priority = 0)
    public void DeleteAdCampaign() throws InterruptedException
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.campaignNameEdit+"']//parent::tr//td[6]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(elementEdit);
        action.click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        AdCampaignPage.DeleteButton(dashAdmin.driver).click();
        String actual  = AdCampaignPage.CampaignDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
