
import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        Cards.StockUploadCard(dashAdmin.driver).sendKeys("AutoVehicle");
        Thread.sleep(2000);
        Cards.StockUploadCard(dashAdmin.driver).sendKeys(Keys.ENTER);
        Cards.BulkUploadFile(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\BulKCards.xlsx");
        Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        String actual  = Cards. UploadBulkConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "(2) bulk cards created successfully.";
        Assert.assertEquals(actual, expected);
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
