package testdomain;

import org.testng.annotations.Test;
import utils.Base;

public class TestDomainTest2 extends Base {

    @Test(groups = {"Smoke"})
    public void testMethod1(){
        System.out.println("TestDomain2");
        TestDomain td=new TestDomain();
       // test.info("Starting Smoke Test");
        td.firstMethod();
       // test.pass("Test passed");
    }

    @Test(groups = {"Regression"})
    public void testMethod2(){
        System.out.println("TestDomain2");
        TestDomain td=new TestDomain();
      //  test.info("Starting Regression Test ");
        td.secondMethod();
      //  test.pass("Test passed");
    }
    @Test(groups = {"Smoke","Regression"})
    public void testMethod3(){
        System.out.println("TestDomain2");
        TestDomain td=new TestDomain();
      //  test.info("Starting Smoke & Regressiom");
        td.thirdMethod();
      //  test.pass("Test passed");
    }
}
