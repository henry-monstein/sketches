package browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyUtil;

class BrowserFactory {
    private static final String BROWSER_CONFIG_FIELD = "browser.name";

    static WebDriver setBrowser() {
        String browser = PropertyUtil.getProperty(BROWSER_CONFIG_FIELD);
        switch (browser.toUpperCase()) {
            case "CHROME": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "FIREFOX": {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default: {
                throw new IllegalStateException("Check config.properties: You input "
                        + browser + " as browser, but you should input 'Chrome' or 'Firefox'");
            }
        }
    }
}
