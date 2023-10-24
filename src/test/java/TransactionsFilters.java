
import Pages.TransactionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        jes.executeScript("window.scrollBy(0,1000)");

    }
    @Test(priority = 0)
    public void AccountChargeFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        /////// Creation Date/////////

        TransactionsPage.CreationDateFrom(dashAdmin.driver).click();
        WebElement element15= dashAdmin.driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]"));
        jes.executeScript("arguments[0].click();",element15);
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("(//tbody)[2]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(dashAdmin.transfromDay))  jes.executeScript("arguments[0].click();",ele);

        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(dashAdmin.transtoDay))   jes.executeScript("arguments[0].click();",ele1);
        }
        //////////////////////////////
        TransactionsPage.TransactionID(dashAdmin.driver).sendKeys(dashAdmin.transactionID);
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(dashAdmin.transactionType);
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(dashAdmin.transtatus);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(dashAdmin.transPaymentMethod);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.ShortID(dashAdmin.driver).sendKeys(dashAdmin.transShortID);
        TransactionsPage.ReceiptID(dashAdmin.driver).sendKeys(dashAdmin.transReceiptID);
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
        TransactionsPage.User(dashAdmin.driver).sendKeys(dashAdmin.transUser);
        WebElement element22= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='"+dashAdmin.transUser+"']"));
        jes.executeScript("arguments[0].click();", element22);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys(dashAdmin.transPOSNumber);
        Thread.sleep(2000);
        TransactionsPage.POSNumber(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Product(dashAdmin.driver).sendKeys(dashAdmin.transProduct);
        Thread.sleep(2000);
        TransactionsPage.Product(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.VenueCode(dashAdmin.driver).sendKeys(dashAdmin.transVenueCode);
       TransactionsPage.VenueCity(dashAdmin.driver).sendKeys(dashAdmin.transVenueCity);
        Thread.sleep(2000);
        TransactionsPage.VenueCity(dashAdmin.driver).sendKeys(Keys.ENTER);
        jes.executeScript("arguments[0].scrollIntoView(true);",TransactionsPage.ApplyButton(dashAdmin.driver));
        jes.executeScript("arguments[0].click();", TransactionsPage.ApplyButton(dashAdmin.driver));
        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();

        // Verify the transaction ID appears in information tab
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.transactionType+"')]//parent::tr//td[17]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Transactions')]")));
        action.moveToElement(element).moveToElement(elementView).click().build().perform();

        WebElement element1 = dashAdmin.driver.findElement(By.xpath("//code[normalize-space()='"+dashAdmin.transactionID+"']"));
        element1.getText();
        String actual = element1.getText();
        System.out.println(actual);
        String expected = dashAdmin.transactionID;
        softAssert.assertEquals(expected,actual);

        // Verify the receipt ID appears in receipt tab
        TransactionsPage.ReceiptTab(dashAdmin.driver).click();
        WebElement element2 = dashAdmin.driver.findElement(By.xpath("(//div[@class='ant-col ant-col-16'])[1]"));
        element2.getText();
        String actual1 = element2.getText();
        System.out.println(actual1);
        String expected1 = dashAdmin.transReceiptID;
        softAssert.assertEquals(expected1,actual1);

        softAssert.assertAll();
    }
    @Test(priority = 1)
    public void VehicleCardFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(dashAdmin.driver, Duration.ofSeconds(10));
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        /////// Creation Date/////////

        TransactionsPage.CreationDateFrom(dashAdmin.driver).click();
        WebElement element15= dashAdmin.driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]"));
        jes.executeScript("arguments[0].click();",element15);
        List<WebElement> allDatesFrom= dashAdmin.driver.findElements(By.xpath("(//tbody)[2]//td"));
        for(WebElement ele:allDatesFrom){
            String dt1= ele.getText();
            if (dt1.equals(dashAdmin.transfromDay))  jes.executeScript("arguments[0].click();",ele);

        }
        for(WebElement ele1:allDatesFrom){
            String dt2= ele1.getText();
            if (dt2.equals(dashAdmin.transtoDay))   jes.executeScript("arguments[0].click();",ele1);
        }
        TransactionsPage.TransactionID(dashAdmin.driver).sendKeys(dashAdmin.transactionID);
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(dashAdmin.transactionType);
        TransactionsPage.TransactionType(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(dashAdmin.transtatus);
        TransactionsPage.Status(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(dashAdmin.transPaymentMethod);
        TransactionsPage.PaymentMethod(dashAdmin.driver).sendKeys(Keys.ENTER);
        TransactionsPage.ShortID(dashAdmin.driver).sendKeys(dashAdmin.transShortID);
        TransactionsPage.CardEnterpriseOrg(dashAdmin.driver).sendKeys(dashAdmin.transEnterpriseOrg);
        //Thread.sleep(2000);
        WebElement element33= dashAdmin.driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content') and contains(text(),'"+dashAdmin.transEnterpriseOrg+"')]"));
        jes.executeScript("arguments[0].click();", element33);
        TransactionsPage.CardID(dashAdmin.driver).sendKeys(dashAdmin.transCardID);
        TransactionsPage.CardLabel(dashAdmin.driver).sendKeys(dashAdmin.transCardLabel);
        TransactionsPage.StockID(dashAdmin.driver).sendKeys(dashAdmin.transCardStock);
        jes.executeScript("arguments[0].scrollIntoView(true);",TransactionsPage.ApplyButton(dashAdmin.driver));
        jes.executeScript("arguments[0].click();", TransactionsPage.ApplyButton(dashAdmin.driver));
        Thread.sleep(2000);

        SoftAssert softAssert = new SoftAssert();


        // Verify the transaction ID appears in information tab
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[starts-with(.,'"+dashAdmin.transactionType+"')]//parent::tr//td[17]//span")));
        Actions action = new Actions(dashAdmin.driver);
        action.moveToElement(element).perform();
        WebElement elementView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'View Transaction')]")));
        action.moveToElement(element).moveToElement(elementView).click().build().perform();

        WebElement element1 = dashAdmin.driver.findElement(By.xpath("//code[normalize-space()='"+dashAdmin.transactionID+"']"));
        element1.getText();
        String actual = element1.getText();
        System.out.println(actual);
        String expected = dashAdmin.transactionID;
        softAssert.assertEquals(expected,actual);

        softAssert.assertAll();

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }
}
