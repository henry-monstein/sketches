package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.base.PageForm;
import utils.Waiter;

import java.util.ArrayList;
import java.util.List;

public abstract class PageWithMenu extends PageForm {
    private static final String ALL_CATEGORIES_NAME = "Все категории";
    private static final String SALES_NAME = "Скидки и акции";

    private By mainPageButtonLocator = By.xpath("//a[contains(text(),'Маркет')]");

    private By allCategoriesButtonLocator = By.cssSelector(".n-w-tab_interaction_click-navigation-menu");
    private By categoriesTabs = By.className("n-w-tabs__horizontal-tabs");
    private By allCategoriesListLocator = By.xpath("//div[@class='n-w-tabs__horizontal-tabs']/"
            + "*[not(contains(@class,'n-w-tab_interaction_click-navigation-menu')) "
            + "and not(contains(@class,'n-w-tab_discount'))]");

    public PageWithMenu(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> findPopularCategoriesList() {
        List<WebElement> categories = driver.findElements(allCategoriesListLocator);
        ArrayList<String> popularCategoriesList = new ArrayList<>();
        for (WebElement element : categories) {
            if (!element.getText().equals("")) {
                popularCategoriesList.add(element.getText());
            }
        }
        return popularCategoriesList;
    }

    public void clickPopularCategory(String categoryName) {
        for (WebElement element : driver.findElements(allCategoriesListLocator)) {
            if (element.getAttribute("innerText").equals(categoryName)) {
                element.click();
                break;
            }
        }

    }

    public PageWithMenu returnToMainPage() {
        driver.findElement(mainPageButtonLocator).click();
        return this;
    }
}
