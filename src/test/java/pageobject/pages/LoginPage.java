package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.forms.LoginForm;
import pageobject.forms.PasswordForm;

public class LoginPage extends Page {
    private LoginForm loginForm;
    private PasswordForm passwordForm;

    private By controlElement = By.cssSelector(".passp-form-field__link a");


    public LoginPage(WebDriver driver) {
        super(driver);
        if (!isThisPage(controlElement)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage loginAs(String username, String password) {
        loginForm = new LoginForm(driver).typeUserName(username).clickSubmit();
        passwordForm = new PasswordForm(driver).typePassword(password).clickSubmit();
        return this;
    }


}
