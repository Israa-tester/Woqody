import Pages.CardStockPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void EditVehicleStock() {
        // Click on Edit icon for special Stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newVehicleStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Cards Stock')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(dashAdmin.editVehicleStock);
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editStockDailyLimit));
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editStockTopupAmount));
        //Choose the off days//////
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.stockOffDay2 + "']")).click();
        CardStockPage.StockSave(dashAdmin.driver).click();
        CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Stock updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void EditEmployeeStock() throws InterruptedException {
        // Click on Edit icon for special Stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newEmployeeStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Cards Stock')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.CardStockTitle(dashAdmin.driver).sendKeys(dashAdmin.editEmployeeStock);
        CardStockPage.StockEnableDaily(dashAdmin.driver).click();
        CardStockPage.StockDailyLimit(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editStockDailyLimit));
        CardStockPage.StockMonthlyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        CardStockPage.StockMonthlyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        CardStockPage.StockMonthlyLimit(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editStockMonthlyLimit));
        CardStockPage.StockCeilingTopup(dashAdmin.driver).click();
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        CardStockPage.StocktopupAmount(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editStockTopupAmount));
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
