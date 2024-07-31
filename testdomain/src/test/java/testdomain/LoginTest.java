package testdomain;

import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.Base;
import utils.EnvConfig;

public class LoginTest extends Base {

        @Test(groups = {"Smoke"})
    public void Login() {
        test.get().info("Test Started : ");
        Login login = new Login(driver);
        test.get().log(Status.INFO, "Login Started");
        login.login(test.get(), EnvConfig.getProperty("personalNumber"), EnvConfig.getProperty("password"));
        test.get().log(Status.PASS, "Logged In");
        test.get().pass("Test Passed");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Login login = new Login(driver);
        login.logout();
        driver.close();
    }
}
