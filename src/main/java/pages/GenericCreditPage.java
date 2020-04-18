package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class GenericCreditPage extends BasePage {

    GenericCreditPage(WebDriver driver, String title) {
        super(driver,title);
    }

    protected WebElement getCalcForm() {
        return driver.findElement(By.className("calc-credit-form"));
    }
}
