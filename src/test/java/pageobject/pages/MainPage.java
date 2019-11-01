package pageobject.pages;

import org.openqa.selenium.WebDriver;


abstract class MainPage extends PageWithMenu {
    MainPage(WebDriver driver) {
        super(driver);
//        if (!isThisPage()) {
//            throw new IllegalStateException("This is not the main page");
//        }
    }

}
