
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

public class UploadBulkOfCards {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewCard(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        Cards.UploadBulkLink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateBulkVehicleCard() throws InterruptedException
    {
        Thread.sleep(1000);
        Cards.CardStock(dashAdmin.driver).sendKeys(dashAdmin.stockForCardV);
        WebElement stock = dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and starts-with(.,'"+dashAdmin.stockForCardV+"')]"));
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
        Cards.BulkUploadFile(dashAdmin.driver).sendKeys(dashAdmin.fileBulkCards);



        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "(2) bulk cards created successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the first card amount appears correct in the table////
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+dashAdmin.fileCardLabel1+"')]//parent::tr//td[7]")));
        element.getText();
        String cardAmount1 = element.getText();
        System.out.println(cardAmount1);
        String currency = "SAR ";
        String amountNo1 = cardAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNo1,dashAdmin.fileCardAmount1);

        // Verify the second card amount appears correct in the table////
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+dashAdmin.fileCardLabel2+"')]//parent::tr//td[7]")));
        element2.getText();
        String cardAmount2 = element2.getText();
        System.out.println(cardAmount2);
        String amountNo2 = cardAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNo2,dashAdmin.fileCardAmount2);

        // Verify the first card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+dashAdmin.fileCardLabel2+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element1).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount1 = Cards.AmountCard(dashAdmin.driver).getText();
        String amountNoView1 = viewAmount1.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView1,dashAdmin.fileCardAmount1);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        /*
        // Verify the second card amount appears correct in the view///
        Thread.sleep(1000);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'"+dashAdmin.fileCardLabel2+"')]//parent::tr//td[13]//span")));
        action.moveToElement(element3).perform();
        //WebElement elementView2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Card')]")));
        action.moveToElement(element3).moveToElement(elementView).click().build().perform();
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount2 = Cards.AmountCard(dashAdmin.driver).getText();
        String amountNoView2 = viewAmount2.replaceAll(currency,"");
        softAssert.assertEquals(amountNoView2,dashAdmin.fileCardAmount2);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));
        */
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
        softAssert.assertEquals(presentBalance,firstBalance - (Float.valueOf(dashAdmin.fileCardAmount2) + Float.valueOf(dashAdmin.fileCardAmount1)));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));


        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);

        //////////////////////////////////////
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+dashAdmin.OrgEnterpriseName+"'][1]//parent::tr//td[5]")));
        element5.getText();
        String orgMoneyBalance = element5.getText();
        String orgMoneyBalanceNumber;
        if (orgBalance.contains(",")){
            orgMoneyBalanceNumber = orgMoneyBalance.replaceAll(",","");
        }else{
            orgMoneyBalanceNumber = orgMoneyBalance;
        }
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalanceNumber);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalance,firstBalance - (Float.valueOf(dashAdmin.fileCardAmount2) + Float.valueOf(dashAdmin.fileCardAmount1)));
        softAssert.assertAll();
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
