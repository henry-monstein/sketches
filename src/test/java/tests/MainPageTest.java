package tests;

import browser.Driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;


import pageobject.pages.AuthorizedMainPage;
import pageobject.pages.CategoryPage;
import pageobject.pages.LoginPage;
import pageobject.pages.GuestMainPage;
import utils.PropertyUtil;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertTrue;

public class MainPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "getUserData")
    public void categoriesTest(String username, String password) {
        driver.get("https://market.yandex.ru");
        new GuestMainPage(driver).clickLoginButton();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        ArrayList<WebElement> popularCategories = new ArrayList<>();
        new AuthorizedMainPage(driver).findPopularCategoriesList(popularCategories);
        Collections.shuffle(popularCategories);
        String category = popularCategories.get(0).getText();
        popularCategories.get(0).click();
        assertTrue(driver.getTitle().contains(category));
        new CategoryPage(driver).returnToMainPage();
    }

    @DataProvider(name = "getUserData")
    public static Object[][] getUserData() {
        return new String[][]{new PropertyUtil().getUsernameAndPassword()};
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
        driver = null;
    }
}

