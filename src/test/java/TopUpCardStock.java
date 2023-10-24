import Pages.CardStockPage;
import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class TopUpCardStock extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void TopupVehicleStock() throws InterruptedException {

        // Click on topup icon for special vehicle stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newVehicleStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementTopUp1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Top-Up Cards Stock')])[1]")));
        action.moveToElement(element1).moveToElement(elementTopUp1).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
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
        System.out.println("The org balance before topup the stock " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        CardStockPage.TopupFile(dashAdmin.driver).sendKeys(dashAdmin.fileTopUpStockV);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
        // Verify The success message appears ///
        CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Cards top-up successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        action.moveToElement(element1).perform();
        action.moveToElement(element1).moveToElement(elementTopUp1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgMoney.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after topup cards " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.stockTopUpAmount));
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
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.stockTopUpAmount));

        softAssert.assertAll();

    }

    @Test(priority = 1)
    public void TopupEmployeeStock() throws InterruptedException {

        // Click on topup icon for special employee stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newEmployeeStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementTopUp1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Top-Up Cards Stock')])[1]")));
        action.moveToElement(element1).moveToElement(elementTopUp1).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
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
        System.out.println("The org balance before topup the stock " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        CardStockPage.TopupFile(dashAdmin.driver).sendKeys(dashAdmin.fileTopUpStockE);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
        // Verify The success message appears ///
        CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Cards top-up successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the org balance appears correct///
        Thread.sleep(1000);
        action.moveToElement(element1).perform();
        action.moveToElement(element1).moveToElement(elementTopUp1).click().build().perform();
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoneyNumber;
        if (orgMoney.contains(",")){
            orgMoneyNumber = orgMoney.replaceAll(",","");
        }else{
            orgMoneyNumber = orgMoney;
        }
        Float presentBalance = Float.parseFloat(orgMoneyNumber);
        System.out.println("The org balance after topup cards " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - Float.valueOf(dashAdmin.stockTopUpAmountEmp));
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
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - Float.valueOf(dashAdmin.stockTopUpAmountEmp));

        softAssert.assertAll();
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
