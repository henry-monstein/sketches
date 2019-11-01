package tests;

import browser.Browser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import tests.step.Step;
import utils.PropertyUtil;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class MainPageTest {
    private static final String USERNAME_CONFIG_FIELD = "username";
    private static final String PASSWORD_CONFIG_FIELD = "password";
    private static final String START_PAGE_URL_FIELD = "startPage";


    private String username = PropertyUtil.getProperty(USERNAME_CONFIG_FIELD);
    private String password = PropertyUtil.getProperty(PASSWORD_CONFIG_FIELD);
    private String startPageUrl = PropertyUtil.getProperty(START_PAGE_URL_FIELD);

    @BeforeTest
    public void setUp() {
        Browser.maximizeWindow();
        Browser.setImplicitlyWait();
        Browser.setScriptTimeout();
        Browser.setPageLoadTimeout();
    }

    @Test
    public void categoriesTest() {
        Step.openPage(startPageUrl);
        Step.login(username, password);
        ArrayList<String> popularCategories = Step.getPopularCategories();
        Step.clickRandomPopularCategory(popularCategories);
        Step.returnToMainPage();
        ArrayList<String> allCategories = Step.getAllCategoriesAndWriteIt();
        assertTrue(allCategories.containsAll(popularCategories));
        Step.logout();
    }

    @AfterTest
    public void tearDown() {
        Browser.quit();
    }
}

