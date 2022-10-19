package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePage extends BasePage {

    private final By accountDeletedHeader = By.xpath(XPaths.DELETE_ACCOUNT_DELETED_HEADER.getXpath());
    private final By accountDeletedMessage = By.xpath(XPaths.DELETE_ACCOUNT_DELETED_MESSAGE.getXpath());

    public DeletePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/delete_account";
    }

    public boolean accountDeletedHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountDeletedHeader));
        return driver.findElements(accountDeletedHeader).size() > 0;
    }

    public boolean accountDeletedMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountDeletedMessage));
        return driver.findElements(accountDeletedMessage).size() > 0;
    }

    public String getRoute() {
        return route;
    }
}

