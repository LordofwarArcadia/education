package pages;

import org.openqa.selenium.WebDriver;
import pages.sections.MainMenu;

public class HomePage extends BasePage {

    public MainMenu menu;

    public HomePage(WebDriver driver) {
        super(driver,"«Сбербанк» - Частным клиентам");
        menu = new MainMenu(driver);
    }
}
