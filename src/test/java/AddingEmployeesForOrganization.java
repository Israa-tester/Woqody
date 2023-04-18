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


public class AddingEmployeesForOrganization {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditTheOrg(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
        // Click on view icon for special enterprise organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='test']//parent::tr//button[1][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
    }

    @Test(priority = 0)
    public void AddNewEmployee(){
        OrganizationsPage.EmployeesTab(dashAdmin.driver).click();
        OrganizationsPage.SingleEmployee(dashAdmin.driver).click();
        OrganizationsPage.CellPhoneEmployee(dashAdmin.driver).sendKeys("550101456");
        OrganizationsPage.FirstNameEmployee(dashAdmin.driver).sendKeys("Ahmed2");
        OrganizationsPage.LastNameEmployee(dashAdmin.driver).sendKeys("Ali2");
        OrganizationsPage.SaveEmployee(dashAdmin.driver).click();
        OrganizationsPage.EmpAddingMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.EmpAddingMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        //Test
        String expected = "User add to organization successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 1)
    public void AddBulkOfEmployee() {
        OrganizationsPage.EmployeesTab(dashAdmin.driver).click();
        OrganizationsPage.BulkOfEmployee(dashAdmin.driver).click();
        OrganizationsPage.FileEmployee(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\BulkEmp.xlsx");
        OrganizationsPage.EmpBulkMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.EmpBulkMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "bulk Emplyee created successfully.";
        Assert.assertEquals(actual, expected);

    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
