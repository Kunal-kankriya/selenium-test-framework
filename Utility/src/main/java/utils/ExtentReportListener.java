package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public ExtentReports extent;

    public static ExtentTest getTest() {
        return test.get();
    }


    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir");
        String suiteName = context.getSuite().getName();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath + "/Report/" + suiteName + ".html");
        sparkReporter.config().setReportName(suiteName);
        sparkReporter.config().setDocumentTitle(suiteName + " Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().info(result.getTestClass().toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        String path = Screenshot.getScreenshot(Base.driver, result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
        test.get().skip(result.getSkipCausedBy().toString());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        test.remove();
    }
}
