package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDonePage extends BasePage {

    private final By orderPlacedMessage = By.xpath(XPaths.PAYMENT_DONE_ORDER_PLACED.getXpath());
    private final By congratulationsMessage = By.xpath(XPaths.PAYMENT_DONE_CONGRATS_MSG.getXpath());
    private final By continueButton = By.xpath(XPaths.PAYMENT_DONE_CONTINUE.getXpath());
    public PaymentDonePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/payment_done/";
    }

    public String getRoute(String cartTotal) {
        return route + cartTotal;
    }

    public boolean orderPlacedMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedMessage));
        return driver.findElements(orderPlacedMessage).size() > 0;
    }

    public boolean congratulationsMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(congratulationsMessage));
        return driver.findElements(congratulationsMessage).size() > 0;
    }

    public void clickContinueButton() {
        click(driver.findElement(continueButton));
    }
}
