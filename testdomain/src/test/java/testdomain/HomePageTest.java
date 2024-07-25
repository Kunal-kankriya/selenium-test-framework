package testdomain;

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
        Login login=new Login(driver);
        login.login(environment.getPersonalNumber(),environment.getPassword());
        HomePage homePage=new HomePage(driver);
        homePage.homePage();
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        Login login=new Login(driver);
        login.logout();
        driver.close();
    }
}
