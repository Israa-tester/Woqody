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
import java.time.Duration;


public class AddingEmployeesForOrganization {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditTheOrg(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
        // Click on view icon for special enterprise organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.OrgEnterpriseName +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'View Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
    }

    @Test(priority = 0)
    public void AddNewEmployee(){
        OrganizationsPage.EmployeesTab(dashAdmin.driver).click();
        OrganizationsPage.SingleEmployee(dashAdmin.driver).click();
        OrganizationsPage.CellPhoneEmployee(dashAdmin.driver).sendKeys(dashAdmin.cellPhoneEmployee);
        OrganizationsPage.FirstNameEmployee(dashAdmin.driver).sendKeys(dashAdmin.firstNameEmployee);
        OrganizationsPage.LastNameEmployee(dashAdmin.driver).sendKeys(dashAdmin.lastNameEmployee);
        OrganizationsPage.SaveEmployee(dashAdmin.driver).click();
        OrganizationsPage.EmpAddingMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.EmpAddingMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "User add to organization successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 1)
    public void AddBulkOfEmployee() {
        OrganizationsPage.EmployeesTab(dashAdmin.driver).click();
        OrganizationsPage.BulkOfEmployee(dashAdmin.driver).click();
        OrganizationsPage.FileEmployee(dashAdmin.driver).sendKeys(dashAdmin.fileEmployees);
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
