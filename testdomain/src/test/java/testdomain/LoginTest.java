package testdomain;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Base;
import utils.Environment;
import utils.EnvironmentUtils;

public class LoginTest extends Base {
    @Parameters({"env","browser"})
    @BeforeClass(alwaysRun = true)
    public void startBrowser(String env,String browser){
        Environment environment=new Environment(env);
        driver=getDriver(environment.getUrl(),browser);
    }
    @Test(groups = {"Smoke"})
    public void Login(){

    }
}
