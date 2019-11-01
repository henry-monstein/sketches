package browser;


import constants.BrowserConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BrowserFactory {


    static WebDriver setBrowser() {
        String browser = BrowserConstant.getBrowserConfigField();
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
                throw new IllegalStateException("Check config.properties: You input '"
                        + browser + "' as browser, but you should input 'Chrome' or 'Firefox'");
            }
        }
    }
}
