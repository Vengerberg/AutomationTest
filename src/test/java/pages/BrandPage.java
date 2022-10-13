package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandPage extends BasePage {

    private String route = "brand_products/";

    public BrandPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRouteForBrand(String brand) {
        return route + brand;
    }

    public int getProductCount() {
        By products = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]");
        return driver.findElements(products).size();
    }
}
