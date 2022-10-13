package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    private String route = "products";
    private By productAddedText = By.xpath("//div[contains(@class,'modal show')]");
    private By productSearchField = By.xpath("//input[contains(@name, 'search')]");
    private By productSearchButton = By.xpath("//button[contains(@id, 'submit_search')]");

    public ProductsPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
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
