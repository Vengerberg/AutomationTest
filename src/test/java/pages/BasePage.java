package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Objects;

public abstract class BasePage {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String route;

    public BasePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        this.driver = driver;
        this.actions = actions;
        this.wait = wait;
    }

    protected void clearKeys(WebElement element) {
        scrollTo(element);
        element.clear();
    }

    protected void sendKeys(WebElement element, String value) {
        scrollTo(element);
        element.sendKeys(value);
        wait.until(ExpectedConditions.attributeContains(element, "value", value));
    }

    protected void click(WebElement element) {
        scrollTo(element);
        element.click();
    }

    protected void scrollTo(WebElement element) {
        if(!Objects.isNull(element)) {
            actions.moveToElement(element);
            actions.perform();
            wait.until(ExpectedConditions.visibilityOf(element));
        } else {
            throw new IllegalArgumentException("The scrollable Element should not be null");
        }
    }
}
