import org.junit.Test;
import pages.HomePage;

public class HomePageTests extends AbstractTestBase {

    @Test
    public void checkMenuItemsTest(){
        HomePage page = new HomePage(driver);
        page.menu.clickOnMenuItem("Кредиты", "Кредиты на любые цели");
    }

}
