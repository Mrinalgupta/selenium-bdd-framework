package Base;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver webDriver;
    protected AppiumDriver appiumDriver;

    public void initializeDriver() {

        Object driver = DriverFactory.getDriver();

        if (driver instanceof WebDriver) {
            webDriver = (WebDriver) driver;
        } else if (driver instanceof AppiumDriver) {
            appiumDriver = (AppiumDriver) driver;
        }
    }
}
