import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CreateSingleCards {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewCard(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        Cards.CreateSingleCard(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateVehicleCard() throws InterruptedException
    {

        Cards.CardAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardAmount(dashAdmin.driver).sendKeys(dashAdmin.cardAmountV);
        Cards.CardStock(dashAdmin.driver).sendKeys(dashAdmin.newVehicleStock);
        WebElement stock = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.newVehicleStock+"')]"));
        stock.click();
        /////////////Save the enterprise balance as a float number////////////
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalanceNumber;
        if (orgBalance.contains(",")){
            orgBalanceNumber = orgBalance.replaceAll(",","");
        }else{
            orgBalanceNumber = orgBalance;
        }
        Float firstBalance = Float.parseFloat(orgBalanceNumber);
        System.out.println("The org balance before creation card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys(dashAdmin.cardLabelV);
        Cards.CardEnableMonthly(dashAdmin.driver).click();
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMonthlyLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMonthlyLimit);
        Cards.CardEnableLimit(dashAdmin.driver).click();
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMinLimit);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMaxLimit);
        Cards.CardCeilingTopup(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a" );
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(dashAdmin.cardtopupAmount);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_UP);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardTopupMonthlyDay(dashAdmin.driver).click();
        Cards.CardTopupMonthlyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
        //Choose the off days//////
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.cardOffDay1 + "']")).click();
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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[7]")));
        element.getText();
        String cardAmount = element.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        softAssert.assertEquals(amountNo,dashAdmin.cardAmountV);

        // Verify the card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element1).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        String amountNoView = viewAmount.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView,dashAdmin.cardAmountV);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        action.moveToElement(element1).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element1).moveToElement(elementTopup).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after creation card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.cardAmountV));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element3.getText();
        String orgMoneyBalance = element3.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.cardAmountV));

        softAssert.assertAll();

    }

    @Test(priority = 1)
    public void CreateEmployeeCard() throws InterruptedException
    {
        Thread.sleep(1000);
        Cards.CardType(dashAdmin.driver).click();
        WebElement emp= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'Employee')]"));
        emp.click();
        Cards.CardAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardAmount(dashAdmin.driver).sendKeys(dashAdmin.cardAmountE);
        Cards.CardStock(dashAdmin.driver).sendKeys(dashAdmin.stockForCardE);
        WebElement stock = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.stockForCardE+"')]"));
        stock.click();
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalanceNumber;
        if (orgBalance.contains(",")){
            orgBalanceNumber = orgBalance.replaceAll(",","");
        }else{
            orgBalanceNumber = orgBalance;
        }
        Float firstBalance = Float.parseFloat(orgBalanceNumber);
        System.out.println("The org balance before creation card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.CardLabel(dashAdmin.driver).sendKeys(dashAdmin.cardLabelE);
        Cards.CardUser(dashAdmin.driver).sendKeys(dashAdmin.employeeName);
        WebElement employee = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item ant-select-item-option') and contains(@title,'"+dashAdmin.employeeName+"')]"));
        employee.click();
        Cards.CardEnableOverDraft(dashAdmin.driver).click();
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardOverDraftLimit(dashAdmin.driver).sendKeys(dashAdmin.cardOverDraftLimit);
        Cards.CardEnableDaily(dashAdmin.driver).click();
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardDailyLimit(dashAdmin.driver).sendKeys(dashAdmin.cardDailyLimit);
        Cards.CardEnableLimit(dashAdmin.driver).click();
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMinLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMinLimit);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardMaxLimit(dashAdmin.driver).sendKeys(dashAdmin.cardMaxLimit);
        Cards.CardFixedTopup(dashAdmin.driver).click();
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a" );
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.CardtopupAmount(dashAdmin.driver).sendKeys(dashAdmin.cardtopupAmount);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        Cards.CardtopupPeriod(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.CardTopupMonthlyDay(dashAdmin.driver).sendKeys(dashAdmin.topupMonthlyDay);
        Cards.CardTopupMonthlyDay(dashAdmin.driver).sendKeys(Keys.ENTER);
        //Choose the off days//////
        dashAdmin.driver.findElement(By.xpath("//input[@value='" + dashAdmin.cardOffDay1 + "']")).click();
        Cards.CardSave(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New card(s) created successfully";
        softAssert.assertEquals(actual, expected);

        /// Verify the card amount appears correct in the table////
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[7]")));
        element.getText();
        String cardAmount = element.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        softAssert.assertEquals(amountNo,dashAdmin.cardAmountE);

        // Verify the card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element1).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        String amountNoView = viewAmount.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView,dashAdmin.cardAmountE);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        action.moveToElement(element1).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element1).moveToElement(elementTopup).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after creation card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.cardAmountE));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element3.getText();
        String orgMoneyBalance = element3.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.cardAmountE));

        softAssert.assertAll();

    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
