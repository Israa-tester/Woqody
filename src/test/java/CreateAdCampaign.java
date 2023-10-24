
import Pages.AdCampaignPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class CreateAdCampaign extends BeforeAndAfter{

    //public static BeforeAndAfter dashAdmin;

    @BeforeTest
    public void OpenCampaign(){
        //dashAdmin= new BeforeAndAfter();
       OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement CampaignMenu = driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[20]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        je.executeScript("arguments[0].click()", CampaignMenu);
        //////////////////////////////////////

        AdCampaignPage.AdCampaignLink(driver).click();

    }
    @Test
    public void CreateCampaign() throws InterruptedException
    {
        Thread.sleep(1000);
        AdCampaignPage.CreateNewCampaign(driver).click();
        AdCampaignPage.CampaignStatus(driver).click();
        AdCampaignPage.CampaignName(driver).sendKeys(campaignName);
        AdCampaignPage.OrgCampaign(driver).sendKeys(campaignOrg);
        Thread.sleep(1000);
        WebElement org1 = driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+campaignOrg+"')]"));
        org1.click();
        /////// Valid until/////////
        AdCampaignPage.ValidForm(driver).click();
        List<WebElement> allDatesFrom= driver.findElements(By.xpath(xpathMonthFualBack));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(campaignValidUntilFrom))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(campaignValidUntilTo))  ele1.click();
        }
        //////////////////////////////
        AdCampaignPage.CampaignSave(driver).click();
        AdCampaignPage.CampaignConfirmationMessage(driver).getText();
        String actual  = AdCampaignPage.CampaignConfirmationMessage(driver).getText();
        System.out.println(actual);
        String expected = "New Campaign created successfully";
        Assert.assertEquals(actual, expected);

    }



    @AfterTest
    public void CloseBrowser(){
        CloseDashboard();
    }
}
