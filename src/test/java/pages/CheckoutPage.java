package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    private final By deliveryName = By.xpath(XPaths.CHECKOUT_DELIVERY_NAME.getXpath());
    private final By deliveryAddress = By.xpath(XPaths.CHECKOUT_DELIVERY_ADDRESS.getXpath());
    private final By deliveryStateCityZip = By.xpath(XPaths.CHECKOUT_DELIVERY_STATE_CITY_ZIP.getXpath());
    private final By deliveryCountry = By.xpath(XPaths.CHECKOUT_DELIVERY_COUNTRY.getXpath());
    private final By deliveryPhone = By.xpath(XPaths.CHECKOUT_DELIVERY_PHONE.getXpath());
    private final By invoiceName = By.xpath(XPaths.CHECKOUT_INVOICE_NAME.getXpath());
    private final By invoiceAddress = By.xpath(XPaths.CHECKOUT_INVOICE_ADDRESS.getXpath());
    private final By invoiceStateCityZip = By.xpath(XPaths.CHECKOUT_INVOICE_STATE_CITY_ZIP.getXpath());
    private final By invoiceCountry = By.xpath(XPaths.CHECKOUT_INVOICE_COUNTRY.getXpath());
    private final By invoicePhone = By.xpath(XPaths.CHECKOUT_INVOICE_PHONE.getXpath());
    private final By productTotals = By.xpath(XPaths.CHECKOUT_PRODUCT_TOTALS.getXpath());
    private final By cartTotal = By.xpath(XPaths.CHECKOUT_CART_TOTAL.getXpath());
    private final By placeOrderButton = By.xpath(XPaths.CHECKOUT_PLACE_ORDER_BTN.getXpath());

    public CheckoutPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/checkout";
    }

    public String getRoute() {
        return route;
    }

    public boolean addressIsDisplayedCorrectly(String title, String firstName, String lastName, String address, String country, String state, String city, String zip, String mobilePhoneNumber) {
        boolean deliveryNameCorrect = driver.findElement(deliveryName).getText().equals(title + ". " + firstName + " " + lastName);
        boolean deliveryAddressCorrect = driver.findElement(deliveryAddress).getText().equals(address);
        boolean deliveryStateCityZipCorrect = driver.findElement(deliveryStateCityZip).getText().equals(city + " " + state + " " + zip);
        boolean deliveryCountryCorrect = driver.findElement(deliveryCountry).getText().equals(country);
        boolean deliveryMobilePhoneCorrect = driver.findElement(deliveryPhone).getText().equals(mobilePhoneNumber);

        return deliveryNameCorrect && deliveryAddressCorrect && deliveryStateCityZipCorrect && deliveryCountryCorrect && deliveryMobilePhoneCorrect;
    }

    public boolean invoiceIsDisplayedCorrectly(String title, String firstName, String lastName, String address, String country, String state, String city, String zip, String mobilePhoneNumber) {
        boolean invoiceNameCorrect = driver.findElement(invoiceName).getText().equals(title + ". " + firstName + " " + lastName);
        boolean invoiceAddressCorrect = driver.findElement(invoiceAddress).getText().equals(address);
        boolean invoiceStateCityZipCorrect = driver.findElement(invoiceStateCityZip).getText().equals(city + " " + state + " " + zip);
        boolean invoiceCountryCorrect = driver.findElement(invoiceCountry).getText().equals(country);
        boolean invoiceMobilePhoneCorrect = driver.findElement(invoicePhone).getText().equals(mobilePhoneNumber);

        return invoiceNameCorrect && invoiceAddressCorrect && invoiceStateCityZipCorrect && invoiceCountryCorrect && invoiceMobilePhoneCorrect;
    }

    public boolean productPricesDisplayedCorrectly() {
        int total = 0;

        for(WebElement element: driver.findElements(productTotals)) {
            total += Integer.parseInt(element.getText().replaceAll("Rs. ", ""));
        }

        int totalInCart = Integer.parseInt(driver.findElement(cartTotal).getText().replaceAll("Rs. ", ""));

        return totalInCart == total;
    }

    public String getCartTotal() {
        return driver.findElement(cartTotal).getText().replaceAll("Rs. ", "");
    }

    public void clickPlaceOrderButton() {
        click(driver.findElement(placeOrderButton));
    }
}
