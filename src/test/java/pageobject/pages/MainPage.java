package pageobject.pages;

import browser.Browser;
import org.openqa.selenium.By;


public class MainPage extends PageWithMenu {
    private By bannerLocator = By.xpath("//div[@data-zone-name='MediaGallery']/div[@data-zone-name='Banner']");

    public MainPage() {
        super();
        if (!isThisPage(bannerLocator)) {
            throw new IllegalStateException("This is not the main page");
        }
    }

    public boolean isMainPage() {
        return Browser.getDriver().findElement(bannerLocator).isEnabled();
    }

}
