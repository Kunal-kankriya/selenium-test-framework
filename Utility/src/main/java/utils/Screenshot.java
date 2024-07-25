package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String screenshotFileName = screenshotName + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotFileName;
        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
            FileHandler.copy(srcFile, new File(screenshotPath));
        } catch (IOException e) {

        }

        return screenshotPath;
    }
}
