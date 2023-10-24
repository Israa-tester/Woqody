
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CreateOffers {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewOffer(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body[1]/div[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[19]/div[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        OffersPage.OffersLink(dashAdmin.driver).click();
        je.executeScript("arguments[0].scrollIntoView(true);", OffersPage.CreateNewOffer(dashAdmin.driver));
        je.executeScript("arguments[0].click()",OffersPage.CreateNewOffer(dashAdmin.driver));
    }

    @Test(priority = 0)
    public void CreateNormalOffer() throws InterruptedException {

        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerNormalTitle);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrg+"')]"));
        org.click();
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenue+"']"));
        ven.click();
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescription);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 1)
    public void CreateWatchWinOffer() throws InterruptedException {

        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerWatchTitle);
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement watch= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'Watch & Win')]"));
        watch.click();
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(dashAdmin.offerCashBackAmount);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrg+"')]"));
        org.click();
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenue+"']"));
        ven.click();
        OffersPage.OfferVideo(dashAdmin.driver).sendKeys(dashAdmin.fileWatchOffer);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescription);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);


    }
    @Test(priority = 2)
    public void CreateClickWinOffer() throws InterruptedException {

        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerClickTitle);
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement click= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'Click & Win')]"));
        click.click();
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(dashAdmin.offerCashBackAmount);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrg+"')]"));
        org.click();
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenue+"']"));
        ven.click();
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(dashAdmin.actionLinkClick);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescription);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void CreateDownloadWinOffer() throws InterruptedException {

        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(dashAdmin.offerDownloadTitle);
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement click= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'Download & Win')]"));
        click.click();
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(dashAdmin.offerCashBackAmount);
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerCat+"')]"));
        cat.click();
        OffersPage.OfferOrg(dashAdmin.driver).click();
        Thread.sleep(1000);
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.offerOrg+"')]"));
        org.click();
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='"+dashAdmin.offerVenue+"']"));
        ven.click();
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(dashAdmin.actionLinkDownload);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(dashAdmin.offerDescription);
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
