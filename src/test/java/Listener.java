import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;


public class Listener implements ITestListener {

    BeforeAndAfter dashAdmin = new BeforeAndAfter();
    public  void onTestSuccess(ITestResult result){
        String testName = result.getName();
        System.out.println("******* Wow  "+testName+"  test has passed *******");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");

        String methodName=result.getName().toString().trim();
        try {
           dashAdmin.takeScreenShot(methodName);
        }catch (IOException e){
            e.printStackTrace();
        }
        dashAdmin.CloseDashboard();
    }


}
