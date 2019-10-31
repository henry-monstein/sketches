package browser;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static Driver instance = null;

    private WebDriver driver;

    private Driver() {
        driver = BrowserFactory.setBrowser();
        instance = this;
    }

    public static WebDriver getDriver() {
        if (instance == null) {
            new Driver();
        }
        return instance.driver;
    }
}
