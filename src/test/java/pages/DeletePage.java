package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePage extends BasePage {

    private final By deleteButton = By.xpath(XPaths.DELETE_DELETE_BTN.getXpath());

    public DeletePage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/delete_account";
    }

    public void clickDeleteButton() {
        click(driver.findElement(deleteButton));
    }

    public String getRoute() {
        return route;
    }
}
