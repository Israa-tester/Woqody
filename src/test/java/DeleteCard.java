
import Pages.Cards;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        // Click on edit icon for special Vehicle card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='RE2EE - 320 - 2 - 1']//parent::tr//button[4][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        Cards.DeleteButton(dashAdmin.driver).click();
        Cards.CardDeleteMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void DeleteEmployeeCard() throws InterruptedException
    {
        // Click on edit icon for special Employee card
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='RE2EE - 320 - 2 - 1']//parent::tr//button[4][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        Cards.DeleteButton(dashAdmin.driver).click();
        Cards.CardDeleteMessage(dashAdmin.driver).getText();
        String actual  = Cards.CardDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
