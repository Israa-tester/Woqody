import Pages.Cards;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        Cards.Cardslink(dashAdmin.driver).click();


    }
    @Test(priority = 0)
    public void EditVehicleCard()
    {
        // Click on edit icon for special Vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Edit Card')]")));
        action.moveToElement(element1).moveToElement(elementView).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardLabel(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardLabel(dashAdmin.driver).sendKeys(dashAdmin.cardLabelEditV);
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(dashAdmin.cardDailyLimitEdit);
        Cards.CardEnableMonthly(dashAdmin.driver).click();
        Cards.CardEnableLimit(dashAdmin.driver).click();
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMaxLimitEdit);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMinLimitEdit);
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.cardOffDay1 + "']")).click();
        Cards.CardSave(dashAdmin.driver).click();
        Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardEditConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Card updated successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void EditEmployeeCard()
    {
        // Click on edit icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Edit Card')]")));
        action.moveToElement(element1).moveToElement(elementView).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys(dashAdmin.cardLabelEditE);
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(dashAdmin.cardOverdraftLimitEdit);
        Cards.CardEnableDaily(dashAdmin.driver).click();
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMonthlyLimitEdit);
        Cards.CardEnableLimit(dashAdmin.driver).click();
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMaxLimitEdit);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMinLimitEdit);
        Cards.CardCeilingTopup(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a" );
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(dashAdmin.cardtopupSchedulerAmountEdit);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.cardOffDay1 + "']")).click();
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
