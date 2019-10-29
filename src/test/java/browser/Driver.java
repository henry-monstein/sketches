package browser;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driverInstance = null;

    public WebDriver getDriver() {
        if (driverInstance == null) {
            driverInstance=BrowserFactory.setBrowser();
        }
        return driverInstance;
    }
}
