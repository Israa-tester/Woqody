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
        WebElement CampaignMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[19]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        CampaignMenu.click();
        //////////////////////////////////////

        AdPage.AdLink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateAd()
    {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        jes.executeScript("arguments[0].scrollIntoView(true);",AdPage.CreateNewAd(dashAdmin.driver));
        jes.executeScript("arguments[0].click()",AdPage.CreateNewAd(dashAdmin.driver));
        AdPage.AdTitle(dashAdmin.driver).sendKeys("AutomateAd");
        AdPage.AdPlacement(dashAdmin.driver).sendKeys("Main Page");
        AdPage.AdPlacement(dashAdmin.driver).sendKeys(Keys.ENTER);
        AdPage.AdImage(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\spring.jpg");
        AdPage.AdOrg(dashAdmin.driver).sendKeys("regression test");
        AdPage.AdOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        AdPage.AdCampaign(dashAdmin.driver).sendKeys("test");
        AdPage.AdCampaign(dashAdmin.driver).sendKeys(Keys.ENTER);
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
