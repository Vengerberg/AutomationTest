package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage {
    private final By products = By.xpath(XPaths.PRODUCTS.getXpath());

    public CategoryPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/category_products/";
    }

    public String getRouteForCategory(String categoryId) {
        return route + categoryId;
    }

    public int getProductCount() {
        return driver.findElements(products).size();
    }
}
