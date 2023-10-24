package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cards {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    //------------------Single Card Form-------------------------
    public static WebElement Cardslink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@href='/cards']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    /////////////Single Card/////////////////
    public static WebElement CreateSingleCard(WebDriver driver) {
        element = driver.findElement(By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[5]/button[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardType(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[2]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardAmount(WebDriver driver) {
        element = driver.findElement(By.id("cards_form_amount"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardStock(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search')]//input[contains(@role,'combobox')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement EnterpriseBalance(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='ant-tag ant-tag-green']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardLabel(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_cardName']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardUser(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-legacy-form-item-control']//input[@role='combobox']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardEnableOverDraft(WebDriver driver) {
        element = driver.findElement(By.id("cards_form_isOverdraftEnabled"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardOverDraftLimit(WebDriver driver) {
        element = driver.findElement(By.id("cards_form_overdraftLimit"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardEnableDaily(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='cards_form_isCardsDailyLimitEnabled']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardDailyLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_cardDailyTrxLimits']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardEnableMonthly(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='cards_form_isCardsMonthlyLimit']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardMonthlyLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_CardsMonthlyLimit']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardEnableLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("(//button[@role='switch'])[5]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardMaxLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_maxLimit']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardMinLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_minLimit']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardTopupSchedulerEnable(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='cards_form_isCardsScheduler']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardCeilingTopup(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'ant-modal-root')]//label[2]//span[2]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement CardFixedTopup(WebDriver driver) {
        element = driver.findElement(By.xpath("//label[@class='ant-radio-button-wrapper']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardtopupAmount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_chargedAmount']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardtopupPeriod(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@aria-owns='cards_form_cardsSchedulerType_list']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardTopupWeeklyDay(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_cardsWeeklyScheduler']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardTopupMonthlyDay(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_cardsMonthlyScheduler']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardOffDaySundayVehicle(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@value='Sunday']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement BulkOffDaySaturdayEmp(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@value='Saturday']"));
        return element;
    }
    //---------------------------------------------------------------------------------------
    public static WebElement CardSave(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CardConfirmationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'New card(s) created successfully')]"));
        return element;
    }
     //------------------------------------------------------------------------------------------
     public static WebElement CardEditConfirmationMessage(WebDriver driver) {
         element = driver.findElement(By.xpath("//span[normalize-space()='Card updated successfully']"));
         return element;
     }
    //------------------------------------------------------------------------------------------
    public static WebElement AmountCard(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='ant-descriptions-item-content']//span[@class='ant-tag ant-tag-has-color']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement ClosePopup(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@aria-label='Close']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement OrgBalanceInTopup(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='ant-tag ant-tag-green']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    //------------------Bulk of Card Form-------------------------
     public static WebElement BulkOfCardsLink(WebDriver driver) {
         element = driver.findElement(By.xpath("//div[contains(@class,'ant-page-header page__header ant-page-header-ghost')]//div[3]//button[1]"));
         return element;
     }
    //------------------------------------------------------------------------------------------
    public static WebElement BulkCardsCount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_form_bulk']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement BulkEmployees(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'ant-table-selection')]//input[contains(@type,'checkbox')]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement BulkEnableLimit(WebDriver driver) {
        element = driver.findElement(By.xpath("(//button[@role='switch'])[1]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    //-----------------------Upload Bulk Of Cards-----------------------------------

    public static WebElement UploadBulkLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'ant-space ant-space-horizontal ant-space-align-center')]//div[1]//button[1]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement StockUploadCard(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']//input[@role='combobox']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement BulkUploadFile(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@type='file']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement UploadBulkConfirmationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'(2) bulk cards created successfully.')]"));
        return element;
    }
    //------------------------------------------------------------------------------------------

    //////////////////////////Delete Card//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement DeleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-dangerous']"));
        return element;
    }
    public static WebElement CardDeleteMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
        return element;
    }
    /////////////////////////Filter cards//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement FilterPart(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@role='button']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement CardID(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_filters_forms_id']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement CardLabelFilter(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_filters_forms_$displayTitle']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement CardsAmount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_filters_forms_amount']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement FilterApply(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    //////////////////////////Topup and deduct Card//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement Amount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='cards_topup_form_amount']"));
        return element;
    }
    public static WebElement Topupbutton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(text(),'Top-up')]"));
        return element;
    }
    public static WebElement Deductbutton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Deduct']"));
        return element;
    }
    public static WebElement Okbutton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"));
        return element;
    }
    public static WebElement TransactionSuccessMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Transaction made successfully')]"));
        return element;
    }
}
