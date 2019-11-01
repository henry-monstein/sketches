package pageobject.pages;

import browser.Browser;
import org.openqa.selenium.By;

public class CategoryPage extends PageWithMenu {
    private By categoryNameField = By.xpath("//div[@data-apiary-widget-name='@MarketNode/CatalogHeader']");

    public CategoryPage() {
        super();
        if (!isThisPage(categoryNameField)) {
            throw new IllegalStateException("This is not the main page");
        }
    }

    public String getCategoryName() {
        return Browser.getDriver().findElement(categoryNameField).getText();
    }
}
