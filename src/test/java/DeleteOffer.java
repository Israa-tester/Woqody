
import Pages.AdPage;
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[18]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        OffersPage.OffersLink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void DeleteNormalOffer() throws InterruptedException {
        // Click on Delete icon for special normal offer
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoNormal Edit']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoWatchWin Edit']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoClickWin Edit']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoDownloadWinEdit']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OffersPage.DeleteButton(dashAdmin.driver).click();
        OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
