
package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<Object> driver = new ThreadLocal<>();

    public static void initDriver() {

        String platform = ConfigReader.get("platform");

        try {

            // ✅ MOBILE AUTOMATION
            if (platform.equalsIgnoreCase("mobile")) {

                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("automationName", "UiAutomator2");

                caps.setCapability("appPackage", "com.androidsample.generalstore");
                caps.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");

                caps.setCapability("noReset", true);

                AppiumDriver appiumDriver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723"), caps);

                driver.set(appiumDriver);

            }

            // ✅ WEB AUTOMATION
            else if (platform.equalsIgnoreCase("web")) {

                String browser = ConfigReader.get("browser");

                if (browser.equalsIgnoreCase("chrome")) {
                    WebDriver webDriver = new ChromeDriver();
                    webDriver.get("https://example.com");
                    driver.set(webDriver);
                }

                // you can add firefox, edge here

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {

            if (driver.get() instanceof WebDriver) {
                ((WebDriver) driver.get()).quit();
            } else if (driver.get() instanceof AppiumDriver) {
                ((AppiumDriver) driver.get()).quit();
            }

            driver.remove();
        }
    }
}
