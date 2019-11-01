package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


abstract class MainPage extends PageWithMenu {
    private By bannerLocator = By.xpath("//div[@data-zone-name='MediaGallery']/div[@data-zone-name='Banner']");

    MainPage(WebDriver driver) {
        super(driver);
        if (!isThisPage(bannerLocator)) {
            throw new IllegalStateException("This is not the main page");
        }
    }

    public boolean isMainPage() {
        return driver.findElement(bannerLocator).isEnabled();
    }

}
