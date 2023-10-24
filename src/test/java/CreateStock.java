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
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();
        CardStockPage.NewCardStock(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateVehicleStock() throws InterruptedException
    {
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(dashAdmin.newVehicleStock);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(dashAdmin.OrgEnterpriseName);
        Thread.sleep(2000);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockEnableDaily(dashAdmin.driver).click();
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys(dashAdmin.stockDailyLimit);
        CardStockPage.StockTopupSchedulerEnable(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(dashAdmin.stockTopupAmount);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(dashAdmin.periodDaily);
        Thread.sleep(2000);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        //Choose the off days//////
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.stockOffDay1 + "']")).click();
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

        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(dashAdmin.newEmployeeStock);
        CardStockPage.StockType(dashAdmin.driver).click();
        dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Employee')]")).click();
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(dashAdmin.OrgEnterpriseName);
        Thread.sleep(2000);
        CardStockPage.CardStockOrg(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockEnableMonthly(dashAdmin.driver).click();
        Thread.sleep(1000);
        CardStockPage.StockMonthlyLimit(dashAdmin.driver).sendKeys(dashAdmin.stockWeeklyLimit);
        CardStockPage.StockTopupSchedulerEnable(dashAdmin.driver).click();
        CardStockPage.StockCeilingTopup(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(dashAdmin.stockTopupAmount);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).click();
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        CardStockPage.StocktopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.StockTopupWeeklyDay(dashAdmin.driver).sendKeys(dashAdmin.topupWeeklyDay);
        CardStockPage.StockTopupWeeklyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
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
