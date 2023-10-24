package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdCampaignPage {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    public static WebElement AdCampaignLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//li[contains(@title,'Campaigns')]"));
        return element;
    }
    public static WebElement CreateNewCampaign(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignStatus(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='campaign_form_isActive']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignName(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='campaign_form_name']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OrgCampaign(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']//input[@role='combobox']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ValidForm(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='From']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignSave(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignConfirmationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'New Campaign created successfully')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignEditMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'updated successfully')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement CampaignvalidUntilWeek(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='This week']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    //////////////////////////Delete Campaign//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement DeleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-default ant-btn-dangerous')]"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement CampaignDeleteMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
}
