package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandPage extends BasePage {

    private final By products = By.xpath(XPaths.PRODUCTS.getXpath());

    public BrandPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/brand_products/";
    }

    public String getRouteForBrand(String brand) {
        return route + brand;
    }

    public int getProductCount() {
        return driver.findElements(products).size();
    }
}
