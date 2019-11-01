package browser;

import constants.TimeOutConstant;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static WebDriver driver = null;

    private Browser() {
        driver = BrowserFactory.setBrowser();
    }

    private static void init() {
        if (driver == null) {
            new Browser();
        }
    }

    public static WebDriver getDriver() {
        init();
        return driver;
    }

    public static void maximizeWindow() {
        init();
        driver.manage().window().maximize();
    }

    public static void setImplicitlyWait() {
        init();
        driver.manage().timeouts().implicitlyWait(TimeOutConstant.getImplicitlyWait(), TimeUnit.SECONDS);
    }

    public static void setScriptTimeout() {
        init();
        driver.manage().timeouts().setScriptTimeout(TimeOutConstant.getScriptTimeout(), TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeout() {
        init();
        driver.manage().timeouts().pageLoadTimeout(TimeOutConstant.getPageLoadTimeout(), TimeUnit.SECONDS);
    }

    public static void goToWebPage(String url) {
        init();
        driver.get(url);
    }

    private static ArrayList<String> getTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToLastTab() {
        init();
        ArrayList<String> tabs = getTabs();
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void switchToTab(int index) {
        init();
        ArrayList<String> tabs = getTabs();
        driver.switchTo().window(tabs.get(index));
    }

    public static void switchToFirstTab() {
        switchToTab(0);
    }

    public static void quit() {
        init();
        driver.quit();
    }
}
