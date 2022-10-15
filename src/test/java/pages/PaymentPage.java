package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

    private final By nameField = By.xpath(XPaths.PAYMENT_NAME.getXpath());
    private final By cardField = By.xpath(XPaths.PAYMENT_CARD.getXpath());
    private final By cvcField = By.xpath(XPaths.PAYMENT_CVC.getXpath());
    private final By expirationMonthField = By.xpath(XPaths.PAYMENT_EXP_MONTH.getXpath());
    private final By expirationYearField = By.xpath(XPaths.PAYMENT_EXP_YEAR.getXpath());
    private final By submitButton = By.xpath(XPaths.PAYMENT_SUBMIT.getXpath());

    public PaymentPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/payment";
    }

    public String getRoute() {
        return route;
    }

    public void placeOrder(String name, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        sendKeys(driver.findElement(nameField), name);
        sendKeys(driver.findElement(cardField), cardNumber);
        sendKeys(driver.findElement(cvcField), cvc);
        sendKeys(driver.findElement(expirationMonthField), expirationMonth);
        sendKeys(driver.findElement(expirationYearField), expirationYear);
        click(driver.findElement(submitButton));
    }
}
