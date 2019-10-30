package pageobject.pages;

import org.openqa.selenium.WebDriver;


abstract class MainPage extends PageWithMenu {
    public static final String TITLE_PART = "Яндекс.Маркет";

    MainPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().contains(TITLE_PART)) {
            throw new IllegalStateException("This is not the main page");
        }
    }

}
