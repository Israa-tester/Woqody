
import Pages.Cards;
import org.openqa.selenium.*;
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
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void DeleteVehicleCard() throws InterruptedException
    {
        // Click on topup icon for special Vehicle card to save the card amount and Org balance
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountCard = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before delete card " + firstBalance);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));
        /////////////////////////////////////////////////////////////////////////////////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoV3')]//parent::tr//button[4][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element1);
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
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + amountCard);

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void DeleteEmployeeCard() throws InterruptedException
    {
        // Click on topup icon for special employee card to save the card amount and Org balance
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        // Save the present amount before the deduct process
        Cards.AmountCard(dashAdmin.driver).getText();
        String viewAmount = Cards.AmountCard(dashAdmin.driver).getText();
        System.out.println("The amount in before the deduct process " + viewAmount);
        String currencyView = "SAR ";
        String amountCard = viewAmount.replaceAll("",currencyView);
        //Save the enterprise balance as a float number
        Cards.EnterpriseBalance(dashAdmin.driver).getText();
        String orgBalance= Cards.EnterpriseBalance(dashAdmin.driver).getText();
        Float firstBalance = Float.parseFloat(orgBalance);
        System.out.println("The org balance before delete card " + firstBalance);
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", Cards.ClosePopup(dashAdmin.driver));
        /////////////////////////////////////////////////////////////////////////////////
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'AutoEmp2')]//parent::tr//button[4][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element1);
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
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='No balance'][1]//parent::tr//td[5]")));
        element4.getText();
        String orgMoneyBalance = element4.getText();
        Float presentBalanceInBalancePage = Float.parseFloat(orgMoneyBalance);
        System.out.println("The org balance after creation card in organization balance page " + presentBalanceInBalancePage);
        softAssert.assertEquals(presentBalanceInBalancePage,firstBalance + amountCard);

        softAssert.assertAll();
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
