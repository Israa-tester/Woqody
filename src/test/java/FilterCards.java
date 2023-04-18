import Pages.CardStockPage;
import Pages.Cards;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FilterCards extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        Cards.Cardslink(dashAdmin.driver).click();
        Cards.FilterPart(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void FilterVehicleCard()
    {
       // CardStockPage.OrgNameFilter(dashAdmin.driver).sendKeys("Rofa");
        Cards.CardID(dashAdmin.driver).sendKeys("6a50e195-3f45-469f-8469-7d4fd56704dc");
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        Cards.CardLabelFilter(dashAdmin.driver).sendKeys("ERT - 209 - 11 - 4");
        je.executeScript("arguments[0].click()", Cards.FilterApply(dashAdmin.driver));
        String actual  = dashAdmin.driver.findElement(By.xpath("//td[.='ERT - 209 - 11 - 4']")).getText();
        System.out.println(actual);
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='ERT - 209 - 11 - 4']")).isDisplayed());
    }

    @Test(priority = 1)
    public void FilterEmployeeCard()
    {
        // CardStockPage.OrgNameFilter(dashAdmin.driver).sendKeys("Rofa");
        Cards.CardID(dashAdmin.driver).sendKeys("ad22c9e0-c772-45c5-ba63-911f50fe11a3");
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        Cards.CardLabelFilter(dashAdmin.driver).sendKeys("SDE - 98 - 56 - 388");
        je.executeScript("arguments[0].click()", Cards.FilterApply(dashAdmin.driver));
        String actual  = dashAdmin.driver.findElement(By.xpath("//td[.='SDE - 98 - 56 - 388']")).getText();
        System.out.println(actual);
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='SDE - 98 - 56 - 388']")).isDisplayed());
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
