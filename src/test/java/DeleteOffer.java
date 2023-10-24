
import Pages.AdPage;
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DeleteOffer {
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
    public void DeleteNormalOffer() throws InterruptedException {
        // Click on Delete icon for special normal offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteNormalOffer +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OffersPage.DeleteButton(dashAdmin.driver).click();
        OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 1)
    public void DeleteWatchWinOffer() throws InterruptedException {
        // Click on Delete icon for special watchWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerWatchTitleEdit +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OffersPage.DeleteButton(dashAdmin.driver).click();
        OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 2)
    public void DeleteClickWinOffer() throws InterruptedException {

        // Click on Delete icon for special ClickWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.offerClickTitle +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OffersPage.DeleteButton(dashAdmin.driver).click();
        OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void CreateDownloadWinOffer() throws InterruptedException {

        // Click on Delete icon for special DownloadWin offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteDownloadOffer +"']//parent::tr//td[10]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OffersPage.DeleteButton(dashAdmin.driver).click();
        OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
        // Finish delete
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
