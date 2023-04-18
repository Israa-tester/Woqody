import Pages.CardStockPage;
import Pages.Cards;
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


public class TopUpCards extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void TopupVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='CardV3 - 353 - 1 - 3']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys("2.5");
        Cards.Topupbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void DeductVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='CardV3 - 353 - 1 - 3']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL, "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys("-2");
        Cards.Deductbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void TopupEmployeeCard() throws InterruptedException {
        // Click on topup icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='CE2 - 353 - 2 - 2']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys("2.5");
        Cards.Topupbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void DeductEmployeeCard() throws InterruptedException {
        // Click on topup icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='CE2 - 353 - 2 - 2']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL, "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys("-2");
        Cards.Deductbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        Assert.assertEquals(actual, expected);
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
