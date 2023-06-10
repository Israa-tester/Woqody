import Pages.OrganizationsPage;
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


public class DeleteOrgs {

    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void DeleteNormalOrg()
    {
        // Click on Delete icon for special Org
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(50));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteNormalOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
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
        // Click on Delete icon for special Org
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(50));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteEnterpriseOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.DeleteButton(dashAdmin.driver).click();
        OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrgDeleteMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Row deleted successfully";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void DeleteFuelBackOrg()
    {
        // Click on Delete icon for special Org
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(50));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.deleteFuelBackOrg +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Delete')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
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
