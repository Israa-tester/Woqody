import Pages.CardStockPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class EditStock {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditTheStock(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void EditVehicleStock() throws InterruptedException
    {
        // Click on edit icon for special vehicle stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoVehicle - 346 - 1']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys("V1");
        CardStockPage.StockEnableDaily(dashAdmin.driver).click();
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys("5");
        CardStockPage.StockTopupSchedulerEnable(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys("3");
        CardStockPage.StocktopupPeriod(dashAdmin.driver).click();
        Thread.sleep(2000);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockOffDayMonday(dashAdmin.driver).click();
        CardStockPage.StockSave(dashAdmin.driver).click();
        CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Stock updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void CreateEmployeeStock() throws InterruptedException
    {
        // Click on edit icon for special employee stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoEmployee - 346 - 2']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(Keys.DELETE);
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys("EmployeeAutoS");
        CardStockPage.StockEnableMonthly(dashAdmin.driver).click();
        CardStockPage.StockMonthlyLimit(dashAdmin.driver).sendKeys("100");
        CardStockPage.StockTopupSchedulerEnable(dashAdmin.driver).click();
        CardStockPage.StockCeilingTopup(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys("10");
        CardStockPage.StocktopupPeriod(dashAdmin.driver).click();
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockTopupWeeklyDay(dashAdmin.driver).click();
        CardStockPage.StockTopupWeeklyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockOffDayMonday(dashAdmin.driver).click();
        CardStockPage.StockSave(dashAdmin.driver).click();
        CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Stock updated successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
