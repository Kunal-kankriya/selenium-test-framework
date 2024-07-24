package devdomain;

public class DevDomain {

    public DevDomain(){
        System.out.println("DevDomain Constructor invoked ");
    }
    public void firstMethod(){
        System.out.println("Method from DevDomain Class : Tag allocated ---> Smoke");
    }

    public void secondMethod(){
        System.out.println("Method from DevDomain Class : Tag allocated ---> Regression");
    }
    public void thirdMethod(){
        System.out.println("Method from DevDomain Class : Tag allocated ---> Smoke & Regression");
    }
}
