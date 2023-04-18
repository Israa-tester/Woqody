import Pages.OrganizationsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class DeleteOrgs {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void DeleteNormalOrg() throws InterruptedException
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Topup']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OrganizationsPage.DeleteButton(dashAdmin.driver).click();
        OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void DeleteEnterpriseOrg() throws InterruptedException
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoEnterpriseS1']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        Thread.sleep(1000);
        OrganizationsPage.DeleteButton(dashAdmin.driver).click();
        OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void DeleteFuelBackOrg() throws InterruptedException
    {
        // Click on Delete icon for special Vendor
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='الواقواق']//parent::tr//button[3][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
       Thread.sleep(1000);
        OrganizationsPage.DeleteButton(dashAdmin.driver).click();
        OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
