package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarCreditPage extends GenericCreditPage {

    public CarCreditPage(WebDriver driver) {
        super(driver, "Сбербанк. Автокредит.");
    }
}
