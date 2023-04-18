import Pages.CardStockPage;
import Pages.OrganizationsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FilterCardStock extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/div[1]/span[1]")).click();
        CardStockPage.CardStocklink(dashAdmin.driver).click();
        CardStockPage.FilterPart(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void FilterVehicleStock()
    {
       // CardStockPage.OrgNameFilter(dashAdmin.driver).sendKeys("Rofa");
        CardStockPage.FilterStockType(dashAdmin.driver).sendKeys("Vehicle");
        CardStockPage.FilterStockType(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.CardsCount(dashAdmin.driver).sendKeys("2");
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].click()", CardStockPage.FilterApply(dashAdmin.driver));
        String actual  = dashAdmin.driver.findElement(By.xpath("//td[.='Touch123 - 318 - 4']")).getText();
        System.out.println(actual);
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='Touch123 - 318 - 4']")).isDisplayed());
    }

    @Test(priority = 1)
    public void FilterEmployeeStock()
    {
        // CardStockPage.OrgNameFilter(dashAdmin.driver).sendKeys("Rofa");
        CardStockPage.FilterStockType(dashAdmin.driver).sendKeys("Epmloyee");
        CardStockPage.FilterStockType(dashAdmin.driver).sendKeys(Keys.ARROW_DOWN);
        CardStockPage.FilterStockType(dashAdmin.driver).sendKeys(Keys.ENTER);
        CardStockPage.CardsCount(dashAdmin.driver).sendKeys("3");
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].click()", CardStockPage.FilterApply(dashAdmin.driver));
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//td[.='Note employee - 176 - 3']")).isDisplayed());
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
