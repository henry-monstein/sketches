package pageobject.pages;

import browser.Browser;
import org.openqa.selenium.By;

public class GuestMainPage extends MainPage {
    private By loginButtonLocator = By.cssSelector(".header2-nav__user a.user__login");

    public GuestMainPage() {
        super();
        if (!isThisPage(loginButtonLocator)) {
            throw new IllegalStateException("This is not the guest main page");
        }
    }

    public void clickLoginButton() {
        Browser.getDriver().findElement(loginButtonLocator).click();
    }

    public boolean isLogouted() {
        return Browser.getDriver().findElement(loginButtonLocator).isEnabled();
    }
}
