package pageobject.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.base.PageForm;

public class PasswordForm extends PageForm {
    private By passwordInputLocator = By.id("passp-field-passwd");
    private By submitButtonLocator = By.className("passp-sign-in-button");

    public PasswordForm(WebDriver driver) {
        super(driver);
        if (!isThisPage(passwordInputLocator)) {
            throw new IllegalStateException("This is not the password form");
        }
    }


    public PasswordForm typePassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
        return this;
    }

    public PasswordForm clickSubmit() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}
