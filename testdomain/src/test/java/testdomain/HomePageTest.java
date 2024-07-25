package testdomain;

import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Base;
import utils.Environment;

public class HomePageTest extends Base {
    Environment environment;

    @Parameters({"env", "browser"})
    @BeforeClass(alwaysRun = true)
    public void startBrowser(String env, String browser) {
        environment = new Environment(env);
        driver = getDriver(environment.getUrl(), browser);
    }
    @Test(groups = {"Smoke"})
    public void HomePage(){
        test.info("Test Started : ");
        Login login=new Login(driver);
        test.log(Status.INFO,"Login Started");
        login.login(environment.getPersonalNumber(),environment.getPassword());
        test.log(Status.INFO,"Logged In");
        HomePage homePage=new HomePage(driver);
        test.info("Home Page Test Started : ");
        homePage.homePage();
        test.info("Home Page Test Passed : ");
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        Login login=new Login(driver);
        login.logout();
        driver.close();
    }
}
