
import Pages.TransactionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class TransactionsFilters {

    BeforeAndAfter dashAdmin;

    @BeforeMethod
    public void OpenTransactionPage(){
        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();

        TransactionsPage.Transactionslink(dashAdmin.driver).click();
        TransactionsPage.FilterOpen(dashAdmin.driver).click();

    }
    @Test(priority = 0)
    public void AccountChargeFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        /////// Creation Date/////////

        String fromDay = "16";
        String toDay= "26";
        TransactionsPage.CreationDateFrom(dashAdmin.driver).click();
        WebElement element15= dashAdmin.driver.findElement(By.xpath("(//button[contains(@type,'button')])[37]"));
        jes.executeScript("arguments[0].click();",element15);
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("(//tbody)[2]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(fromDay))  jes.executeScript("arguments[0].click();",ele);

        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(toDay))   jes.executeScript("arguments[0].click();",ele1);
        }
        //////////////////////////////
        TransactionsPage.TransactionID(dashAdmin.driver).sendKeys("40294e99-a5cf-4a33-b379-21761742bb6c");
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys("Account Charge");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'flex row')])[35]")));
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Status(dashAdmin.driver).sendKeys("Success");
        Thread.sleep(1000);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys("Personal Wallet");
        Thread.sleep(1000);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.ShortID(dashAdmin.driver).sendKeys("2300011124");
        TransactionsPage.ReceiptID(dashAdmin.driver).sendKeys("Inv-98-26-04-2023-00005");
       /* jes.executeScript("arguments[0].scrollIntoView(true);",TransactionsPage.Organization(dashAdmin.driver));
        jes.executeScript("arguments[0].click();", TransactionsPage.Organization(dashAdmin.driver));
        WebElement element11 = dashAdmin.driver.findElement(By.xpath("//div[@class='ant-legacy-form-item-control has-success']//div[@class='ant-select-selection-overflow-item ant-select-selection-overflow-item-suffix']"));
        element11.sendKeys("Eman enterprice");
        element11.sendKeys(Keys.ENTER);
        TransactionsPage.Venue(dashAdmin.driver).sendKeys("venu enterprice");
        Thread.sleep(1000);
        TransactionsPage.Venue(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Vendor(dashAdmin.driver).sendKeys("venu enterprice");
        Thread.sleep(1000);
        TransactionsPage.Vendor(dashAdmin.driver).sendKeys(Keys.ENTER);*/
        TransactionsPage.User(dashAdmin.driver).sendKeys("Eman Hilmy");
        WebElement element22= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Eman Hilmy']"));
        jes.executeScript("arguments[0].click();", element22);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys("samsung-aac1f34d6663c26e");
        Thread.sleep(2500);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Product(dashAdmin.driver).sendKeys("benzene 80");
        Thread.sleep(2000);
        TransactionsPage.Product(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.VenueCode(dashAdmin.driver).sendKeys("150875");
       TransactionsPage.VenueCity(dashAdmin.driver).sendKeys("تبوك");
        Thread.sleep(2000);
        TransactionsPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        jes.executeScript("arguments[0].scrollIntoView(true);",TransactionsPage.ApplyButton(dashAdmin.driver));
        jes.executeScript("arguments[0].click();", TransactionsPage.ApplyButton(dashAdmin.driver));
        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();

        // Verify the transaction ID appears in information tab
        WebElement element = dashAdmin.driver.findElement(By.xpath("(//td[.='Account Charge'])[1]//parent::tr//button[1][@type='button']"));
        jes.executeScript("arguments[0].click();",element);

        WebElement element1 = dashAdmin.driver.findElement(By.xpath("//code[normalize-space()='40294e99-a5cf-4a33-b379-21761742bb6c']"));
        element1.getText();
        String actual = element1.getText();
        System.out.println(actual);
        String expected = "40294e99-a5cf-4a33-b379-21761742bb6c";
        softAssert.assertEquals(expected,actual);

        // Verify the receipt ID appears in receipt tab
        TransactionsPage.ReceiptTab(dashAdmin.driver).click();
        WebElement element2 = dashAdmin.driver.findElement(By.xpath("(//div[@class='ant-col ant-col-16'])[1]"));
        element2.getText();
        String actual1 = element2.getText();
        System.out.println(actual1);
        String expected1 = "Receipt ID:Inv-98-26-04-2023-00005";
        softAssert.assertEquals(expected1,actual1);

        softAssert.assertAll();
    }
    @Test(priority = 1)
    public void VehicleCardChargeFilter() throws InterruptedException {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        TransactionsPage.TransactionID(dashAdmin.driver).sendKeys("7ed7e4bd-516c-4f6b-afa3-c15249af0063");
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys("Vehicles Card Charge");
        Thread.sleep(1000);
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Status(dashAdmin.driver).sendKeys("Success");
        Thread.sleep(1000);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys("Woqody Chip");
        Thread.sleep(1000);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.ShortID(dashAdmin.driver).sendKeys("2300011324");
        TransactionsPage.ReceiptID(dashAdmin.driver).sendKeys("Inv-98-30-04-2023-00001");
        TransactionsPage.User(dashAdmin.driver).sendKeys("Eman Hilmy");
        WebElement element22= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Eman Hilmy']"));
        jes.executeScript("arguments[0].click();", element22);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys("samsung-b34a70734a8b1c5c");
        Thread.sleep(2500);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Product(dashAdmin.driver).sendKeys("oils");
        Thread.sleep(2000);
        TransactionsPage.Product(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.VenueCode(dashAdmin.driver).sendKeys("150875");
        TransactionsPage.CardID(dashAdmin.driver).sendKeys("200136c5-a5bc-415d-aed9-f9dfb6bed2ad");
        TransactionsPage.StockID(dashAdmin.driver).sendKeys("83");
        jes.executeScript("arguments[0].scrollIntoView(true);",TransactionsPage.ApplyButton(dashAdmin.driver));
        jes.executeScript("arguments[0].click();", TransactionsPage.ApplyButton(dashAdmin.driver));
        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();


        // Verify the transaction ID appears in information tab
        WebElement element = dashAdmin.driver.findElement(By.xpath("(//td[.='Vehicles Card Charge'])[1]//parent::tr//button[1][@type='button']"));
        jes.executeScript("arguments[0].click();",element);

        WebElement element1 = dashAdmin.driver.findElement(By.xpath("//code[normalize-space()='7ed7e4bd-516c-4f6b-afa3-c15249af0063']"));
        element1.getText();
        String actual = element1.getText();
        System.out.println(actual);
        String expected = "7ed7e4bd-516c-4f6b-afa3-c15249af0063";
        softAssert.assertEquals(expected,actual);

        // Verify the receipt ID appears in receipt tab
        TransactionsPage.ReceiptTab(dashAdmin.driver).click();
        WebElement element2 = dashAdmin.driver.findElement(By.xpath("(//div[@class='ant-col ant-col-16'])[1]"));
        element2.getText();
        String actual1 = element2.getText();
        System.out.println(actual1);
        String expected1 = "Receipt ID:Inv-98-30-04-2023-00001";
        softAssert.assertEquals(expected1,actual1);

        softAssert.assertAll();

    }


    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
