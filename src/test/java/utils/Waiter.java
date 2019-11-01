package utils;

import browser.Browser;
import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {


    public static void waitClickable(By locator) {
        new WebDriverWait(Browser.getDriver(), TimeOutConstant.getClickableTimeout())
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitPresence(By locator) {
        new WebDriverWait(Browser.getDriver(), TimeOutConstant.getPresenceOfElementTimeout())
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void fluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(TimeOutConstant.getClickableTimeout()));
        wait.until(driver -> Browser.getDriver().findElement(locator));
    }
}
