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
    public static ExtentReports extent;

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
        sparkReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().info(result.getInstanceName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
       // String path = Screenshot.getScreenshot(driver, result.getMethod().getMethodName());
       // test.get().addScreenCaptureFromPath(path);
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
        int passedTests = context.getPassedTests().size();
        int failedTests = context.getFailedTests().size();
        int skippedTests = context.getSkippedTests().size();
        int totalTests = passedTests + failedTests + skippedTests;
        String suiteName = context.getSuite().getName();

        double passPercentage = totalTests > 0 ? (double) passedTests / totalTests * 100 : 0;


        String summaryHtml = "<h3>Suite Summary</h3>" +
                "<table border='1' style='width:100%; border-collapse: collapse;'>" +
                "<tr>" +
                "<th>Suite Name</th>" +
                "<th>Pass Tests</th>" +
                "<th>Fail Tests</th>" +
                "<th>Skip Tests</th>" +
                "<th>Pass %</th>" +
                "</tr>" +
                "<tr>" +
                "<td>" + suiteName + "</td>" +
                "<td>" + passedTests + "</td>" +
                "<td>" + failedTests + "</td>" +
                "<td>" + skippedTests + "</td>" +
                "<td>" + String.format("%.2f", passPercentage) + "%</td>" +
                "</tr>" +
                "</table>";
        ExtentTest summaryTest = extent.createTest("Summary Report");
        summaryTest.info(summaryHtml);
        extent.flush();
        test.remove();
    }
}
