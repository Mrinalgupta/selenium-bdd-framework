package hooks;


import io.cucumber.java.*;
import utils.DriverFactory;
import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
