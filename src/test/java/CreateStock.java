import Pages.CardStockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateStock {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewStock(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();
        CardStockPage.NewCardStock(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateVehicleStock() throws InterruptedException
    {
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys("AutoVehicleStock");
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys("Yaso");
        Thread.sleep(2000);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockEnableDaily(dashAdmin.driver).click();
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys("10");
        CardStockPage.StockTopupSchedulerEnable(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys("10");
        CardStockPage.StocktopupPeriod(dashAdmin.driver).click();
        Thread.sleep(2000);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockOffDayMonday(dashAdmin.driver).click();
        CardStockPage.StockSave(dashAdmin.driver).click();
        CardStockPage.StockConfirmationMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New stock created successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void CreateEmployeeStock() throws InterruptedException
    {

        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys("AutoEmployeeeStock");
        CardStockPage.StockType(dashAdmin.driver).sendKeys("Employee");
        CardStockPage.StockType(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        CardStockPage.StockType(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys("Automation Org");
        Thread.sleep(2000);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
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
        CardStockPage.StockConfirmationMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New stock created successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
