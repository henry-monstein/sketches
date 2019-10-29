package browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static String browser="firefox";

    static WebDriver setBrowser() {
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
                throw new IllegalStateException("");
            }
        }
    }
}
