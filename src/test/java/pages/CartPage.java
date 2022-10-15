package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private final By checkoutButton = By.xpath(XPaths.CART_CHECKOUT_BTN.getXpath());
    private final By continueOnCartButton = By.xpath(XPaths.CART_CONTINUE_BTN.getXpath());
    private final By productRemoveButtons = By.xpath(XPaths.CART_REMOVE_BTN.getXpath());
    private final By products = By.xpath(XPaths.CART_PRODUCTS.getXpath());
    private final By emptyMessage = By.xpath(XPaths.CART_EMPTY_MSG.getXpath());

    public CartPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/view_cart";
    }

    public String getRoute() {
        return route;
    }

    public String getQuantityOfProduct(String productName) {
        By productQuantiy = By.xpath("//td[contains(@class, 'cart_description')]//a[contains(text(), '" + productName + "')]/ancestor::tr//td[contains(@class, 'cart_quantity')]//button");
        return driver.findElement(productQuantiy).getText();
    }

    public void emptyCart() {
        for(WebElement element: driver.findElements(productRemoveButtons)) {
            element.click();
        }
    }

    public void proceedToCheckout() {
        click(driver.findElement(checkoutButton));
    }

    public boolean registerOrLoginPopupVisible() {
        return driver.findElements(continueOnCartButton).size() > 0;
    }

    public void continueOnCartFromPopup() {
        click(driver.findElement(continueOnCartButton));
    }

    public int getCartSize() {
        return driver.findElements(products).size();
    }

    public void waitForEmptyMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMessage));
    }
}
