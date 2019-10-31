package pageobject.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.base.PageForm;
import utils.Waiter;


public class LoginForm extends PageForm {
    private By usernameInputLocator = By.id("passp-field-login");
    private By submitButtonLocator = By.className("passp-sign-in-button");


    public LoginForm(WebDriver driver) {
        super(driver);
        if (!isThisPage(usernameInputLocator)) {
            throw new IllegalStateException("This is not the login form");
        }
    }

    public void typeUserName(String username) {
        Waiter.waitClickable(driver, usernameInputLocator);
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void clickSubmit() {
        Waiter.waitClickable(driver, submitButtonLocator);
        driver.findElement(submitButtonLocator).click();
    }
}
