
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

public class UploadBulkOfCards {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewCard(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        Cards.UploadBulkLink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void CreateBulkVehicleCard() throws InterruptedException
    {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        Cards.StockUploadCard(dashAdmin.driver).sendKeys("Stock123");
        Thread.sleep(1000);
        WebElement stock= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Stock123 - 271 - 1']"));
        jes.executeScript("arguments[0].click();",stock);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before creation card " + firstBalance);
        /////////////////////////////////////////////////////////////////////////////////
        Cards.BulkUploadFile(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\BulkVehicleNoBalance.xlsx");



        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "(2) bulk cards created successfully.";
        softAssert.assertEquals(actual, expected);

        // Verify the first card amount appears correct in the table////
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV11')]//parent::tr//td[7]")));
        element.getText();
        String cardAmount1 = element.getText();
        System.out.println(cardAmount1);
        String currency = "SAR ";
        String amountNo1 = cardAmount1.replaceAll("",currency);
        softAssert.assertEquals(amountNo1,5.00);

        // Verify the second card amount appears correct in the table////
        WebDriverWait wait2 = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV12')]//parent::tr//td[7]")));
        element2.getText();
        String cardAmount2 = element2.getText();
        System.out.println(cardAmount2);
        String currency2 = "SAR ";
        String amountNo2 = cardAmount2.replaceAll("",currency);
        softAssert.assertEquals(amountNo2,10.00);

        // Verify the first card amount appears correct in the view///
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV11')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element1);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        String currencyView = "SAR ";
        String amountNoView = viewAmount.replaceAll("",currencyView);
        softAssert.assertEquals(amountNoView,5.00);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the second card amount appears correct in the view///
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV12')]//parent::tr//td[13]/button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element3);
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount2 = Cards.AmountCard(dashAdmin.driver).getText();
        String currencyView2 = "SAR ";
        String amountNoView2 = viewAmount.replaceAll("",currencyView2);
        softAssert.assertEquals(amountNoView2,10.00);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct///
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV12')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element4);
        Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        String orgMoney = Cards.OrgBalanceInTopup(dashAdmin.driver).getText();
        Float presentBalance = Float.parseFloat(orgMoney);
        System.out.println("The org balance after creation card " + presentBalance);
        softAssert.assertEquals(presentBalance,firstBalance - 15);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));

        // Verify the org balance appears correct in organization balance page///

        ///////Scroll the menu sidebar to open the organization balance//////////////////////
        dashAdmin.driver.navigate().refresh();
        WebElement orgBalancePage = dashAdmin.driver.findElement(By.xpath("//a[@href='/organization-activities']"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",orgBalancePage);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", orgBalancePage);

        //////////////////////////////////////
        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element6.getText();
        String orgMoneyBalance = element6.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance - 15);

        softAssert.assertAll();
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
