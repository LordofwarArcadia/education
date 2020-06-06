package pages.conditions;

import org.assertj.core.api.Condition;
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

    public static Condition<Object> validDepotFieldValues(Object expected) {
        return new Condition<>(actual -> actual.equals(expected),
            "Comparing address, name and companyId, expected to see: " + expected.toString());
    }

    public static Condition<Object> validBlaBla(Object expected) {
        return new Condition<>(actual -> {
            if (!actual.getClass().equals(expected.getClass())) {
                return false;
            }
            return actual.equals(expected);
        },
            "Comparing address, name and companyId, expected to see: " + expected.toString());
    }
}
