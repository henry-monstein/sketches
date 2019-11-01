package pageobject.pages;

import browser.Browser;
import org.openqa.selenium.By;
import pageobject.base.PageForm;
import pageobject.forms.LoginForm;
import pageobject.forms.PasswordForm;
import utils.Waiter;

public class LoginPage extends PageForm {
    private LoginForm loginForm;
    private PasswordForm passwordForm;

    private By usernameInputLocator = By.id("passp-field-login");


    public LoginPage() {
        super();
        if (!isThisPage(usernameInputLocator)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void loginAs(String username, String password) {
        loginForm = new LoginForm();
        loginForm.typeUserName(username);
        loginForm.clickSubmit();
        passwordForm = new PasswordForm();
        passwordForm.typePassword(password);
        passwordForm.clickSubmit();
    }

    @Override
    protected boolean isThisPage(By locator) {
        Waiter.fluentWait(locator);
        return Browser.getDriver().findElement(locator).isEnabled();
    }
}
