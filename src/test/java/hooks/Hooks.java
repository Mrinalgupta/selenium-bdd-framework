package hooks;

import io.cucumber.java.*;
import utils.DriverFactory;
import utils.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.initDriver();

        Object driver = DriverFactory.getDriver();
        String platform = ConfigReader.get("platform");

        // ✅ WEB SETTINGS
        if (platform.equalsIgnoreCase("web")) {

            WebDriver webDriver = (WebDriver) driver;

            webDriver.manage().window().maximize();
            //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            webDriver.manage().timeouts()
                    .implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);


        }

        // ✅ MOBILE SETTINGS
        else if (platform.equalsIgnoreCase("mobile")) {

            AppiumDriver appiumDriver = (AppiumDriver) driver;

            // No maximize needed ✅
            // Optional: appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Mobile session started ✅");
        }
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}