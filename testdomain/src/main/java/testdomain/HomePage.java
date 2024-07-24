package testdomain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "(//button[contains(text(), 'Dashboard 2')])[2]") private WebElement dashboard2;
    @FindBy(xpath = "(//button[contains(text(), 'Dashboard 1')])[2]") private WebElement dashboard1;
    @FindBy(xpath = "(//button[contains(text(), 'Dashboard 3')])[2]") private WebElement dashboard3;
    @FindBy(xpath = "(//button[contains(text(), 'Dashboard 4')])[2]") private WebElement dashboard4;
    @FindBy(xpath = "(//button[contains(text(), 'Dashboard 5')])[2]") private WebElement dashboard5;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on Dashboard 1
    public void clickDashboard1() {
        dashboard1.click();
    }

    // Method to click on Dashboard 2
    public void clickDashboard2() {
        dashboard2.click();
    }

    // Method to click on Dashboard 3
    public void clickDashboard3() {
        dashboard3.click();
    }

    // Method to click on Dashboard 4
    public void clickDashboard4() {
        dashboard4.click();
    }

    // Method to click on Dashboard 5
    public void clickDashboard5() {
        dashboard5.click();
    }

    public void homePage(){
        clickDashboard1();
        clickDashboard2();
        clickDashboard1();
        clickDashboard3();
        clickDashboard1();
        clickDashboard4();
        clickDashboard1();
        clickDashboard5();
        clickDashboard1();
    }
}
