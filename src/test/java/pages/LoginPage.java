package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private String route = "login";
    private By signupNameField = By.xpath("//form[contains(@action, '/signup')]//input[contains(@type, 'text')]");
    private By signupEmailField = By.xpath("//form[contains(@action, '/signup')]//input[contains(@type, 'email')]");
    private By signupButton = By.xpath("//form[contains(@action, '/signup')]//button");


    public LoginPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRoute() {
        return route;
    }

    public void signup(String name, String email) {
        sendKeys(driver.findElement(signupNameField), name);
        sendKeys(driver.findElement(signupEmailField), email);
        click(driver.findElement(signupButton));
    }

}
