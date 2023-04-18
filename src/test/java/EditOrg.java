import Pages.OrganizationsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EditOrg {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void EditTheOrg(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        OrganizationsPage.Organizationslink(dashAdmin.driver).click();
    }

    @Test(priority = 0)
    public void EditNormalOrg(){

        // Click on edit icon for special normal organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='NormalQQ']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(" Org");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("TanTa,Al-Galaa");
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 1)
    public void EditTopUpOrg() throws InterruptedException {
        // Click on edit icon for special topup organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Topup']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(" Org");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("TanTa,Al-Galaa");
        OrganizationsPage.OrganizationFualAndTopupBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys("55");
        Thread.sleep(1000);
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 2)
    public void EditEnterpriseOrg(){

        // Click on edit icon for special enterprise organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='AutoEnterprise']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////

        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("S1");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys("Mansoura,Al-Galaa");
        OrganizationsPage.OrganizationEnterpriseBalance(dashAdmin.driver).click();

        OrganizationsPage.OrganizationBalanceUpdate(dashAdmin.driver).sendKeys("550");
        OrganizationsPage.OrganizationBalanceEnterpriseAttachment(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\spring-images-min.jpg");
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void EditFuelBackOrg(){

        // Click on edit icon for special fuelback organization
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='Eman Helmy']//parent::tr//button[2][@type='button']")));
        ((JavascriptExecutor)dashAdmin.driver).executeScript("arguments[0].click();", element);
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys("EditFuelback");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(" متغير ");
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys("6000");
        OrganizationsPage.FuelBackPercentageForUser(dashAdmin.driver).sendKeys("2");
       /////// Valid until/////////
        String fromDay = "25";
        String toDay= "30";
        OrganizationsPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(fromDay))  ele.click();
        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(toDay))  ele1.click();
        }

        //////////////////////////////
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
