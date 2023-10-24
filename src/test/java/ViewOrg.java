import Pages.OrganizationsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class ViewOrg {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditTheOrg(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void ViewNormalOrg() {

        // Click on view icon for special normal organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteNormalOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Organization')]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertAll();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));
        OrganizationsPage.TransactionTab(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[2]")).getAttribute("class").contains("active"));
        OrganizationsPage.StuffMembersTab(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[3]")).getAttribute("class").contains("active"));
        OrganizationsPage.POSDevicesTab(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[4]")).getAttribute("class").contains("active"));
        OrganizationsPage.InformationTab(dashAdmin.driver).click();
        Assert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));

    }

    @Test(priority = 1)
    public void ViewEnterpriseOrg() {
        // Click on view icon for special enterprise organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteEnterpriseOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'View Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));
        OrganizationsPage.TransactionTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[2]")).getAttribute("class").contains("active"));
        OrganizationsPage.StuffMembersTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[3]")).getAttribute("class").contains("active"));
        OrganizationsPage.EmployeesTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[4]")).getAttribute("class").contains("active"));
        OrganizationsPage.CardStocksTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[5]")).getAttribute("class").contains("active"));
        OrganizationsPage.BalanceHistoryTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[6]")).getAttribute("class").contains("active"));
        OrganizationsPage.InformationTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void ViewFuelBackOrg(){

        // Click on view icon for special fuel back organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteFuelBackOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'View Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));
        OrganizationsPage.TransactionTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[2]")).getAttribute("class").contains("active"));
        OrganizationsPage.StuffMembersTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[3]")).getAttribute("class").contains("active"));
        OrganizationsPage.POSDevicesTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[4]")).getAttribute("class").contains("active"));
        OrganizationsPage.InformationTab(dashAdmin.driver).click();
        softAssert.assertTrue(dashAdmin.driver.findElement(By.xpath("//div[@class='ant-tabs-nav-list']/div[1]")).getAttribute("class").contains("active"));
        softAssert.assertAll();
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
