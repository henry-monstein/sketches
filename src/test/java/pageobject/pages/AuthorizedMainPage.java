package pageobject.pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.forms.UserMenuForm;

public class AuthorizedMainPage extends MainPage {
    private UserMenuForm userMenuForm;

    private By userMenuButtonLocator = By.cssSelector(".header2-nav__user a.header2-user");

    public AuthorizedMainPage() {
        super();
        if (!isThisPage(userMenuButtonLocator)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void openUserMenu() {
        Browser.getDriver().findElement(userMenuButtonLocator).click();
    }

    public void logout() {
        openUserMenu();
        userMenuForm = new UserMenuForm();
        userMenuForm.clickLogout();
    }

    public boolean isAuthorized() {
        return Browser.getDriver().findElement(userMenuButtonLocator).isEnabled();
    }
}
