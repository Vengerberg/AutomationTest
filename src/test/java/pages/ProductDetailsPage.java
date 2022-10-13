package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    private String route = "product_details/";
    private By productAddedText = By.xpath("//div[contains(@class,'modal show')]");
    private By popupViewCart = By.xpath("//div[contains(@class,'modal show')]//a[contains(@href, '/view_cart')]");
    private By productButton = By.xpath("//button[contains(@class,'btn btn-default cart')]");
    private By quantityField = By.xpath("//input[contains(@id,'quantity')]");


    public ProductDetailsPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRouteForProduct(String productId) {
        return route + productId;
    }

    public void addProduct() {
        click(driver.findElement(productButton));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAddedText));
    }

    public void setQuantity(int quantity) {
        clearKeys(driver.findElement(quantityField));
        sendKeys(driver.findElement(quantityField), "3");
    }

    public void clickViewCartFromPopup() {
        click(driver.findElement(popupViewCart));
    }

    public boolean productAddedPopupVisible() {
        return driver.findElements(productAddedText).size() > 0;
    }

}
