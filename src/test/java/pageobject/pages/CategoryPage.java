package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends PageWithMenu {
    private By categoryNameField = By.xpath("//div[@data-apiary-widget-name='@MarketNode/CatalogHeader']");

    public CategoryPage(WebDriver driver) {
        super(driver);
        if (!isThisPage(categoryNameField)) {
            throw new IllegalStateException("This is not the main page");
        }
    }

    public String getCategoryName() {
        return driver.findElement(categoryNameField).getText();
    }
}
