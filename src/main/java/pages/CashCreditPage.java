package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashCreditPage extends GenericCreditPage {

    public CashCreditPage(WebDriver driver) {
        super(driver);
    }

    public String getMonthlyPayment() {
        return driver
            .findElement(By.className("calc-credit-output__payment"))
            .findElement(By.tagName("span"))
            .getText();
    }

    public void fillMoneyAmount(Integer value) {
        fillMoneyAmount(value.toString());
    }

    public void fillMoneyAmount(String value) {
        WebElement amountRow = getCalcForm().findElement(By.xpath(".//div[.='Сколько вам нужно']/.."));
        scrollToElement(amountRow);

        WebElement amountField = amountRow.findElement(By.xpath(".//span"));
        amountField.click();
        WebElement amountInput = amountRow.findElement(By.tagName("input"));
        clearInput(amountInput);
        amountInput.sendKeys(value);
        //amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys(Keys.ENTER);
    }

    public void fillMonthAmount(Integer value) {
        fillMonthAmount(value.toString());
    }

    public void fillMonthAmount(String value) {
        WebElement amountRow = getCalcForm().findElement(By.xpath(".//div[.='Срок кредита']/.."));
        scrollToElement(amountRow);
        // activate our input
        amountRow.findElement(By.xpath(".//span")).click();

        // Fill our input
        WebElement amountInput = amountRow.findElement(By.tagName("input"));
        clearInput(amountInput);
        amountInput.sendKeys(value);
        amountInput.sendKeys(Keys.ENTER);
    }




}
