package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static final String CLICKABLE_TIMEOUT = "clickableTimeout";
    private static final String PRESENCE_OF_ELEMENT_TIMEOUT = "presenceOfElementTimeout";

    public static void waitClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Integer.parseInt(PropertyUtil.getProperty(CLICKABLE_TIMEOUT)))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitPresence(WebDriver driver, By locator) {
        new WebDriverWait(driver, Integer.parseInt(PropertyUtil.getProperty(PRESENCE_OF_ELEMENT_TIMEOUT)))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
