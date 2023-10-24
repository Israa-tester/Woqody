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
import java.util.List;

public class EditAdCampaign {

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
    public void EditAdCampaign() throws InterruptedException
    {
        // Click on Edit icon for special campaign
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.campaignName+"']//parent::tr//td[6]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Ads Campaign')])[1]")));
        action.moveToElement(elementEdit);
        action.click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        AdCampaignPage.CampaignName(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        AdCampaignPage.CampaignName(dashAdmin.driver).sendKeys(Keys.DELETE);
        AdCampaignPage.CampaignName(dashAdmin.driver).sendKeys(dashAdmin.campaignNameEdit);
        AdCampaignPage.OrgCampaign(dashAdmin.driver).sendKeys(dashAdmin.campaignOrgEdit);
        Thread.sleep(1000);
        WebElement org1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.campaignOrgEdit+"')]"));
        org1.click();
        /////// Valid until/////////
        AdCampaignPage.ValidForm(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath(dashAdmin.xpathMonthFualBack));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(dashAdmin.campaignValidUntilFromEdit))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(dashAdmin.campaignValidUntilToEdit))  ele1.click();
        }
        //////////////////////////////
        AdCampaignPage.CampaignSave(dashAdmin.driver).click();
        AdCampaignPage.CampaignEditMessage(dashAdmin.driver).getText();
        String actual  = AdCampaignPage.CampaignEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
