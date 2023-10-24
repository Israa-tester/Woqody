
import Pages.DealssPage;
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


public class EditDeal {
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
    }

    @Test(priority = 0)
    public void EditDeal() throws InterruptedException {

        // Click on Edit icon for special deal
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.dealTitle+"']//parent::tr//td[9]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Deal')])[1]")));
        action.moveToElement(elementEdit);
        action.click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        DealssPage.DealTitle(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        DealssPage.DealTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        DealssPage.DealTitle(dashAdmin.driver).sendKeys(dashAdmin.dealTitleEdit);
        DealssPage.DealArabicTiltle(dashAdmin.driver).sendKeys(dashAdmin.dealArabicTitleEdit);
        DealssPage.DealGift(dashAdmin.driver).sendKeys(dashAdmin.dealGiftEdit);
        WebElement gift= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealGiftEdit+"')]"));
        gift.click();
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(dashAdmin.dealAmountEdit);
        DealssPage.DealAllVenue(dashAdmin.driver).click();
        DealssPage.DealOrganization(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealOrg1+"')]"));
        org1.click();
        WebElement org2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealOrg2Edit+"')]"));
        org2.click();
        Thread.sleep(1000);
        DealssPage.DealVenues(dashAdmin.driver).click();
        //Thread.sleep(1000);
        WebElement venue2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.dealVenue2Edit+"']"));
        venue2.click();
        DealssPage.DealProducts(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement product1 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealProduct1Edit+"')]"));
        product1.click();
        WebElement product2 = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.dealProduct1+"')]"));
        product2.click();
        DealssPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath(dashAdmin.xpathMonthFualBack));
        for(WebElement ele1:allDatesFrom){
            String dt1= ele1.getText();
            if (dt1.equals(dashAdmin.dealValidUntilFromEdit))  ele1.click();
        }
        for(WebElement ele2:allDatesFrom){
            String dt2= ele2.getText();
            if (dt2.equals(dashAdmin.dealValidUntilToEdit))  ele2.click();
        }
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys(Keys.DELETE);
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys(dashAdmin.dealCongMessageEdit);
        DealssPage.ArabicCongratulationMessage(dashAdmin.driver).sendKeys(dashAdmin.dealArabicCongMessageEdit);
        DealssPage.DealSave(dashAdmin.driver).click();
        DealssPage.EditConfirmMessage(dashAdmin.driver).getText();
        String actual  = DealssPage.EditConfirmMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
