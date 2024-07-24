package testdomain;

public class TestDomain {
    public TestDomain(){
        System.out.println("TestDomain Class constructor invoked");
    }

    public void firstMethod(){
        System.out.println("Method from TestDomain class : Tag Allocated : Smoke");
    }

    public void secondMethod(){
        System.out.println("Method from TestDomain class : Tag Allocated : Regression");
    }
    public void thirdMethod(){
        System.out.println("Method from TestDomain class : Tag Allocated : Smoke & Regression");
    }
}
