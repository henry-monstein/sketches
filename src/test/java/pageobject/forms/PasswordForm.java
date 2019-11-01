package pageobject.forms;

import browser.Browser;
import org.openqa.selenium.By;
import pageobject.base.PageForm;

public class PasswordForm extends PageForm {
    private By passwordInputLocator = By.id("passp-field-passwd");
    private By submitButtonLocator = By.className("passp-sign-in-button");

    public PasswordForm() {
        super();
        if (!isThisPage(passwordInputLocator)) {
            throw new IllegalStateException("This is not the password form");
        }
    }


    public void typePassword(String password) {
        Browser.getDriver().findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickSubmit() {
        Browser.getDriver().findElement(submitButtonLocator).click();
    }
}
