package utils;

import browser.Browser;
import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {


    public static void waitClickable(By locator) {
        new WebDriverWait(Browser.getDriver(), TimeOutConstant.getClickableTimeout())
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitPresence(By locator) {
        new WebDriverWait(Browser.getDriver(), TimeOutConstant.getPresenceOfElementTimeout())
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
