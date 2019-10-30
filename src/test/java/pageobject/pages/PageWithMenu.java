package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class PageWithMenu extends Page {
    private static final String ALL_CATEGORIES_NAME = "Все категории";
    private static final String SALES_NAME = "Скидки и акции";

    private By mainPageButtonLocator = By.cssSelector("a.logo:nth-child(2)");

    public PageWithMenu(WebDriver driver) {
        super(driver);
    }

    public PageWithMenu findPopularCategoriesList(ArrayList<WebElement> popularCategories) {
        List<WebElement> categories = driver.findElements(By.cssSelector(".n-w-tabs__horizontal-tabs>*"));
        for (WebElement element : categories) {
            if (!element.getText().equals("")
                    && !element.getText().equals(ALL_CATEGORIES_NAME)
                    && !element.getText().equals(SALES_NAME)) {
                popularCategories.add(element);
            }
        }
        return this;
    }

    public PageWithMenu returnToMainPage() {
        driver.findElement(mainPageButtonLocator).click();
        return this;
    }
}
