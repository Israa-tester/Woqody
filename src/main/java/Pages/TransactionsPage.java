package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionsPage {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    public static WebElement Transactionslink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@href='/transactions']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    /////////////Filter Form/////////////////
    public static WebElement FilterOpen(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@aria-label='caret-right']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CreationDateFrom(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='From']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement TransactionID(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-collapse-content-box']//div[1]//div[2]//div[2]//div[1]//span[1]//input[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement TransactionType(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@aria-owns='transactions_filters_form_type_list']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement Status(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@aria-owns='transactions_filters_form_status_list']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement PaymentMethod(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@aria-owns='transactions_filters_form_paymentMethodType_list']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement PaymentMethodID(WebDriver driver) {
        element = driver.findElement(By.id("transactions_filters_form_paymentMethodId"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ShortID(WebDriver driver) {
        element = driver.findElement(By.id("transactions_filters_form_transactionNumber"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ReceiptID(WebDriver driver) {
        element = driver.findElement(By.id("transactions_filters_form_customerInvoiceId"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement Organization(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div)[98]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement Venue(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-multiple ant-select-allow-clear ant-select-show-arrow ant-select-open ant-select-show-search']//input[@role='combobox']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement Vendor(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-multiple ant-select-allow-clear ant-select-show-arrow ant-select-open ant-select-show-search']//div[@class='ant-select-selection-overflow']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement User(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[7]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement POSNumber(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[8]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement Product(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[9]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardEnterpriseOrg(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[10]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement VenueCode(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement VenueCity(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[11]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardID(WebDriver driver) {
        element = driver.findElement(By.id("transactions_filters_form_cardId"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardLabel(WebDriver driver) {
        element = driver.findElement(By.id("transactions_filters_form_cardName"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement StockID(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@type='text'])[9]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ApplyButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ReceiptTab(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(text(),'Receipt')]"));
        return element;
    }

   }
