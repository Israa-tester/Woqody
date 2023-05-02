import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BeforeAndAfter {

    WebDriver driver;
    public void OpenDashboard(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://staging-admin.woqody.tech/login");
        LoginPage.loginusername(driver).sendKeys("admin@woqody-boss.tech");
        LoginPage.loginpassword(driver).sendKeys("@P@2CK550OQylm");
        LoginPage.loginbutton(driver).click();
    }

    public void CloseDashboard(){
        driver.quit();
    }
}
