import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

    WebDriver driver;

    @BeforeClass
    public static void addDriverToPath() {
        System.setProperty("webdriver.chrome.driver", "/Users/akobchenko/Repositories/dayone/chromedriver");
    }

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
