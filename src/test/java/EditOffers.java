
import Pages.OffersPage;
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


public class EditOffers {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOfferPage(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[18]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        OffersPage.OffersLink(dashAdmin.driver).click();


    }

    @Test(priority = 0)
    public void EditNormalOffer() throws InterruptedException {
        // Click on Edit icon for special normal offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoNormal']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(" Edit");
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement catBsnk= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Bsnk')]"));
        jes.executeScript("arguments[0].click()", catBsnk);
        WebElement catCafe= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Café')]"));
        jes.executeScript("arguments[0].click()",catCafe);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        WebElement orgCach= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Win Offer')]"));
        jes.executeScript("arguments[0].click()",orgCach);
        Thread.sleep(1000);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//div[contains(@title,'win ➜ Win Offer')]//p[contains(text(),'Win Offer')]"));
        jes.executeScript("arguments[0].click()", ven);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(" Edit test");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }
    @Test(priority = 1)
    public void EditWatchWinOffer() {
        // Click on Edit icon for special WatchWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='ttttt']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("AutoWatchWin");
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("33");
        OffersPage.offerCategory(dashAdmin.driver).click();
        OffersPage.OfferVideo(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\Moon.mp4");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(" Edit test");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessageWatch(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessageWatch(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));


    }
    @Test(priority = 2)
    public void EditClickWinOffer() {
        // Click on Edit icon for special ClickWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoClickWin']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys(" Edit");
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("1");
        OffersPage.offerCategory(dashAdmin.driver).click();
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys("https://www.yahoo.com/");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys(Keys.DELETE);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Aloo Click Win Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessageClick(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessageClick(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }
    @Test(priority = 3)
    public void EditDownloadWinOffer(){
        // Click on Edit icon for special DownloadWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoDownloadWin']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("Edit");
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("4");
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.CONTROL +"a");
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys(Keys.CONTROL);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys("https://www.masrawy.com/");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Download Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferEditMessageDownload(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferEditMessageDownload(dashAdmin.driver).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("updated successfully"));

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
