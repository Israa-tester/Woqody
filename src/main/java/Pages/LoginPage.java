package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
     private static WebElement element = null;
    //------------------------------------------------------------------------------------------------
    public static WebElement  loginusername (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//*[@id=\"login_email\"]"));
        return element;
    }

    public static WebElement  loginpassword(WebDriver driver )
    {
        element = driver.findElement(By.xpath("//*[@id=\"login_password\"]"));
        return element;
    }

    public static WebElement loginbutton(WebDriver driver )
    {
        element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[3]/div/div/span/button"));
        return element;
    }


}
