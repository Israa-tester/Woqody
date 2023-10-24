package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
     private static WebElement element = null;
    //------------------------------------------------------------------------------------------------
    public static WebElement loginusername (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        return element;
    }

    public static WebElement loginpassword (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        return element;
    }

    public static WebElement loginbutton(WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        return element;
    }


}
