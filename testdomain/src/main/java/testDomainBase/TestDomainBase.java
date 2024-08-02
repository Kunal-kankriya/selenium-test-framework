package testDomainBase;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

public class TestDomainBase extends ExtentReportListener {

    protected WebDriver driver;
    protected ExcelUtils excelUtils = null;
    public EnvConfig envConfig;

    @BeforeTest(alwaysRun = true)
    public void loadTestData(){
        Base.clearDirectories();
    //    this.envConfig=EnvConfig.getInstance();
     //   this.excelUtils = new ExcelUtils(envConfig.getProperty("excelTestDataPath"));
    }
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void startBrowser(@Optional("chrome") String browser){
        this.envConfig=EnvConfig.getInstance();
        this.excelUtils = new ExcelUtils(envConfig.getProperty("excelTestDataPath"));
        driver=BrowserFactory.getBrowser(browser);
        Base.windowSetup(driver);
        driver.get(this.envConfig.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void testResult(ITestResult result){
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
    public void closeBrowser(){
        driver.quit();
    }

}
