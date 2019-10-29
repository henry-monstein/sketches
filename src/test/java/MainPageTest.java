import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobject.pages.LoginPage;
import pageobject.pages.MainPage;
import browser.BrowserFactory;

public class MainPageTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional("firefox") String browser) {
        driver = BrowserFactory.valueOf(browser.toUpperCase()).getDriver();
    }

    @Test
    public void categoriesTest() {
        driver.get("https://market.yandex.ru");
        new MainPage(driver).login();
        LoginPage login = new LoginPage(driver);
        login.typeUserName("henry-monstein");
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
        driver = null;
    }

}
