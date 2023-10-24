import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BeforeAndAfter extends VariablesData {

    public static WebDriver driver;

    public void OpenDashboard() {

        WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://staging-admin.woqody.tech/login");
        LoginPage.loginusername(driver).sendKeys("admin@woqody-boss.tech");
        LoginPage.loginpassword(driver).sendKeys("@P@2CK550OQylm");
        LoginPage.loginbutton(driver).click();



    }

    public void takeScreenShot(String methodName) throws IOException{

        Date currentDate = new Date();
        String screenShoteFileName = currentDate.toString().replace(" ","-").replace(":","-");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screenshot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File("./screenShots/" + methodName + screenShoteFileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void CloseDashboard(){
        driver.quit();
    }
}
