package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isThisPage(By locator) {
        WebElement element = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.isEnabled();
    }
}
