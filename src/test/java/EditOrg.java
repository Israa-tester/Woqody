import Pages.OrganizationsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        //Scroll the page to display the table///
        JavascriptExecutor js = (JavascriptExecutor) dashAdmin.driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Test(priority = 0)
    public void EditNormalOrg() {

        // Click on Edit icon for special deal
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.OrgNormalName +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element1).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Organization')])[1]")));
        action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.editOrgName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.editOrgAddress);
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 1)
    public void EditTopUpOrg() {
        // Click on Edit icon for special deal
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.OrgTopupName +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.editOrgName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.editOrgAddress);
        OrganizationsPage.OrganizationFualAndTopupBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.OrganizationChargeLimit(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editChargeLimitTopup));
        //Thread.sleep(1000);
        OrganizationsPage.Organizationsave(dashAdmin.driver).click();
        OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        String actual  = OrganizationsPage.OrganizationEditconfirmationmessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "Organization updated successfully";
        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 2)
    public void EditEnterpriseOrg(){

        // Click on Edit icon for special deal
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.OrgEnterpriseName +"']//parent::tr//td[8]")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.editOrgName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.editOrgAddress);
        OrganizationsPage.OrganizationEnterpriseBalance(dashAdmin.driver).click();
        OrganizationsPage.OrganizationBalanceUpdate(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editEnterpriseBalance));
        OrganizationsPage.OrganizationBalanceEnterpriseAttachment(dashAdmin.driver).sendKeys(dashAdmin.OrganizationBalanceEnterpriseAttachment);
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
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(20));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='"+ dashAdmin.OrgFuelBackName +"']//parent::tr//td[8]")));

        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element2).perform();
        WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Edit Organization')])[1]")));
        action.moveToElement(element2).moveToElement(elementEdit).click().build().perform();
        /////////////////////////////////////////////////////////////////////////
        OrganizationsPage.Organizationname(dashAdmin.driver).sendKeys(dashAdmin.editOrgName);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.Organizationaddress(dashAdmin.driver).sendKeys(dashAdmin.editOrgAddress);
        OrganizationsPage.OrganizationEnterpriseBalance(dashAdmin.driver).click();
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Keys.CONTROL + "a");
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Keys.DELETE);
        OrganizationsPage.FuelBackLimitOrganization(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editFuelBackLimit));
        OrganizationsPage.FuelBackPercentageForUser(dashAdmin.driver).sendKeys(Float.toString(dashAdmin.editFuelBackPercentage));
        /////// Valid until/////////
        OrganizationsPage.ValidUntilFrom(dashAdmin.driver).click();
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath(dashAdmin.xpathMonthFualBack));
        for(WebElement ele1:allDatesFrom){
            String dt1= ele1.getText();
            if (dt1.equals(dashAdmin.editFromDayFualBack))  ele1.click();
        }
        for(WebElement ele2:allDatesFrom){
            String dt2= ele2.getText();
            if (dt2.equals(dashAdmin.editToDayFualBack))  ele2.click();
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
