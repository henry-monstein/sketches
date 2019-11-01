package pageobject.base;

import browser.Browser;
import org.openqa.selenium.By;
import utils.Waiter;

public abstract class PageForm {
    public PageForm() {
    }

    protected boolean isThisPage(By locator) {
        Waiter.waitPresence(locator);
        return Browser.getDriver().findElement(locator).isEnabled();
    }
}
