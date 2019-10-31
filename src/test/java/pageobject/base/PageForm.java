package pageobject.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtil;
import utils.Waiter;

public abstract class PageForm {

    protected WebDriver driver;

    public PageForm(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isThisPage(By locator) {
        //может ли waiter возвращать webElement?
        Waiter.waitPresence(driver, locator);
        return driver.findElement(locator).isEnabled();
    }
}
