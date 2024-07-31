package utils;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.LinkedList;

public class Base extends ExtentReportListener {
    public static WebDriver driver;
    protected ExcelUtils excelUtils = null;
    public final LinkedList<Row> rowList = new LinkedList<>();

    @BeforeTest(alwaysRun = true)
    public void getEnvironment() {
        String path = System.getProperty("user.dir");
        Common.clearDirectory(path + "/Report");
        Common.clearDirectory(path + "/Screenshots");
        this.excelUtils = new ExcelUtils(EnvConfig.getProperty("excelTestDataPath"));
        Sheet sheet = excelUtils.getSheet("dashboard");
        for (Row row : sheet) {
            this.rowList.add(row);
        }
    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void startBrowser(@Optional("chrome") String browser) {
        this.driver = BrowserFactory.getBrowser(browser);
        driver.get(EnvConfig.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {

        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Screenshot.getScreenshot(driver, result.getName());
            test.get().log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            test.get().log(Status.FAIL, "Exception: " + result.getThrowable().getStackTrace());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.get().log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
