import Pages.OrganizationsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void ViewNormalOrg(){

        // Click on view icon for special normal organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='test3']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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

    }

    @Test(priority = 1)
    public void ViewEnterpriseOrg() {
        // Click on view icon for special enterprise organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='test']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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
    }

    @Test(priority = 2)
    public void ViewFuelBackOrg(){

        // Click on view icon for special fuel back organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Eman Helmy']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
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
    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
