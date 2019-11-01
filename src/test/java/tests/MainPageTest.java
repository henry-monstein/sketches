package tests;

import browser.Driver;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;


import pageobject.pages.AuthorizedMainPage;
import pageobject.pages.CategoryPage;
import pageobject.pages.LoginPage;
import pageobject.pages.GuestMainPage;
import utils.FileUtil;
import utils.PropertyUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class MainPageTest {
    public static final String USERNAME_CONFIG_FIELD = "username";
    public static final String PASSWORD_CONFIG_FIELD = "password";
    public static final String PAGE_LOAD_TIMEOUT_FIELD = "pageLoadTimeout";
    public static final String SCRIPT_TIMEOUT_FIELD = "scriptTimeout";
    public static final String IMPLICITLY_WAIT_FIELD = "implicitlyWaitTimeout";


    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PropertyUtil.getProperty(PAGE_LOAD_TIMEOUT_FIELD)), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Integer.parseInt(PropertyUtil.getProperty(SCRIPT_TIMEOUT_FIELD)), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyUtil.getProperty(IMPLICITLY_WAIT_FIELD)), TimeUnit.SECONDS);
    }

    @Test(dataProvider = "getUserData")
    public void categoriesTest(String username, String password) {
        driver.get("https://market.yandex.ru");
        new GuestMainPage(driver).clickLoginButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);
        driver.switchTo().window(tabs.get(0));

        driver.navigate().refresh();

        AuthorizedMainPage mainPage = new AuthorizedMainPage(driver);
        ArrayList<String> popularCategories = mainPage.findPopularCategoriesList();
        Collections.shuffle(popularCategories);
        mainPage.clickPopularCategory(popularCategories.get(0));
        CategoryPage randomCategoryPage = new CategoryPage(driver);
        assertTrue(randomCategoryPage.getCategoryName().toLowerCase().contains(popularCategories.get(0).toLowerCase()));
        randomCategoryPage.returnToMainPage();
        mainPage = new AuthorizedMainPage(driver);
        mainPage.clickAllCategoriesButton();
        ArrayList<String> allCategories = mainPage.getAllCategoriesList();
        FileUtil.writeToCsv(new String[][]{allCategories.toArray(new String[allCategories.size()])});
        assertTrue(allCategories.containsAll(popularCategories));
        mainPage.logout();
    }

    @DataProvider(name = "getUserData")
    public static Object[][] getUserData() {
        return new String[][]{{PropertyUtil.getProperty(USERNAME_CONFIG_FIELD),
                PropertyUtil.getProperty(PASSWORD_CONFIG_FIELD)}};
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}

