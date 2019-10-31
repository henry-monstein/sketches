package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.base.PageForm;

import java.util.ArrayList;
import java.util.List;

public abstract class PageWithMenu extends PageForm {
    private static final String ALL_CATEGORIES_NAME = "Все категории";
    private static final String SALES_NAME = "Скидки и акции";

    private By mainPageButtonLocator = By.xpath("//a[contains(text(),'Маркет')]");

    private By allCategoriesButtonLocator = By.cssSelector(".n-w-tab_interaction_click-navigation-menu");
    private By allCategoriesListLocator = By.cssSelector(".n-w-tabs__vertical-tabs>div");
    private By categoriesTabs = By.className("n-w-tabs__horizontal-tabs");
    private By allCategoriesTabsLocator = By.xpath("//div[@class='n-w-tabs__horizontal-tabs']/"
            + "*[not(contains(@class,'n-w-tab_interaction_click-navigation-menu')) "
            + "and not(contains(@class,'n-w-tab_discount'))]");

    public PageWithMenu(WebDriver driver) {
        super(driver);
        if (!isThisPage(categoriesTabs)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public ArrayList<String> findPopularCategoriesList() {
//        Waiter.waitPresence(driver, allCategoriesListLocator);
        ArrayList<String> popularCategoriesList = new ArrayList<>();
        for (WebElement element : driver.findElements(allCategoriesTabsLocator)) {
            if (!element.getText().equals("")) {
                popularCategoriesList.add(element.getText());
            }
        }
        return popularCategoriesList;
    }

    public void clickPopularCategory(String categoryName) {
//        Waiter.waitPresence(driver, allCategoriesListLocator);
        for (WebElement element : driver.findElements(allCategoriesTabsLocator)) {
            if (element.getAttribute("innerText").equals(categoryName)) {
                element.click();
                break;
            }
        }

    }

    public void returnToMainPage() {
        driver.findElement(mainPageButtonLocator).click();
    }

    public void clickAllCategoriesButton() {
        driver.findElement(allCategoriesButtonLocator).click();
    }

    public ArrayList<String> getAllCategoriesList() {
        ArrayList<String> allCategories = new ArrayList<>();
        for (WebElement element : driver.findElements(allCategoriesListLocator)) {
            allCategories.add(element.getText());
        }
        return allCategories;
    }
}
