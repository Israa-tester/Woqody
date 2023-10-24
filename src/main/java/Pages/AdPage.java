package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdPage {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    public static WebElement AdLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//li[contains(@title,'Ads')]//a[contains(@class,'layout__link')]"));
        return element;
    }
    public static WebElement CreateNewAd(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdStatus(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@role='switch']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[contains(@data-__meta,'[object Object]')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdPlacement(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-show-arrow']//div[@class='ant-select-selector']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdImage(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@type='file']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdOrg(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']//input[@role='combobox']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdCampaign(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdSaveButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdConfirmationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'New AD created successfully')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement AdEditMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'updated successfully')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    //////////////////////////Delete Ad//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement DeleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default ant-btn-dangerous']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement AdDeleteMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
}
