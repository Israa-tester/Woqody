
import Pages.OffersPage;
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


public class EditOffers {
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
        OffersPage.OffersLink(dashAdmin.driver).click();



    }

    @Test(priority = 0)
    public void EditNormalOffer() throws InterruptedException {
        // Click on Edit icon for special normal offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerNormalTitle +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Offer')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerNormalTitleEdit);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrgEdit+"')]"));
        org.click();
        Thread.sleep(1000);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenueEdit1+"']"));
        ven.click();
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescriptionEdit);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }
    @Test(priority = 1)
    public void EditWatchWinOffer() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerWatchTitle +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Offer')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerWatchTitleEdit);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrgEdit+"')]"));
        org.click();
        Thread.sleep(1000);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenueEdit1+"']"));
        ven.click();
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescriptionEdit);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));


    }
    @Test(priority = 2)
    public void EditClickWinOffer() throws InterruptedException{
        // Click on Edit icon for special ClickWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerClickTitle +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Offer')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(dashAdmin.offerCashBackAmountEdit);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenueEdit2+"']"));
        ven.click();
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(dashAdmin.actionLinkClickEdit);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }
    @Test(priority = 3)
    public void EditDownloadWinOffer() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerDownloadTitle +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Offer')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerDownloadTitleEdit);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrgEdit+"')]"));
        org.click();
        Thread.sleep(1000);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenueEdit1+"']"));
        ven.click();
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(dashAdmin.actionLinkDownloadEdit);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescriptionEdit);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
