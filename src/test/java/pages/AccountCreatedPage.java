package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends BasePage {

    private String route = "account_created";
    private By confirmationMessage = By.xpath("//p[contains(text(), 'Congratulations')]");
    private By continueButton = By.xpath("//a[contains(@data-qa, 'continue-button')]");

    public AccountCreatedPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRoute() {
        return route;
    }

    public boolean accountCreatedMessageVisible() {
        return driver.findElements(confirmationMessage).size() > 0;
    }

    public void clickContinueButton() {
        click(driver.findElement(continueButton));
    }
}
