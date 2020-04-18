package pages.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainMenu extends BaseSection {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    private void hoverOnMainMenuItem(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[.='" + name + "']")), 5, 5);
        actions.perform();
    }

    private void clickOnMenuSubItem(String name) {
        driver.findElement(By.xpath("//div[.='" + name + "']"));
    }

    // Usage: clickOnMenuItem("Кредиты", "Автокредит");
    public void clickOnMenuItem(String mainItem, String subItem) {
        hoverOnMainMenuItem(mainItem);
        clickOnMenuSubItem(subItem);
    }
}
