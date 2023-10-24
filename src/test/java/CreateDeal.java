
import Pages.DealssPage;
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class CreateDeal {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOfferPage(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[19]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        DealssPage.DealsLink(dashAdmin.driver).click();
        je.executeScript("arguments[0].scrollIntoView(true);", DealssPage.CreateNewDeal(dashAdmin.driver));
        je.executeScript("arguments[0].click()",DealssPage.CreateNewDeal(dashAdmin.driver));
    }

    @Test(priority = 0)
    public void CreateNewDeal() throws InterruptedException {

        DealssPage.DealTitle(dashAdmin.driver).sendKeys(dashAdmin.dealTitle);
        DealssPage.DealArabicTiltle(dashAdmin.driver).sendKeys(dashAdmin.dealArabicTitle);
        DealssPage.DealGift(dashAdmin.driver).sendKeys(dashAdmin.dealGift);
        WebElement gift= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealGift+"')]"));
        gift.click();
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(dashAdmin.dealAmount);
        DealssPage.DealOrganization(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealOrg1+"')]"));
        org1.click();
        WebElement org2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealOrg2+"')]"));
        org2.click();
        DealssPage.DealVenues(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement venue1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.dealVenue1+"']"));
        venue1.click();
        WebElement venue2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.dealVenue2+"']"));
        venue2.click();
        DealssPage.DealProducts(dashAdmin.driver).click();
        WebElement product1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealProduct1+"')]"));
        product1.click();
        WebElement product2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealProduct2+"')]"));
        product2.click();
        DealssPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath( dashAdmin.xpathMonthFualBack));
        for(WebElement ele1:allDatesFrom){
            String dt1= ele1.getText();
            if (dt1.equals(dashAdmin.dealValidUntilFrom))  ele1.click();
        }
        for(WebElement ele2:allDatesFrom){
            String dt2= ele2.getText();
            if (dt2.equals(dashAdmin.dealValidUntilTo))  ele2.click();
        }
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys(dashAdmin.dealCongMessage);
        DealssPage.ArabicCongratulationMessage(dashAdmin.driver).sendKeys(dashAdmin.dealArabicCongMessage);
        DealssPage.DealSave(dashAdmin.driver).click();
        DealssPage.AddConfirmMessage(dashAdmin.driver).getText();
        String actual  = DealssPage.AddConfirmMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New deal created successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
