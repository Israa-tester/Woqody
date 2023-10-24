import Pages.CardStockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class DeleteStock {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenStockPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//span[contains(text(),'Cards')]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();


    }
    @Test(priority = 0)
    public void DeleteVehicleStock()
    {
        // Click on delete icon for special Stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newVehicleStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.DeleteButton(dashAdmin.driver).click();
        CardStockPage.StockDeleteMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void DeleteEmployeeStock()
    {
        // Click on edit icon for special Employee stock
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.newEmployeeStock+"')]//parent::tr//td[@class='ant-table-cell ant-table-cell-fix-right ant-table-cell-fix-right-first']")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        CardStockPage.DeleteButton(dashAdmin.driver).click();
        CardStockPage.StockDeleteMessage(dashAdmin.driver).getText();
        String actual  = CardStockPage.StockDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
