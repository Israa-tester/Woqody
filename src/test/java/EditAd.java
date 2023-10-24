import Pages.AdPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;




public class EditAd{

    BeforeAndAfter dashAdmin;

    @BeforeTest
    public void OpenAd() throws InterruptedException {
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////
        WebElement CampaignMenu = dashAdmin.driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[20]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",CampaignMenu);
        je.executeScript("arguments[0].click()", CampaignMenu);
        //////////////////////////////////////

        AdPage.AdLink(dashAdmin.driver).click();
        Thread.sleep(1000);

    }
    @Test
    public void EditAd() throws InterruptedException {
        // Click on Edit icon for special ad
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.adTitle+"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Ad')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        AdPage.AdTitle(dashAdmin.driver).sendKeys(Keys.CONTROL+ "a");
        AdPage.AdTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        AdPage.AdTitle(dashAdmin.driver).sendKeys(dashAdmin.adTitleEdit);
        AdPage.AdPlacement(dashAdmin.driver).click();
        WebElement place = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adPlacementEdit+"')]"));
        place.click();
        AdPage.AdImage(dashAdmin.driver).sendKeys(dashAdmin.adsImage);
        AdPage.AdOrg(dashAdmin.driver).sendKeys(dashAdmin.adOrgEdit);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adOrgEdit+"')]"));
        org.click();
        AdPage.AdCampaign(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement camp = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.adCampaignEdit+"')]"));
        camp.click();
        AdPage.AdSaveButton(dashAdmin.driver).click();
        AdPage.AdEditMessage(dashAdmin.driver).getText();
        String actual  = AdPage.AdEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }



    @AfterTest
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
