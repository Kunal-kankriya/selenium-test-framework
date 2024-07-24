package testdomain;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Base;
import utils.Report;

public class TestDomainTest extends Base {

    @Test(groups = {"Smoke"})
    public void testMethod1(){
        System.out.println("TestDomain");
        TestDomain td=new TestDomain();
        test.info("Starting Smoke Test");
        td.firstMethod();
        test.pass("Test passed");
    }

    @Test(groups = {"Regression"})
    public void testMethod2(){
        System.out.println("TestDomain");
        TestDomain td=new TestDomain();
        test.info("Starting Regression Test ");
        td.secondMethod();
        test.pass("Test passed");
    }
    @Test(groups = {"Smoke","Regression"})
    public void testMethod3(){
        System.out.println("TestDomain");
        TestDomain td=new TestDomain();
        test.info("Starting Smoke & Regressiom");
        td.thirdMethod();
        test.pass("Test passed");
    }
}
