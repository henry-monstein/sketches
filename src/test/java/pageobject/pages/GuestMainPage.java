package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuestMainPage extends MainPage {
    private By loginButtonLocator = By.cssSelector(".header2-nav__user a");

    public GuestMainPage(WebDriver driver) {
        super(driver);
        if (!isThisPage(loginButtonLocator)) {
            throw new IllegalStateException("This is not the guest main page");
        }
    }

    public GuestMainPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }
}
