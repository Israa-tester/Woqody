import Pages.OrganizationsPage;
import Pages.VendorsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class FilterVendor extends BeforeAndAfter {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void OpenOrgPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        VendorsPage.Vendorlink(dashAdmin.driver).click();
        VendorsPage.FilterPart(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void FilterNormalVendor() throws InterruptedException {
        String fromDay = "3";
        String toDay= "3";
        VendorsPage.CreationDateFrom(dashAdmin.driver).click();
       List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]//td"));
        for(WebElement ele:allDatesFrom) {
            String dt1 = ele.getText();
            if (dt1.equals(fromDay)) ele.click();
        }
        for (WebElement ele1 : allDatesFrom) {
                String dt2 = ele1.getText();
                if (dt2.equals(toDay)) ele1.click();
            }

        VendorsPage.FilterApply(dashAdmin.driver).click();
        Assert.assertFalse(dashAdmin.driver.findElement(By.xpath("//td[.='NormalQQ']")).isDisplayed());
    }



    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
