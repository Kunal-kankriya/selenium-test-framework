package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.time.Duration;

public class Base {
    protected ExtentReports extent;
    protected static ExtentTest test;
    public static WebDriver driver;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        String reportPath = System.getProperty("user.dir") + "/Report/ExtentReport.html";
        extent = Report.getInstance(reportPath,"Execution Report","Report Name");
        test = extent.createTest(getClass().getSimpleName());
    }
    @BeforeMethod(alwaysRun = false)
    public void beforeMethod() {

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath=Screenshot.getScreenshot(driver,result.getName());
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            test.log(Status.FAIL, "Exception: " + result.getThrowable().getStackTrace());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

    }

    public static final WebDriver getDriver(String url,String browser){
        WebDriver driver = null;
        if(url!=null&&browser!=null){
            String resourcePath = System.getProperty("user.dir");
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Unsupported browser: " + browser);
                    break;
            }
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(40000));
        }

        return driver;
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        extent.flush();
    }

}
