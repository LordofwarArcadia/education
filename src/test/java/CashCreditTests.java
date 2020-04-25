import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.CashCreditPage;
import pages.HomePage;

@RunWith(JUnitParamsRunner.class)
public class CashCreditTests extends AbstractTestBase {

    @Before
    public void openCashCreditPage() {
        driver.get("https://www.sberbank.ru/ru/person/credits/money/consumer_unsecured");
    }

    @Test
    public void simpleSeleniumTest() {
        // Arrange
        driver.get("https://www.sberbank.ru/");
        HomePage hp = new HomePage(driver);
        hp.menu.clickOnMenuItem("Кредиты", "Кредит на любые цели");
        CashCreditPage page = new CashCreditPage(driver);

        // Act
        page.fillMoneyAmountAndSubmit(1000000);
        page.fillMonthAmount(50);

        // Assert
        assert page.getMonthlyPayment().equals("25 959");
    }

    private Object[] parametersToTestMonths() {
        return new Object[]{
            new Object[]{"12", "12 месяцев", "1 год"},
            new Object[]{"61", "61 месяц", "5 лет"},
            new Object[]{"2", "2 месяца", "3 месяца"}
        };
    }

    @Test
    @Parameters(method = "parametersToTestMonths")
    public void dateMonthsToYearConvertTest(
        String enteredValue,
        String valueBeforeSubmit,
        String expectedValue) {
        // Arrange
        CashCreditPage page = new CashCreditPage(driver);

        // Act
        page.fillMonthAmount(enteredValue);

        // Assert
        assert page.getMonthsText().equals(valueBeforeSubmit);
    }

    @Test
    @Parameters(method = "parametersToTestMonths")
    public void dateMonthsToYearConvertAfterSubmitTest(
        String enteredValue,
        String valueBeforeSubmit,
        String expectedValue) {
        // Arrange
        CashCreditPage page = new CashCreditPage(driver);

        // Act
        page.fillMonthAmount(enteredValue);
        page.submitMonthAmount();

        // Assert
        assert page.getMonthsText().equals(expectedValue);

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