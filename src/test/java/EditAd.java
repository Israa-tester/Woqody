import Pages.AdPage;
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


public class EditAd {

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
        // Click on Edit icon for special ad
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoAdEdit']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        AdPage.AdTitle(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        AdPage.AdTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        AdPage.AdTitle(dashAdmin.driver).sendKeys("AutoAdEdit1");
        AdPage.AdPlacement(dashAdmin.driver).sendKeys("Invoice");
        AdPage.AdPlacement(dashAdmin.driver).sendKeys(Keys.ENTER);
        AdPage.AdImage(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\spring.jpg");
        AdPage.AdSaveButton(dashAdmin.driver).click();
        AdPage.AdEditMessage(dashAdmin.driver).getText();
        String actual  = AdPage.AdEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "undefined updated successfully";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
