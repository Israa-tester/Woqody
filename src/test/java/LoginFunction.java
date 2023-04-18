import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginFunction {

    public static void main(String[] args) {
        /////////////////////Login Function/////////////////
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://staging-admin.woqody.tech/login");
        LoginPage.loginusername(driver).sendKeys("admin@woqody-boss.tech");
        LoginPage.loginpassword(driver).sendKeys("@P@2CK550OQylm");
        LoginPage.loginbutton(driver).click();

    }

}
