package testdomain;

import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.*;
import utils.*;

@Listeners(utils.ExtentReportListener.class)
public class HomePageNewTest extends Base{

    @Test(alwaysRun = true, priority = 0,groups = {"Smoke","Regression"})
    public void Login() {
        Login login = new Login(driver);
        ExtentTest test = ExtentReportListener.getTest();
        login.login(test, EnvConfig.getProperty("personalNumber"), EnvConfig.getProperty("password"));
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
            ElementActions.stepRun(test, row);
        }
    }
}
