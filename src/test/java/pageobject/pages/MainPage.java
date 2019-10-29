package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private By loginButtonLocator = By.cssSelector(".header2-nav__user > div > a");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }
}
