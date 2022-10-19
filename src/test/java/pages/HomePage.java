package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private final By loginButton = By.xpath(XPaths.HOME_LOGIN_BTN.getXpath());
    private final By continueShoppingButton = By.xpath(XPaths.HOME_CONTINUE_SHOPPING.getXpath());
    private final By productAddedText = By.xpath(XPaths.HOME_PRODUCT_ADDED.getXpath());
    private final By popupViewCart = By.xpath(XPaths.HOME_POPUP_VIEW_CART.getXpath());
    private final By viewCart = By.xpath(XPaths.HOME_VIEW_CART.getXpath());
    private final By logoutButton = By.xpath(XPaths.HOME_LOGOUT_BTN.getXpath());
    private final By deleteAccountButton = By.xpath(XPaths.HOME_DELETE_BTN.getXpath());


    public HomePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public void addProduct(String productName) {
        By productButton = By.xpath("(//p[contains(text(),'" + productName + "')]//..//a[contains(@class, 'btn btn-default add-to-cart')])[1]");

        click(driver.findElement(productButton));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAddedText));
    }

    public void clickContinueShopping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
        click(driver.findElement(continueShoppingButton));
    }

    public void clickDeleteAccountButton() {
        click(driver.findElement(deleteAccountButton));
    }

    public boolean productAddedPopupVisible() {
        return driver.findElements(productAddedText).size() > 0;
    }

    public void clickLogin() {
        click(driver.findElement(loginButton));
    }

    public void clickLogout() {
        click(driver.findElement(logoutButton));
    }

    public void clickViewCart() {
        click(driver.findElement(viewCart));
    }

    public void clickBrandFilterButton(String productName) {
        By brandFilterButton = By.xpath("//a[contains(@href, '" + productName + "')]");
        click(driver.findElement(brandFilterButton));
    }

    public String getProductId(String productName) {
        By productButton = By.xpath("(//p[contains(text(),'" + productName + "')]//..//a[contains(@class, 'btn btn-default add-to-cart')])[1]");
        return driver.findElement(productButton).getAttribute("data-product-id");
    }

    public String getProductCost(String productName) {
        By productCost = By.xpath("(//p[contains(text(),'" + productName + "')]//..//h2)[1]");
        return driver.findElement(productCost).getText();
    }

    public String getCategoryId(String group, String type) {
        By groupButton = By.xpath("//a[contains(@href, '" + group +"')][1]");
        click(driver.findElement(groupButton));

        By typeButton = By.xpath("//div[contains(@id, '"+ group +"')]//a[contains(text(), '"+ type +"')]");
        String[] href = driver.findElement(typeButton).getAttribute("href").split("/");
        return href[href.length-1];
    }

    public void clickViewCartFromPopup() {
        click(driver.findElement(popupViewCart));
    }

    public int getProductCount() {
        By products = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]");
        return driver.findElements(products).size();
    }

    public boolean logoutIsVisible() {
        return driver.findElements(logoutButton).size() > 0;
    }

    public boolean deleteAccountIsVisible() {
        return driver.findElements(deleteAccountButton).size() > 0;
    }
}
