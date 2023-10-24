
import Pages.Cards;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DeleteCard {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenCardPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        JavascriptExecutor js = (JavascriptExecutor) dashAdmin.driver;
       // js.executeScript("window.scrollBy(0,1000)");

    }
    @Test(priority = 0)
    public void DeleteVehicleCard() throws InterruptedException
    {
        // Click on topup icon for special Vehicle card to save the card amount and Org balance
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.cardLabelEditV+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementView).click().build().perform();
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountCard = viewAmount.replaceAll(currencyView,"");
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
        System.out.println("The org balance before delete card " + firstBalance);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));
        /////////////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        action.moveToElement(element).perform();
        WebElement elementView1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete')]")));
        action.moveToElement(element).moveToElement(elementView1).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        Cards.DeleteButton(dashAdmin.driver).click();

        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.CardDeleteMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        softAssert.assertEquals(actual, expected);

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
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + Float.valueOf(dashAdmin.cardAmountV));

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void DeleteEmployeeCard() throws InterruptedException
    {
        // Click on topup icon for special Employee card to save the card amount and Org balance
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin. cardFullLabelE+"')]//parent::tr//td[13]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Top-up Card')]")));
        action.moveToElement(element).moveToElement(elementView).click().build().perform();
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountCard = viewAmount.replaceAll(currencyView,"");
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
        System.out.println("The org balance before delete card " + firstBalance);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));
        /////////////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        action.moveToElement(element).perform();
        WebElement elementView1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete')]")));
        action.moveToElement(element).moveToElement(elementView1).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        Cards.DeleteButton(dashAdmin.driver).click();

        SoftAssert softAssert = new SoftAssert();

        // Verify The success message appears ///
        Cards.CardDeleteMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        softAssert.assertEquals(actual, expected);

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
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + Float.valueOf(dashAdmin.cardAmountE));

        softAssert.assertAll();
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
