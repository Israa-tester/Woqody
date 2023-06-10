
import Pages.DealssPage;
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

import java.time.Duration;


public class EditDeal {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOfferPage(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("(//span[@role='img'])[37]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        DealssPage.DealsLink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void EditDeal() {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        // Click on Edit icon for special deal
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoDeal']//parent::tr//td[9]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Deal')])[1]")));
        action.moveToElement(elementEdit);
        action.click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        DealssPage.DealTitle(dashAdmin.driver).sendKeys(" One");
        DealssPage.DealArabicTiltle(dashAdmin.driver).sendKeys(" واحد");
        DealssPage.DealGift(dashAdmin.driver).sendKeys("ERT");
        WebElement gift= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Dish Washer (456789012)')]"));
        jes.executeScript("arguments[0].click()", gift);
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        DealssPage.DealAmount(dashAdmin.driver).sendKeys(Keys.DELETE);
        DealssPage.DealAmount(dashAdmin.driver).sendKeys("50");
        DealssPage.DealAllVenue(dashAdmin.driver).click();
        DealssPage.DealOrganization(dashAdmin.driver).click();
        WebElement org1 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Mobile')]"));
        jes.executeScript("arguments[0].click()", org1);
        DealssPage.DealProducts(dashAdmin.driver).click();
        WebElement product2 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'oils')]"));
        jes.executeScript("arguments[0].click()", product2);
        DealssPage.ValidUntilFrom(dashAdmin.driver).click();
        WebElement validUntilWeek = dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='This week']"));
        jes.executeScript("arguments[0].click()", validUntilWeek);
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys(" Edit Text");
        DealssPage.ArabicCongratulationMessage(dashAdmin.driver).sendKeys(" نص متعدل");
        DealssPage.DealDescription(dashAdmin.driver).sendKeys("Test Description");
        DealssPage.DealSave(dashAdmin.driver).click();
        DealssPage.EditConfirmMessage(dashAdmin.driver).getText();
        String actual  = DealssPage.EditConfirmMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "AutoDeal One updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
