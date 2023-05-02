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
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        Cards.CardAmount(dashAdmin.driver).sendKeys("6");
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.BulkCardsCount(dashAdmin.driver).sendKeys("2");
        Cards.CardStock(dashAdmin.driver).sendKeys("Stock123");
        Thread.sleep(1000);
        WebElement stock= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Stock123 - 271 - 1']"));
        jes.executeScript("arguments[0].click();",stock);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before creation card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
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
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New card(s) created successfully";
        softAssert.assertEquals(actual, expected);

        // Verify the card amount appears correct in the table////
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//td[7]")));
        element.getText();
        String cardAmount = element.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,6.00);

        // Verify the card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element1);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        softAssert.assertEquals(amountNoView,6.00);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after creation card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - (2*6));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);

        //////////////////////////////////////
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element3.getText();
        String orgMoneyBalance = element3.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - 2*6);

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void CreateEmployeeCard() throws InterruptedException
    {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        Cards.CardType(dashAdmin.driver).sendKeys("Employee");
        Cards.CardType(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        Cards.CardType(dashAdmin.driver).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Cards.CardAmount(dashAdmin.driver).sendKeys("4");
        Cards.CardStock(dashAdmin.driver).sendKeys("Stock Employee");
        Thread.sleep(1000);
        WebElement stock= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Stock employee - 271 - 2']"));
        jes.executeScript("arguments[0].click();",stock);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before creation card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.BulkEmployees(dashAdmin.driver).click();
        Cards.CardTopupSchedulerEnable(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys("10");
        Cards.CardtopupPeriod(dashAdmin.driver).click();
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardSave(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New card(s) created successfully";
        softAssert.assertEquals(actual, expected);

        // Verify the card amount appears correct in the table////
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//td[7]")));
        element.getText();
        String cardAmount = element.getText();
        System.out.println("The amount card in the table " + cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,4.00);

        // Verify the card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element1);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        softAssert.assertEquals(amountNoView,4.00);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[contains(text(),'No Name')])[1]//parent::tr//td[13]/button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after creation card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - (2*4));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element3.getText();
        String orgMoneyBalance = element3.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - (2*4));

        softAssert.assertAll();

    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
