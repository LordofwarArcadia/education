import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Binders {
    private static WebDriver driver;

    //@Given("Im on a home page")
    public void imOnAHomePage() {
        //do something - open home page
        driver = new ChromeDriver();
        driver.get("homepage");
    }

    //@When("I click bla-bla button")
    public void clickButton() {
        //do something - click blabla button
        driver.findElement(null).click();
    }

    //@Then("Then I see %d in my pocket")
    public void checkAmount(Integer value) {
        //do something - click blabla button
        driver.findElement(null).getText();
    }

    public static class Runner {

        public static void run() {
            test1();
            test2();
            test3();
        }

        public static void test1() {
            Binders b = new Binders();

            b.imOnAHomePage();
            b.clickButton();
            b.checkAmount(100000);
        }

        public static void test2() {
            Binders b = new Binders();

            b.imOnAHomePage();
            b.clickButton();
            b.clickButton();
            b.checkAmount(200000);
        }

        public static void test3() {
            Binders b = new Binders();

            b.imOnAHomePage();
            b.clickButton();
            b.clickButton();
            b.clickButton();
            b.checkAmount(300000);
        }
    }
}
