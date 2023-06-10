
import Pages.DealssPage;
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateDeal {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOfferPage(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[18]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        DealssPage.DealsLink(dashAdmin.driver).click();
        je.executeScript("arguments[0].scrollIntoView(true);", DealssPage.CreateNewDeal(dashAdmin.driver));
        je.executeScript("arguments[0].click()",DealssPage.CreateNewDeal(dashAdmin.driver));
    }

    @Test(priority = 0)
    public void CreateNewDeal() {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        DealssPage.DealTitle(dashAdmin.driver).sendKeys("AutoDeal");
        DealssPage.DealArabicTiltle(dashAdmin.driver).sendKeys("صفقة اتوميشن");
        DealssPage.DealGift(dashAdmin.driver).sendKeys("ERT");
        WebElement gift= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'ERT (33)')]"));
        jes.executeScript("arguments[0].click()", gift);
        DealssPage.DealAmount(dashAdmin.driver).sendKeys("200");
        DealssPage.DealOrganization(dashAdmin.driver).click();
        WebElement org1 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Mobile')]"));
        jes.executeScript("arguments[0].click()", org1);
        WebElement org2 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Nike')]"));
        jes.executeScript("arguments[0].click()", org2);
        DealssPage.DealVenues(dashAdmin.driver).click();
        WebElement venue1 = dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='NNN']"));
        jes.executeScript("arguments[0].click()", venue1);
        WebElement venue2 = dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='11']"));
        jes.executeScript("arguments[0].click()", venue2);
        DealssPage.DealProducts(dashAdmin.driver).click();
        WebElement product1 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'benzene 80')]"));
        jes.executeScript("arguments[0].click()", product1);
        WebElement product2 = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'oils')]"));
        jes.executeScript("arguments[0].click()", product2);
        DealssPage.ValidUntilFrom(dashAdmin.driver).click();
        WebElement validUntilMonth = dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='This Month']"));
        jes.executeScript("arguments[0].click()", validUntilMonth);
        DealssPage.CongratulationMessage(dashAdmin.driver).sendKeys("Test Automate Message");
        DealssPage.ArabicCongratulationMessage(dashAdmin.driver).sendKeys("رسالة اختبار اتوميشن");
        DealssPage.DealSave(dashAdmin.driver).click();
        DealssPage.AddConfirmMessage(dashAdmin.driver).getText();
        String actual  = DealssPage.AddConfirmMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New deal created successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
