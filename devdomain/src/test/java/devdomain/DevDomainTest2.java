package devdomain;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Base;

public class DevDomainTest2 extends Base {
    @Test(groups = {"Smoke"})
    public void testMethod1() {
        System.out.println("DevDomainTest2");
        DevDomain dd = new DevDomain();
        test.info("Starting Smoke Test");
        dd.firstMethod();
        test.pass("Test passed");
    }

    @Test(groups = {"Regression"})
    public void testMethod2() {
        System.out.println("DevDomainTest2");
        DevDomain dd = new DevDomain();
        test.info("Starting Regression Test");
        dd.secondMethod();
        test.pass("Test passed");
    }

    @Test(groups = {"Smoke", "Regression"})
    public void testMethod3() {
        System.out.println("DevDomainTest2");
        DevDomain dd = new DevDomain();
        test.info("Starting Smoke & Regression");
        dd.thirdMethod();
        Assert.assertTrue(false);
        test.pass("Test passed");
    }
}
