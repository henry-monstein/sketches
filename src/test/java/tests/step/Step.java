package tests.step;

import browser.Browser;
import pageobject.pages.*;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Step {
    public static void openPage(String url) {
        Browser.goToWebPage(url);
        GuestMainPage guestMainPage = new GuestMainPage();
        assertTrue(guestMainPage.isMainPage());
    }

    public static void login(String username, String password) {
        GuestMainPage guestMainPage = new GuestMainPage();
        guestMainPage.clickLoginButton();
        Browser.switchToLastTab();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs(username, password);
        Browser.switchToFirstTab();
        AuthorizedMainPage mainPage = new AuthorizedMainPage();
        assertTrue(mainPage.isAuthorized());
    }

    public static ArrayList<String> getPopularCategories() {
        MainPage mainPage = new MainPage();
        return mainPage.findPopularCategoriesList();
    }

    public static void clickRandomPopularCategory(ArrayList<String> popularCategories) {
        MainPage mainPage = new MainPage();
        Collections.shuffle(popularCategories);
        mainPage.clickPopularCategory(popularCategories.get(0));
        CategoryPage randomCategoryPage = new CategoryPage();
        assertTrue(randomCategoryPage.getCategoryName().toLowerCase().contains(popularCategories.get(0).toLowerCase()));
    }

    public static void returnToMainPage() {
        CategoryPage randomCategoryPage = new CategoryPage();
        randomCategoryPage.returnToMainPage();
    }

    public static ArrayList<String> getAllCategoriesAndWriteIt() {
        AuthorizedMainPage mainPage = new AuthorizedMainPage();
        mainPage.clickAllCategoriesButton();
        ArrayList<String> allCategories = mainPage.getAllCategoriesList();
        String[][] allCategoriesTable = new String[][]{allCategories.toArray(new String[allCategories.size()])};
        FileUtil.writeToCsv(allCategoriesTable);
        String[][] csvTable = FileUtil.readFromCsv();
        assertEquals(csvTable, allCategoriesTable);
        return allCategories;
    }

    public static void logout() {
        AuthorizedMainPage mainPage = new AuthorizedMainPage();
        mainPage.logout();
        GuestMainPage guestMainPage = new GuestMainPage();
        assertTrue(guestMainPage.isLogouted());
    }
}
