package devdomain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErpHomePage {
    WebDriver driver;
    @FindBy(xpath = "(//a[@href='/contact-us'])[1]") private WebElement contactUS;
    @FindBy(xpath = "(//a[@href='/'])") private WebElement erpHome;
    @FindBy(xpath = "(//a[@href='/contact-us'])[2]") private WebElement requestDemo;
    @FindBy(xpath = "(//a[@href='/partner'])[1]") private WebElement partner;
    @FindBy(xpath = "//div[@class='overlay']") private WebElement overlay;

    public ErpHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on Contact Us link
    public void clickContactUs() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        wait.until(ExpectedConditions.visibilityOf(contactUS)).click();
    }

    // Method to click on ERP Home link
    public void clickErpHome() {
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        wait.until(ExpectedConditions.elementToBeClickable(erpHome)).click();
    }

    // Method to click on Request Demo link
    public void clickRequestDemo() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        wait.until(ExpectedConditions.elementToBeClickable(requestDemo)).click();
    }

    // Method to click on Partner link
    public void clickPartner() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        wait.until(ExpectedConditions.elementToBeClickable(partner)).click();
    }


    public void erpHome(){
        clickContactUs();
        clickErpHome();
        clickRequestDemo();
        clickPartner();
    }
}
