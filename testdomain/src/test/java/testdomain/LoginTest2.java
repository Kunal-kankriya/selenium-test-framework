package testdomain;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testDomainBase.TestDomainBase;

@Listeners(utils.ExtentReportListener.class)
public class LoginTest2 extends TestDomainBase {

    @Test(groups = {"Smoke"}, priority = 0)
    public void Login() {
        test.get().info("Test Started : ");
        Login login = new Login(driver);
        test.get().log(Status.INFO, "Login Started");
        // login.login(test.get(), envConfig.getProperty("personalNumber"), envConfig.getProperty("password"));
        test.get().log(Status.PASS, "Logged In");
        test.get().pass("Test Passed");
    }

    @Test(groups = {"Smoke"}, priority = 1)
    public void test1() {
        test.get().info("Test Started : ");
        test.get().info("Test method 1");
        test.get().pass("Test Passed");
    }

    @Test(groups = {"Smoke"}, priority = 2)
    public void test2() {
        test.get().info("Test Started : ");
        test.get().info("Test method failed 2");
        Assert.fail();
        test.get().pass("Test Passed");
    }

    @Test(groups = {"Smoke"}, priority = 3, dependsOnMethods = "test2")
    public void test3() {
        test.get().info("Test Started : ");
        test.get().info("Test method pass 3");
        Assert.fail();
        test.get().pass("Test Passed");

    }

    @Test(groups = {"Smoke"}, priority = 4)
    public void test4() {
        test.get().info("Test Started : ");
        test.get().info("Test method pass 4");
        test.get().pass("Test Passed");
    }

    @Test(groups = {"Smoke"}, priority = 5)
    public void test5() {
        test.get().info("Test Started : ");
        test.get().info("Test method pass 5");
        test.get().pass("Test Passed");

    }

    @Test(groups = {"Smoke"}, priority = 6)
    public void test6() {
        test.get().info("Test Started : ");
        test.get().info("Test method pass 6");
        test.get().pass("Test Passed");

    }

    @Test(groups = {"Smoke"}, priority = 7)
    public void test7() {
        test.get().info("Test Started : ");
        test.get().info("Test method pass 7");
        test.get().pass("Test Passed");
    }

}
