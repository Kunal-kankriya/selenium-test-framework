package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String reportPath,String reportTitle,String reportName) {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle(reportTitle);
            sparkReporter.config().setReportName(reportName);
            sparkReporter.config().setTheme(Theme.STANDARD);
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}
