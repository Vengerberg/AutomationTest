package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    private final By productAddedText = By.xpath(XPaths.PRODUCT_ADDED_TEXT.getXpath());
    private final By productSearchField = By.xpath(XPaths.PRODUCT_SEARCH_FIELD.getXpath());
    private final By productSearchButton = By.xpath(XPaths.PRODUCT_SEARCH_BUTTON.getXpath());

    public ProductsPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/products";
    }

    public String getRoute() {
        return route;
    }

    public void addProduct(String productName) {
        By productButton = By.xpath("(//p[contains(text(),'" + productName + "')]//..//a[contains(@class, 'btn btn-default add-to-cart')])[1]");

        click(driver.findElement(productButton));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAddedText));
    }

    public boolean productAddedPopupVisible() {
        return driver.findElements(productAddedText).size() > 0;
    }

    public void search(String searchTerm) {
        sendKeys(driver.findElement(productSearchField), searchTerm);
        click(driver.findElement(productSearchButton));
    }

    public boolean productsContainSearchTerm(String searchTerm) {
        By productsSearched = By.xpath("//div[contains(@class, 'productinfo text-center')]//p[contains(text(), '" + searchTerm + "')]");
        return driver.findElements(productsSearched).size() > 0;
    }
}
