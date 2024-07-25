package devdomain;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Base;
import utils.Environment;

public class ErpHomePageTest extends Base {
    Environment environment;
    @Parameters({"env", "browser"})
    @BeforeClass(alwaysRun = true)
    public void startBrowser(String env, String browser) {
        environment = new Environment(env);
        driver = getDriver(environment.getUrl(), browser);
    }

    @Test(groups = {"Smoke"})
    public void erpHomePage(){
        test.info("Test Started : ");
        ErpHomePage erpHomePage=new ErpHomePage(driver);
        erpHomePage.erpHome();
        test.pass("Test Passed");
    }
}
