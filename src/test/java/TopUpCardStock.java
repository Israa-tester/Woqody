import Pages.CardStockPage;
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


public class TopUpCardStock extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void TopupVehicleStock()
    {
        // Click on topup icon for special vehicle stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Stock123')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before topup cards " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        CardStockPage.TopupFile(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\Stock123.csv");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
        // Verify The success message appears ///
        CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Cards top-up successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the org balance appears correct///
        Float topupMoney= 2.0F;
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='reload']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Stock123')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup cards " + presentBalance);
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
    public void TopupEmployeeStock()
    {
        // Click on topup icon for special employee stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Stock employee')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before topup cards " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        CardStockPage.TopupFile(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\StockEmployee.csv");

        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockConfirmationTopup(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Cards top-up successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the org balance appears correct///
        Float topupMoney= 1.0F;
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='reload']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element2);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Stock employee')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after topup cards " + presentBalance);
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


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
