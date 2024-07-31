package devdomain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

import java.time.Duration;

public class ErpHomePage {
    WebDriver driver;
    @FindBy(xpath = "(//a[@href='/contact-us'])[1]")
    private WebElement contactUS;
    @FindBy(xpath = "(//a[@href='/'])")
    private WebElement erpHome;
    @FindBy(xpath = "(//a[@href='/contact-us'])[2]")
    private WebElement requestDemo;
    @FindBy(xpath = "(//a[@href='/partner'])[1]")
    private WebElement partner;
    @FindBy(xpath = "//div[@class='overlay']")
    private WebElement overlay;

    public ErpHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactUS)).click();
    }


    public void clickErpHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(erpHome)).click();
    }

    public void clickRequestDemo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(requestDemo)).click();
    }


    public void clickPartner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(partner)).click();
    }


    public void erpHome() {
        clickContactUs();
        clickErpHome();
        clickRequestDemo();
        clickPartner();
    }
}
