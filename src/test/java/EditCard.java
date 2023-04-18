import Pages.Cards;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class EditCard {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenCardPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void EditVehicleCard() throws InterruptedException
    {
        // Click on edit icon for special Vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoLabel - 345 - 1 - 6']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardLabel(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardLabel(dashAdmin.driver).sendKeys("AutoVehicle");
        Cards.CardEnableMonthly(dashAdmin.driver).click();
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys("100");
        Cards.CardEnableLimit(dashAdmin.driver).click();
        Cards.CardMinLimit(dashAdmin.driver).sendKeys("5");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys("10");
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys("10");
        Cards.CardtopupPeriod(dashAdmin.driver).click();
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardTopupMonthlyDay(dashAdmin.driver).click();
        Cards.CardTopupMonthlyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardOffDaySundayVehicle(dashAdmin.driver).click();
        Cards.CardSave(dashAdmin.driver).click();
        Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Card updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void EditEmployeeCard() throws InterruptedException
    {
        // Click on edit icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='RE2 - 320 - 2 - 1']//parent::tr//button[4][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys("EE");
        Cards.CardEnableDaily(dashAdmin.driver).click();
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys("10");
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        Cards.BulkOffDaySaturdayEmp(dashAdmin.driver).click();
        Cards.CardSave(dashAdmin.driver).click();
        Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Card updated successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
