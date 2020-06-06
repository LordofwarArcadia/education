package pages.conditions;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {

    public static ExpectedCondition<WebDriver> ourCustomExpectedCondition(
        final int frameLocator) {
        return new ExpectedCondition<WebDriver>() {
            @Override
            public WebDriver apply(WebDriver driver) {
                try {
                    return driver.switchTo().frame(frameLocator);
                } catch (NoSuchFrameException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "frame to be available: " + frameLocator;
            }
        };
    }

}
