package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardStockPage {
    private static WebElement element;
    //------------------------------------------------------------------------------------------
    public static WebElement  CardStocklink (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//body[1]/div[1]/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[6]/ul[1]/li[2]/span[1]/a[1]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  NewCardStock (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/button[1]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  CardStockTitle (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_title']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockType (WebDriver driver )

    {
       element = driver.findElement(By.xpath("//input[@id='stocks_form_type']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  CardStockOrg (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']//input[@role='combobox']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockEnableOverhead (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//button[@id='stocks_form_isCardsOverdraftEnabled']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockOverheadLimit (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_cardsOverdraftLimit']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockEnableDaily (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//button[@id='stocks_form_isCardsStocksDailyLimitEnabled']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockDailyLimit (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_cardsStockDailyTrxLimits']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockEnableMonthly (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//button[@id='stocks_form_isCardsStocksMonthlyLimit']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockMonthlyLimit (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_CardsStocksMonthlyLimit']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockTopupSchedulerEnable (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//button[@id='stocks_form_isCardsStocksScheduler']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockCeilingTopup (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//span[contains(text(),'Ceiling Top-Up Amount')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StocktopupAmount (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_chargedAmount']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StocktopupPeriod (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_schedulerType']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockTopupWeeklyDay (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_cardsStocksWeeklyScheduler']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockTopupMonthlyDay (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//input[@id='stocks_form_cardsStocksScheduler']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockOffDayMonday (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[3]/label[1]/span[1]/input[1]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockSave (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockConfirmationMessage (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//span[contains(text(),'New stock created successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockEditConfirmationMessage (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//span[contains(text(),'Stock updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement  StockTypeList (WebDriver driver )

    {
        element = driver.findElement(By.xpath(""));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    //////////////////////////Delete Stock//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement DeleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement StockDeleteMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
        return element;
    }
    //------------------------------------------------------------------------------------------

    /////////////////////////Filter Stock//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement FilterPart(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@role='button']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement OrgNameFilter(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='rc_select_12']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement FilterStockType(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_type']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement CardsCount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='transactions_filters_form_cardsAmount']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement FilterApply(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    ////////////////////////topup Stock//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement TopupFile(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@type='file']"));
        return element;
    }
    //------------------------------------------------------------------------------------------

    public static WebElement  StockConfirmationTopup (WebDriver driver )

    {
        element = driver.findElement(By.xpath("//span[contains(text(),'Cards top-up successfully.')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------

}
