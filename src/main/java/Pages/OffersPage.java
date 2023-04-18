package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    public static WebElement OffersLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@href='/offers']"));
        return element;
    }
    public static WebElement CreateNewOffer(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@data-__meta='[object Object]']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferType(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-single ant-select-show-arrow']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement offerCategory(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='ant-select ant-select-multiple ant-select-allow-clear ant-select-show-arrow ant-select-show-search']//div[@class='ant-select-selector']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferOrg(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[contains(@class,'ant-select ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search')]//div[contains(@class,'ant-select-selector')]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferNormalVenue(WebDriver driver) {
        element = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[1]/span[1]/div[1]/div[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferWinVenue(WebDriver driver) {
        element = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[1]/span[1]/div[1]/div[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferDescripe(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@aria-label='rdw-editor']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferSave(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferCashBackAmount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@role='spinbutton']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OfferVideo(WebDriver driver) {
        element = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/span[1]/div[1]/span[1]/input[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement OffercaptionLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='e.x https://link.to-win.cashback']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------

    public static WebElement OfferConfirmationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'New offer created successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement OfferEditMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'AutoNormal Edit updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement OfferEditMessageWatch(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'AutoWatchWin updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement OfferEditMessageClick(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'AutoClickWin Edit updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement OfferEditMessageDownload(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'AutoDownloadWinEdit updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------
    //////////////////////////Delete Offer//////////////////////////////////////
    //------------------------------------------------------------------------------------------

    public static WebElement DeleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Delete']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
    public static WebElement OfferDeleteMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[normalize-space()='Row deleted successfully']"));
        return element;
    }
    //------------------------------------------------------------------------------------------
}
