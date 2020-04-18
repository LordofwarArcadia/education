import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CashCreditPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    WebDriver driver;

    @BeforeClass
    public static void addDriverToPath() {
        System.setProperty("webdriver.chrome.driver", "/Users/akobchenko/Repositories/dayone/chromedriver");
    }

    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.sberbank.ru/");
        //        driver.get("https://www.sberbank.ru/ru/person/credits/money/consumer_unsecured");
        driver.manage().window().fullscreen();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void simpleSeleniumTest() {
        // Arrange
        HomePage hp = new HomePage(driver);
        hp.menu.clickOnMenuItem("Кредиты", "Кредит на любые цели");
        CashCreditPage page = new CashCreditPage(driver);

        // Act
        page.fillMoneyAmountAndSubmit(1000000);
        page.fillMonthAmount(50);

        // Assert
        assert page.getMonthlyPayment().equals("25 959");
    }


}

/* List<WebElement> list = new ArrayList<>();
        list.add(driver.findElement(By.xpath("//body")));

        WebElement first = list.stream()
            .filter(we -> {
                String href = we.getAttribute("href");
                return href != null && href.equals("");
            })
            .findFirst()
            .orElseThrow(() -> new RuntimeException(""));

        list.stream()
            .filter(we -> {
                String href = we.getAttribute("href");
                return href != null && href.equals("");
            })
            .findFirst()
            .orElseThrow(RuntimeException::new);*/


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