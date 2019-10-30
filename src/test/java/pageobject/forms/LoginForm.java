package pageobject.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.Page;


public class LoginForm extends Page {
    private By usernameInputLocator = By.id("passp-field-login");
    private By submitButtonLocator = By.className("passp-sign-in-button");

    private By forgotUsernameButtonLocator = By.cssSelector(".passp-form-field__link a");


    public LoginForm(WebDriver driver) {
        super(driver);
        if (!isThisPage(forgotUsernameButtonLocator)) {
            throw new IllegalStateException("This is not the login form");
        }
    }

    public LoginForm typeUserName(String username) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(usernameInputLocator));
        driver.findElement(usernameInputLocator).sendKeys(username);
        return this;
    }

    public LoginForm clickSubmit() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}
