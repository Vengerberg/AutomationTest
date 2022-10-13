package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private String route = "view_cart";
    private By productRemoveButtons = By.xpath("//a[contains(@class, 'cart_quantity_delete')]");
    public CartPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRoute() {
        return route;
    }

    public String getQuantityOfProduct(String productName) {
        By productQuantiy = By.xpath("//td[contains(@class, 'cart_description')]//a[contains(text(), 'Blue Top')]/ancestor::tr//td[contains(@class, 'cart_quantity')]//button");
        return driver.findElement(productQuantiy).getText();
    }

    public void emptyCart() {
        for(WebElement element: driver.findElements(productRemoveButtons)) {
            element.click();
        }
    }
}
