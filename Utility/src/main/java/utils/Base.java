package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Base {
    protected ExtentReports extent;
    protected static ExtentTest test;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        String reportPath = System.getProperty("user.dir") + "/Report/ExtentReport.html";
        extent = Report.getInstance(reportPath,"Execution Report","Report Name");
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        test = extent.createTest(getClass().getSimpleName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Exception: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

    }


}
