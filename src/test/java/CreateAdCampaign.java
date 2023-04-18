
import Pages.AdCampaignPage;
import Pages.LoginPage;
import Pages.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;

public class CreateAdCampaign {

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
    public void CreateAdCampaign() throws InterruptedException
    {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        jes.executeScript("arguments[0].scrollIntoView(true);",AdCampaignPage.CreateNewCampaign(dashAdmin.driver));
        jes.executeScript("arguments[0].click()",AdCampaignPage.CreateNewCampaign(dashAdmin.driver));
        AdCampaignPage.CampaignStatus(dashAdmin.driver).click();
        AdCampaignPage.CampaignName(dashAdmin.driver).sendKeys("AutoCampaign");
        AdCampaignPage.OrgCampaign(dashAdmin.driver).sendKeys("Automation Org");
        Thread.sleep(1000);
        AdCampaignPage.OrgCampaign(dashAdmin.driver).sendKeys(Keys.ENTER);
        /////// Valid until/////////
        String fromDay = "29";
        String toDay= "31";
        AdCampaignPage.ValidForm(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(fromDay))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(toDay))  ele1.click();
        }
        //////////////////////////////
        AdCampaignPage.CampaignSave(dashAdmin.driver).click();
        AdCampaignPage.CampaignConfirmationMessage(dashAdmin.driver).getText();
        String actual  = AdCampaignPage.CampaignConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Ad Campaign created successfully.";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
