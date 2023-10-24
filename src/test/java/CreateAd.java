import Pages.AdPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAd {

    BeforeAndAfter dashAdmin;

    @BeforeMethod
    public void OpenAd(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////
        WebElement CampaignMenu = dashAdmin.driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[20]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        je.executeScript("arguments[0].click()", CampaignMenu);
        //////////////////////////////////////

        AdPage.AdLink(dashAdmin.driver).click();
        dashAdmin.driver.navigate().refresh();

    }
    @Test(priority = 0)
    public void CreateAd() throws InterruptedException {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        jes.executeScript("arguments[0].scrollIntoView(true);",AdPage.CreateNewAd(dashAdmin.driver));
        jes.executeScript("arguments[0].click()",AdPage.CreateNewAd(dashAdmin.driver));
        AdPage.AdTitle(dashAdmin.driver).sendKeys(dashAdmin.adTitle);
        AdPage.AdPlacement(dashAdmin.driver).click();
        WebElement place = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adPlacement+"')]"));
        place.click();
        AdPage.AdImage(dashAdmin.driver).sendKeys(dashAdmin.adsImage);
        AdPage.AdOrg(dashAdmin.driver).sendKeys(dashAdmin.adOrg);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adOrg+"')]"));
        org.click();
        AdPage.AdCampaign(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement camp = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adCampaign+"')]"));
        camp.click();
        AdPage.AdSaveButton(dashAdmin.driver).click();
        AdPage.AdConfirmationMessage(dashAdmin.driver).getText();
        String actual  = AdPage.AdConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New AD created successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
