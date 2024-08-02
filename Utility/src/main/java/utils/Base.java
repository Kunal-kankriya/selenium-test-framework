package utils;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.time.Duration;

public class Base {
    public static void clearDirectories() {
        String path = System.getProperty("user.dir");
        Common.clearDirectory(path + "/Report");
        Common.clearDirectory(path + "/Screenshots");
    }

    public static void windowSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {

        }
    }


    public static void quitBrowser(WebDriver driver) {
        driver.close();
    }
}
