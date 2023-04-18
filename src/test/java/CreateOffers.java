
import Pages.OffersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CreateOffers {
    BeforeAndAfter dashAdmin;
    @BeforeMethod
    public void CreateNewOffer(){

        dashAdmin= new BeforeAndAfter();
        dashAdmin.OpenDashboard();
        ///////Scroll the menu sidebar//////////////////////

        WebElement offerMenu = dashAdmin.driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/aside[1]/div[1]/div[1]/ul[1]/li[18]/div[1]/span[1]"));
        JavascriptExecutor je = (JavascriptExecutor) dashAdmin.driver;
        je.executeScript("arguments[0].scrollIntoView(true);",offerMenu);
        je.executeScript("arguments[0].click()", offerMenu);
        //////////////////////////////////////
        OffersPage.OffersLink(dashAdmin.driver).click();
        je.executeScript("arguments[0].scrollIntoView(true);", OffersPage.CreateNewOffer(dashAdmin.driver));
        je.executeScript("arguments[0].click()",OffersPage.CreateNewOffer(dashAdmin.driver));
    }

    @Test(priority = 0)
    public void CreateNormalOffer() {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("AutoNormal");
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Bsnk')]"));
        jes.executeScript("arguments[0].click()", cat);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Solar Normal')]"));
        jes.executeScript("arguments[0].click()", org);
        OffersPage.OfferNormalVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Solar delivery']"));
        jes.executeScript("arguments[0].click()", ven);
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Description Normal Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 1)
    public void CreateWatchWinOffer() {
        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("AutoWatchWin");
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement watch = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Watch & Win')]"));
        jes.executeScript("arguments[0].click()", watch);
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("10");
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Bsnk')]"));
        jes.executeScript("arguments[0].click()", cat);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Solar Normal')]"));
        jes.executeScript("arguments[0].click()", org);
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Solar delivery']"));
        jes.executeScript("arguments[0].click()", ven);
        OffersPage.OfferVideo(dashAdmin.driver).sendKeys("C:\\Users\\ag\\Desktop\\rabbit.mp4");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Description Normal Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 2)
    public void CreateClickWinOffer() {

        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("AutoClickWin");
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement click = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Click & Win')]"));
        jes.executeScript("arguments[0].click()", click);
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("10");
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Bsnk')]"));
        jes.executeScript("arguments[0].click()", cat);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Solar Normal')]"));
        jes.executeScript("arguments[0].click()", org);
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Solar delivery']"));
        jes.executeScript("arguments[0].click()", ven);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys("https://www.google.com/");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Description Normal Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 3)
    public void CreateDownloadWinOffer(){

        JavascriptExecutor jes = (JavascriptExecutor) dashAdmin.driver;
        OffersPage.OfferTitle(dashAdmin.driver).sendKeys("AutoDownloadWin");
        OffersPage.OfferType(dashAdmin.driver).click();
        WebElement click = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Download & Win')]"));
        jes.executeScript("arguments[0].click()", click);
        OffersPage.OfferCashBackAmount(dashAdmin.driver).sendKeys("16");
        OffersPage.offerCategory(dashAdmin.driver).click();
        WebElement cat= dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Bsnk')]"));
        jes.executeScript("arguments[0].click()", cat);
        OffersPage.OfferOrg(dashAdmin.driver).click();
        WebElement org = dashAdmin.driver.findElement(By.xpath("//div[contains(text(),'Solar Normal')]"));
        jes.executeScript("arguments[0].click()", org);
        OffersPage.OfferWinVenue(dashAdmin.driver).click();
        WebElement ven= dashAdmin.driver.findElement(By.xpath("//span[normalize-space()='Solar delivery']"));
        jes.executeScript("arguments[0].click()", ven);
        OffersPage.OffercaptionLink(dashAdmin.driver).sendKeys("https://www.google.com/");
        OffersPage.OfferDescripe(dashAdmin.driver).sendKeys("Description Normal Offer");
        OffersPage.OfferSave(dashAdmin.driver).click();
        OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        String actual  = OffersPage.OfferConfirmationMessage(dashAdmin.driver).getText();
        System.out.println(actual);
        String expected = "New offer created successfully";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void CloseBrowser(){
        dashAdmin.CloseDashboard();
    }

}
