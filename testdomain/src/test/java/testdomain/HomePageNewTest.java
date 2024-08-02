package testdomain;

import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.*;
import testDomainBase.TestDomainBase;
import utils.*;

import java.util.LinkedList;

@Listeners(utils.ExtentReportListener.class)
public class HomePageNewTest extends TestDomainBase {
    private static LinkedList<Row> rowList=new LinkedList<Row>();

    @Test(alwaysRun = true, priority = 0,groups = {"Smoke","Regression"})
    public void Login() {
        Login login = new Login(driver);
        ExtentTest test = ExtentReportListener.getTest();
      //  login.login(test, envConfig.getProperty("personalNumber"), envConfig.getProperty("password"));
    }

    @Test(alwaysRun = true, priority = 1,groups = {"Smoke","Regression"})
    public void preStep() {
       Cell cell = rowList.get(1).getCell(1);
        String preRequest = excelUtils.getValue(cell);
        ExtentTest test = ExtentReportListener.getTest();
        test.info("Executing pre-requisite task");
        test.info("Executing pre-requisite task");
    }

    @Test(alwaysRun = true, priority = 2,groups = {"Smoke","Regression"})
    public void navigate_To_Dashboard() {
        ExtentTest test = ExtentReportListener.getTest();
        rowList.removeFirst();
        rowList.removeFirst();
        for (Row row : rowList) {
         ElementActions.stepRun(test, driver,row);
        }
    }
}
