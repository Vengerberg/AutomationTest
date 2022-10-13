package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By productAddedText = By.xpath("//div[contains(@class,'modal show')]");

    public HomePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public void addProduct(String productName) {
        By productButton = By.xpath("(//p[contains(text(),'" + productName + "')]//..//a[contains(@class, 'btn btn-default add-to-cart')])[1]");

        click(driver.findElement(productButton));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAddedText));
    }

    public boolean productAddedPopupVisible() {
        return driver.findElements(productAddedText).size() > 0;
    }

    public String getProductId(String productName) {
        By productButton = By.xpath("(//p[contains(text(),'" + productName + "')]//..//a[contains(@class, 'btn btn-default add-to-cart')])[1]");
        return driver.findElement(productButton).getAttribute("data-product-id");
    }

    public String getCategoryId(String group, String type) {
        By groupButton = By.xpath("//a[contains(@href, '" + group + "')][1]");
        click(driver.findElement(groupButton));

        By typeButton = By.xpath("//div[contains(@id, '" + group + "')]//a[contains(text(), '" + type + "')]");
        String[] href = driver.findElement(typeButton).getAttribute("href").split("/");
        return href[href.length - 1];
    }

    public int getProductCount() {
        By products = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]");
        return driver.findElements(products).size();
    }
}
