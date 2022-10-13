package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {

    String route = "category_products/";

    public CategoryPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRouteForCategory(String categoryId) {
        return route + categoryId;
    }

    public int getProductCount() {
        By products = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]");
        return driver.findElements(products).size();
    }
}
