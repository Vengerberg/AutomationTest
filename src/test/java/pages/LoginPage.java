package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By emailField = By.xpath(XPaths.LOGIN_EMAIL_FIELD.getXpath());
    private final By passwordField = By.xpath(XPaths.LOGIN_PASSWORD_FIELD.getXpath());
    private final By loginButton = By.xpath(XPaths.LOGIN_BUTTON.getXpath());
    private final By invalidLoginMessage = By.xpath(XPaths.LOGIN_INVALID_MESSAGE.getXpath());
    private final By signupNameField = By.xpath(XPaths.LOGIN_SIGN_UP_NAME_FIELD.getXpath());
    private final By signupEmailField = By.xpath(XPaths.LOGIN_SIGNUP_EMAIL_FIELD.getXpath());
    private final By signupButton = By.xpath(XPaths.LOGIN_SIGNUP_BUTTON.getXpath());
    private final By homeButton = By.xpath(XPaths.LOGIN_HOME_BUTTON.getXpath());

    public LoginPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/login";
    }

    public String getRoute() {
        return route;
    }

    public void signup(String name, String email) {
        sendKeys(driver.findElement(signupNameField), name);
        sendKeys(driver.findElement(signupEmailField), email);
        click(driver.findElement(signupButton));
    }

    public void login(String email, String password) {
        sendKeys(driver.findElement(emailField), email);
        sendKeys(driver.findElement(passwordField), password);
        click(driver.findElement(loginButton));
    }

    public boolean invalidLoginIsVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invalidLoginMessage));
        return driver.findElements(invalidLoginMessage).size() > 0;
    }

    public void clickHomeButton() {
        click(driver.findElement(homeButton));
    }
}
