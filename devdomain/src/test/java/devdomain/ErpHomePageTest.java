package devdomain;

import devdomainBase.DevDomainBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Base;
import utils.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ErpHomePageTest extends DevDomainBase {

    @Test(groups = {"Smoke"})
    public void erpHomePage() {
        test.get().info("Test Started : ");
        ErpHomePage erpHomePage = new ErpHomePage(driver);
        erpHomePage.erpHome();
        test.get().pass("Test Passed");
    }

    @Test(groups = {"Regression"})
    public void RegressionTest() {
        System.out.println("Regression Test Executed");
    }

}
