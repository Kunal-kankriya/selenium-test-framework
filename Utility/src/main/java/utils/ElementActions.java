package utils;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions extends Base {
    public static final WebElement isElementFound(WebDriver driver, String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));
            test.get().info("Element found");
        } catch (Exception e) {
            test.get().fail(e.getMessage());
        }
        return element;

    }

    public static final boolean isActionSuccess(WebElement element, String action) {
        boolean flag = false;
        switch (action.toLowerCase()) {
            case "click":
                element.click();
                test.get().info("Click element");
                return flag = true;
            case "input":
                element.clear();
                element.sendKeys();
                test.get().info("Enter input");
                return flag = true;
            default:
                return flag;
        }
    }

    public static boolean click(String xpath) {
        WebElement ele = isElementFound(driver, xpath);
        boolean flag = false;
        if (ele != null) {
            flag = isActionSuccess(ele, "click");
        }
        return flag;
    }

    public static boolean input(String xpath) {
        WebElement ele = isElementFound(driver, xpath);
        boolean flag = false;
        if (ele != null) {
            flag = isActionSuccess(ele, "input");
        }
        return flag;
    }

    public static void stepRun(ExtentTest test, Row row) {
        if (row != null) {
            ExcelUtils excelUtils = new ExcelUtils();
            String locator = excelUtils.getLocator(row);
            String Action = excelUtils.getAction(row);
            WebElement element = ElementActions.isElementFound(driver, locator);
            if (element != null) {
                test.log(Status.INFO, "Locator found: " + locator);
                boolean result = ElementActions.isActionSuccess(element, Action);
                test.log(Status.INFO, "Action performed: " + Action);
                if (result) {
                    System.out.println("Result Validated:");
                    test.log(Status.INFO, "Result validated");
                }
            }
        }

    }

}
