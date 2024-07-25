package testdomain;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Personal number']") private WebElement personalNumber;
    @FindBy(xpath = "//input[@placeholder='Password']") private WebElement password;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]") private WebElement loginButton;
    @FindBy(xpath = "//li[@placement='bottom-end']") private WebElement settingButton;
    @FindBy(xpath = "//button[contains(text(), 'Logout')]") private WebElement logoutButton;


public Login(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void enterPersonalNumber(String number) {
    Assert.assertTrue(personalNumber.isDisplayed());
    personalNumber.sendKeys(number);
}

// Method to enter password
public void enterPassword(String pwd) {

    Assert.assertTrue(password.isDisplayed());password.sendKeys(pwd);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

// Method to click the login button
public void clickLoginButton() {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
  //  Assert.assertEquals(driver.getCurrentUrl(),"http://13.126.60.8:8080/bms/dashboard");
}

// Method to click the setting button
public void clickSettingButton() {
    Assert.assertTrue(settingButton.isEnabled());
    settingButton.click();
}

// Method to click the logout button
public void clickLogoutButton() {
    Assert.assertTrue(logoutButton.isEnabled());
    logoutButton.click();
  //  Assert.assertNotEquals(driver.getCurrentUrl(),"http://13.126.60.8:8080/bms/dashboard");
}

public void login(String personalNumber,String password){
    enterPersonalNumber(personalNumber);
    enterPassword(password);
    clickLoginButton();
}
public void logout(){
    clickSettingButton();
    clickLogoutButton();
}


}