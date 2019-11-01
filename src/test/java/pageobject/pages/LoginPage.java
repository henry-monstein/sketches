package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.base.PageForm;
import pageobject.forms.LoginForm;
import pageobject.forms.PasswordForm;

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


}
