package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.forms.UserMenuForm;

public class AuthorizedMainPage extends MainPage {
    private UserMenuForm userMenuForm;

    private By userMenuButtonLocator = By.cssSelector(".header2-nav__user");

    public AuthorizedMainPage(WebDriver driver) {
        super(driver);
        if (!isThisPage(userMenuButtonLocator)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void openUserMenu() {
        driver.findElement(userMenuButtonLocator).click();
    }

    public void logout() {
        openUserMenu();
        userMenuForm = new UserMenuForm(driver);
        userMenuForm.clickLogout();
    }
}
