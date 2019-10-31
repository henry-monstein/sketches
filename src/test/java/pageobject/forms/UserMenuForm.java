package pageobject.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.base.PageForm;

public class UserMenuForm extends PageForm {
    private By menuLocator = By.cssSelector(".header2-nav__user-menu");
    private By logoutButton = By.cssSelector("li.header2-user-menu__item:nth-child(6)");

    public UserMenuForm(WebDriver driver) {
        super(driver);
        if (!isThisPage(menuLocator)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
