import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBulkOfCards {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewCard(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        Cards.BulkOfCardsLink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateBulkVehicleCard() throws InterruptedException
    {
        Cards.CardAmount(dashAdmin.driver).sendKeys("2");
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys("2");
        Cards.CardStock(dashAdmin.driver).sendKeys("AutoVehicle");
        Thread.sleep(2000);
        Cards.CardStock(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardCurrency(dashAdmin.driver).sendKeys("Saudi");
        Cards.CardCurrency(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.BulkEnableLimit(dashAdmin.driver).click();
        Cards.CardMinLimit(dashAdmin.driver).sendKeys("3");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys("11");
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys("10");
        Cards.CardtopupPeriod(dashAdmin.driver).click();
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardTopupWeeklyDay(dashAdmin.driver).click();
        Cards.CardTopupWeeklyDay(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        Cards.CardTopupWeeklyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardSave(dashAdmin.driver).click();
        Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New card(s) created successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void CreateEmployeeCard() throws InterruptedException
    {
        Cards.CardType(dashAdmin.driver).sendKeys("Employee");
        Cards.CardType(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        Cards.CardType(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardAmount(dashAdmin.driver).sendKeys("10");
        Cards.CardStock(dashAdmin.driver).sendKeys("AutoEmployee");
        Thread.sleep(2000);
        Cards.CardStock(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardCurrency(dashAdmin.driver).sendKeys("Saudi");
        Cards.CardCurrency(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.BulkEmployees(dashAdmin.driver).click();
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys("10");
        Cards.CardtopupPeriod(dashAdmin.driver).click();
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardSave(dashAdmin.driver).click();
        Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New card(s) created successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
