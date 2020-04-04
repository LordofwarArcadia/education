import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumTests {

    WebDriver driver;

    WebDriverWait wait;

    @BeforeClass
    public static void addDriverToPath() {
        System.setProperty("webdriver.chrome.driver", "/Users/akobchenko/Repositories/dayone/chromedriver");
    }

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com/ncr"); //<<- https://sberbank.ru

        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void simpleSeleniumTest() {
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
        System.out.println(firstResult.getAttribute("textContent"));
    }
}

/*
    <body>
       <nav>
           <button class='login_button'>Login</button>      <<<--- Second Case 1
       </nav>
       <div class='login_form'>  // <------ webElement
           <input class='login_input'>Email</input>
           <input type='password' class='pwd_input qa_pwd_input'>Password</input>
           <button id='loginButton' class='login_button'>Login</button> <<<--- First case && <<<--- Second Case 2
       </div>
    </body>

    webElement.findElement(By.xpath("./button[@class='login_button']"));
    webElement.findElement(By.xpath("//button[@class='login_button']"));   <<<--- XPath TRAP, starts search context from // (body)

    driver.findElements(By.xpath("./button"))
    webElement.findElements(By.xpath("//button"))

    //E[@A='t'] -- general way
    ./input[@class='login_input']
    E = input & A = class & t = login_input
    SearchContext (где что-либо можно искать - какие-то элементы)
    WebDriver ex SearchContext (позволяет открывать страницы, взаимодействовать с браузером и искать на странице элементы)
    WebElement ex SearchContext (как и серч контекст позволяет искать элементы, form (id = register)-> text field & button
    WebElement form (который есть указанная выше форма) и т.к. внутри формы так же есть html код (как и на странице в целом)
    эта форма может выступать источником поиска новых (внутренних) элементов) DOM (Domain Object Model)

    WebDriver API (библиотека с классами) + Driver (ChromeDriver, GeckoDriver, EdgeDriver) + Browser (Chrome, FF, EDGE)
    WebDriver API + RemoteDriver (библиотека) + RemoteService (GRID/SauceLabs etc)

                                 _ GRID(Client) - Driver (ChromeDriver) - Browser (Chrome)
    Selenium RD -> GRID(Server)-|_
                                   GRID(Client) - Driver (GeckoDriver)  - Browser (FF)
*/