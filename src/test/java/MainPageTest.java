import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testName() {
        driver.get("https://market.yandex.by/");
        driver.findElement(By.cssSelector(".header2-nav__user a")).click();// Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            System.out.println(winHandle);
            driver.switchTo().window(winHandle);
        }
//        driver.close();
//        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.id("passp-field-login")).sendKeys("henry-monstein");

//        driver.findElement(By.xpath("*[@type='submit']")).click();
    }
}
