package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    private final By productAddedText = By.xpath(XPaths.DETAILS_PRODUCT_ADDED_TEXT.getXpath());
    private final By popupViewCart = By.xpath(XPaths.DETAILS_POPUP_VIEW_CART.getXpath());
    private final By productButton = By.xpath(XPaths.DETAILS_PRODUCT_BUTTON.getXpath());
    private final By quantityField = By.xpath(XPaths.DETAILS_QUANTITY.getXpath());
    private final By productName = By.xpath(XPaths.DETAILS_PRODUCT_NAME.getXpath());
    private final By productCost = By.xpath(XPaths.DETAILS_PRODUCT_COST.getXpath());
    private final By reviewNameField = By.xpath(XPaths.DETAILS_REVIEW_NAME.getXpath());
    private final By reviewEmailField = By.xpath(XPaths.DETAILS_REVIEW_EMAIL.getXpath());
    private final By reviewCommentField = By.xpath(XPaths.DETAILS_COMMENT.getXpath());
    private final By reviewSubmitButton = By.xpath(XPaths.DETAILS_REVIEW_SUBMIT.getXpath());
    private final By reviewSuccessMessage = By.xpath(XPaths.DETAILS_REVIEW_SUCCESS_MSG.getXpath());

    public ProductDetailsPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/product_details/";
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
        sendKeys(driver.findElement(quantityField), String.valueOf(quantity));
    }

    public void clickViewCartFromPopup() {
        click(driver.findElement(popupViewCart));
    }

    public boolean productAddedPopupVisible() {
        return driver.findElements(productAddedText).size() > 0;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductCost() {
        return driver.findElement(productCost).getText();
    }

    public void writeReview(String name, String email, String comment) {
        sendKeys(driver.findElement(reviewNameField), name);
        sendKeys(driver.findElement(reviewEmailField), email);
        sendKeys(driver.findElement(reviewCommentField), comment);

        click(driver.findElement(reviewSubmitButton));
    }

    public boolean reviewSuccessMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSuccessMessage));
        return driver.findElements(reviewSuccessMessage).size() > 0;
    }
}
