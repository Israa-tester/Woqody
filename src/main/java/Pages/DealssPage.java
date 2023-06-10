package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealssPage {
    private static WebElement element;

    //------------------------------------------------------------------------------------------
    public static WebElement DealsLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@href='/deals']"));
        return element;
    }
    public static WebElement CreateNewDeal(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealStatus(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@aria-checked='true']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealArabicTiltle(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealGift(WebDriver driver) {
        element = driver.findElement(By.xpath("(//input[@role='combobox'])[3]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement NewGiftLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='flex row']//div//button[@type='button']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement GiftClose(WebDriver driver) {
        element = driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealAmount(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@role='spinbutton']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealAllVenue(WebDriver driver) {
        element = driver.findElement(By.xpath("(//button[contains(@role,'switch')])[2]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealOrganization(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[1]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealVenues(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div)[235]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement DealProducts(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[3]"));
        return element;
    }

    //-----------------------------------------------------------------------------------------
    public static WebElement ValidUntilFrom(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='From']"));
        return element;
    }

    //-----------------------------------------------------------------------------------------

    public static WebElement CongratulationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@data-contents='true'])[1]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement ArabicCongratulationMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@data-block='true'])[2]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement DealDescription(WebDriver driver) {
        element = driver.findElement(By.xpath("(//div[@data-block='true'])[3]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement DealSave(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement AddConfirmMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'New deal created successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement EditLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-active ant-dropdown-menu-item-only-child list-items-left']//span[contains(text(),'Edit Deal')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    public static WebElement EditConfirmMessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'AutoDeal One updated successfully')]"));
        return element;
    }
    //-----------------------------------------------------------------------------------------
    //////////////////////////Delete Deal//////////////////////////////////////
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
