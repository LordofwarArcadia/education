package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected String title = "";

    BasePage(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
        wait = new WebDriverWait(driver, 10);
        if(!driver.getTitle().equals(title)){
            throw new RuntimeException("Открыта другая страница.");
        }
    }

    protected void clearInput(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

        while (element.getAttribute("value").length() != 0) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element, 100, 0);
        actions.perform();
    }

    protected void closeCookie() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("cookie-warning__close"))))
            .click();
    }
}
