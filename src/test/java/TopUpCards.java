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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;


public class TopUpCards extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        Cards.Cardslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void TopupVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementTopup).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the topup process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the topup process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll(currencyView, "");
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
        System.out.println("The org balance before top up card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(dashAdmin.cardTopUpAmount);
        Cards.Topupbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        softAssert.assertEquals(actual, expected);
        dashAdmin.driver.navigate().back();

        // Verify the card amount appears correct in the table////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        NumberFormat df = new DecimalFormat("00.00");
        df.setMaximumFractionDigits(2);
        Double amountCardView = Double.valueOf(amountNoView);
        Double amountCardTopup = Double.valueOf(dashAdmin.cardTopUpAmount);
        Double finalCardAmount = amountCardView + amountCardTopup;
        softAssert.assertEquals(amountNo,df.format(finalCardAmount));

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element2).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element2).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView1 = viewAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView1, df.format(finalCardAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element5).perform();
        WebElement elementTopup1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element5).moveToElement(elementTopup1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.cardTopUpAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.cardTopUpAmount));

        softAssert.assertAll();

    }
    @Test(priority = 1)
    public void DeductVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementTopup).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll(currencyView, "");
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
        System.out.println("The org balance before deduct card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(dashAdmin.cardDedcutAmount);
        Cards.Deductbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        softAssert.assertEquals(actual, expected);
        dashAdmin.driver.navigate().back();

        // Verify the card amount appears correct in the table////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        NumberFormat df = new DecimalFormat("00.00");
        df.setMaximumFractionDigits(2);
        Double amountCardView = Double.valueOf(amountNoView);
        String cardDedcutAmount = dashAdmin.cardDedcutAmount.replaceAll("- ","");
        Double amountCardDeduct = Double.valueOf(cardDedcutAmount);
        Double finalCardAmount = amountCardView - amountCardDeduct;
        softAssert.assertEquals(amountNo,df.format(finalCardAmount));

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element2).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element2).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView1 = viewAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView1, df.format(finalCardAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelV+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element5).perform();
        WebElement elementTopup1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element5).moveToElement(elementTopup1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after deduct card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance + Float.valueOf(cardDedcutAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));


        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + Float.valueOf(cardDedcutAmount));

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void TopupEmployeeCard() throws InterruptedException {
        // Click on topup icon for special employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementTopup).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the topup process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the topup process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll(currencyView, "");
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
        System.out.println("The org balance before top up card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(dashAdmin.cardTopUpAmount);
        Cards.Topupbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        softAssert.assertEquals(actual, expected);
        dashAdmin.driver.navigate().back();

        // Verify the card amount appears correct in the table////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        NumberFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        Double amountCardView = Double.valueOf(amountNoView);
        Double amountCardTopup = Double.valueOf(dashAdmin.cardTopUpAmount);
        Double finalCardAmount = amountCardView + amountCardTopup;
        softAssert.assertEquals(amountNo,df.format(finalCardAmount));

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element2).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element2).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView1 = viewAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView1, df.format(finalCardAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element5).perform();
        WebElement elementTopup1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element5).moveToElement(elementTopup1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.cardTopUpAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.cardTopUpAmount));

        softAssert.assertAll();
    }
    @Test(priority = 3)
    public void DeductEmployeeCard() throws InterruptedException {
        // Click on topup icon for special employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementTopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementTopup).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll(currencyView, "");
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
        System.out.println("The org balance before deduct card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(dashAdmin.cardDedcutAmount);
        Cards.Deductbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        softAssert.assertEquals(actual, expected);
        dashAdmin.driver.navigate().back();

        // Verify the card amount appears correct in the table////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println(cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll(currency,"");
        NumberFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        Double amountCardView = Double.valueOf(amountNoView);
        String cardDedcutAmount = dashAdmin.cardDedcutAmount.replaceAll("- ","");
        Double amountCardDeduct = Double.valueOf(cardDedcutAmount);
        Double finalCardAmount = amountCardView - amountCardDeduct;
        softAssert.assertEquals(amountNo,df.format(finalCardAmount));

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element2).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element2).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView1 = viewAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView1, df.format(finalCardAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelE+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element5).perform();
        WebElement elementTopup1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element5).moveToElement(elementTopup1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgBalance.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after deduct card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance + Float.valueOf(cardDedcutAmount));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));


        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + Float.valueOf(dashAdmin.cardDedcutAmount));

        softAssert.assertAll();
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
