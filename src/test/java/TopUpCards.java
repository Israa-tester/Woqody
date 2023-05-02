import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class TopUpCards extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void TopupVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoV3 - 271 - 1 - 8']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the topup process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the topup process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before top up card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Float topupMoney = 2.5F;
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(Float.toString(topupMoney));
        Cards.Topupbutton(dashAdmin.driver).click();
        Thread.sleep(1000);
        Cards.Okbutton(dashAdmin.driver).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();


        // Verify The success message appears ///
        Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        String actual  = Cards.TransactionSuccessMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Transaction made successfully";
        softAssert.assertEquals(actual, expected);
        dashAdmin.driver.navigate().back();

        // Verify the card amount appears correct in the table////
        WebDriverWait wait1 = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println("The amount card in the table " + cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,amountNoView+ topupMoney);

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView2 = viewAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNoView2,amountNoView + topupMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - topupMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - topupMoney);

    }
    @Test(priority = 1)
    public void DeductVehicleCard() throws InterruptedException {
        // Click on topup icon for special vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoV3 - 271 - 1 - 8']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before deduct card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Float deductMoney = 2.0F;
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(Float.toString(- deductMoney));
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
        WebDriverWait wait1 = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println("The amount card in the table " + cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,amountNoView + (- deductMoney) );

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView2 = viewAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNoView2,amountNoView + (- deductMoney));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance + deductMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + deductMoney);

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void TopupEmployeeCard() throws InterruptedException {
        // Click on topup icon for special employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the topup process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the topup process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before top up card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Float topupMoney = 1.5F;
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(Float.toString(topupMoney));
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
        WebDriverWait wait1 = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println("The amount card in the table " + cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,amountNoView+ topupMoney);

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView2 = viewAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNoView2,amountNoView + topupMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - topupMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - topupMoney);

        softAssert.assertAll();
    }
    @Test(priority = 3)
    public void DeductEmployeeCard() throws InterruptedException {
        // Click on topup icon for special employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before deduct card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Float deductMoney = 2.0F;
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        Cards.Amount(dashAdmin.driver).sendKeys(Keys.DELETE);
        Cards.Amount(dashAdmin.driver).sendKeys(Float.toString(- deductMoney));
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
        WebDriverWait wait1 = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//td[7]")));
        element1.getText();
        String cardAmount = element1.getText();
        System.out.println("The amount card in the table " + cardAmount);
        String currency = "SAR ";
        String amountNo = cardAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNo,amountNoView + (- deductMoney) );

        // Verify the card amount appears correct in the view///
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in the view card " + viewAmount1);
        String amountNoView2 = viewAmount.replaceAll("",currency);
        softAssert.assertEquals(amountNoView2,amountNoView + (- deductMoney));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance + deductMoney);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);
        //////////////////////////////////////
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + deductMoney);

        softAssert.assertAll();
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
