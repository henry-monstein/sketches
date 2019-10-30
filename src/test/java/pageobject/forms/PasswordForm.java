package pageobject.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.pages.Page;

public class PasswordForm extends Page {
    private By passwordLocator = By.id("passp-field-passwd");
    private By submitButtonLocator = By.className("passp-sign-in-button");

    private By forgotPasswordButtonLocator = By.cssSelector(".passp-form-field__link a");

    public PasswordForm(WebDriver driver) {
        super(driver);
        if (!isThisPage(forgotPasswordButtonLocator)) {
            throw new IllegalStateException("This is not the password form");
        }
    }


    public PasswordForm typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public PasswordForm clickSubmit() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}
