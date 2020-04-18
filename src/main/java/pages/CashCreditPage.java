package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.sections.MainMenu;

public class CashCreditPage extends GenericCreditPage {

    public MainMenu menu;

    public CashCreditPage(WebDriver driver) {
        super(driver, "Сбербанк. Потребительский кредит на любые цели.");
        closeCookie();
        menu = new MainMenu(driver);
    }

    public String getMonthlyPayment() {
        return driver
            .findElement(By.className("calc-credit-output__payment"))
            .findElement(By.tagName("span"))
            .getText();
    }

    public void fillMoneyAmountAndSubmit(Integer value) {
        fillMoneyAmountAndSubmit(value.toString());
    }

    public void fillMoneyAmountAndSubmit(String value) {
        fillMoneyAmountWithoutSubmit(value).sendKeys(Keys.ENTER);
    }

    public WebElement fillMoneyAmountWithoutSubmit(String value) {
        clickOnSpanMoney();
        return fillAmountInput(value);
    }

    private WebElement getAmountRow(){
        WebElement amountRow = getCalcForm().findElement(By.xpath(".//div[.='Сколько вам нужно']/.."));
        scrollToElement(amountRow);
        return amountRow;
    }

    private void clickOnSpanMoney(){
        WebElement amountField = getAmountRow().findElement(By.xpath(".//span"));
        amountField.click();
    }

    private WebElement fillAmountInput(String value){
        WebElement amountInput = getAmountRow().findElement(By.tagName("input"));
        clearInput(amountInput);
        amountInput.sendKeys(value);
        return amountInput;
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
