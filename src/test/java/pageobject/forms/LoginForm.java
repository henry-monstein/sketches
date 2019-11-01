package pageobject.forms;

import browser.Browser;
import org.openqa.selenium.By;
import pageobject.base.PageForm;
import utils.Waiter;


public class LoginForm extends PageForm {
    private By usernameInputLocator = By.id("passp-field-login");
    private By submitButtonLocator = By.className("passp-sign-in-button");


    public LoginForm() {
        super();
        if (!isThisPage(usernameInputLocator)) {
            throw new IllegalStateException("This is not the login form");
        }
    }

    public void typeUserName(String username) {
        Waiter.waitClickable(usernameInputLocator);
        Browser.getDriver().findElement(usernameInputLocator).sendKeys(username);
    }

    public void clickSubmit() {
        Waiter.fluentWait(submitButtonLocator);
        Browser.getDriver().findElement(submitButtonLocator).click();
    }
}
