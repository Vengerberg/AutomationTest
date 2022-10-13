package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }
}
