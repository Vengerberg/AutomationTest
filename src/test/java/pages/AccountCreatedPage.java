package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends BasePage {

    private final By confirmationMessage = By.xpath(XPaths.ACCOUNT_CREATION_CONFIRMATION_MESSAGE.getXpath());
    private final By continueButton = By.xpath(XPaths.ACCOUNT_CREATION_CONTINUE_BUTTON.getXpath());

    public AccountCreatedPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/account_created";
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

