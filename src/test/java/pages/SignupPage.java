package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    private String route = "signup";
    private By nameField = By.xpath("//form//input[contains(@id, 'name')]");
    private By emailField = By.xpath("//form//input[contains(@id, 'email')]");

    private By passwordField = By.xpath("//form//input[contains(@id, 'password')]");
    private By birthDateDay = By.xpath("//form//select[contains(@id, 'days')]");

    private By birthDateMonth = By.xpath("//form//select[contains(@id, 'month')]");

    private By birthDateYear = By.xpath("//form//select[contains(@id, 'year')]");
    private By firstNameField = By.xpath("//form//input[contains(@id, 'first_name')]");

    private By lastNameField = By.xpath("//form//input[contains(@id, 'last_name')]");
    private By addressField = By.xpath("//form//input[contains(@id, 'address1')]");
    private By countryField = By.xpath("//form//select[contains(@id, 'country')]");
    private By stateField = By.xpath("//form//input[contains(@id, 'state')]");
    private By cityField = By.xpath("//form//input[contains(@id, 'city')]");
    private By zipField = By.xpath("//form//input[contains(@id, 'zip')]");
    private By mobilePhoneField = By.xpath("//form//input[contains(@id, 'mobile')]");
    private By createAccountButton = By.xpath("//form//button[contains(@data-qa, 'create-account')]");
    private By emailAlreadyExistsMessage = By.xpath("//p[contains(text(), 'Email Address already exist')]");

    public SignupPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
    }

    public String getRoute() {
        return route;
    }

    public void signup(String firstName, String lastName, String password,
                       String day, String month, String year,
                       String address, String country, String state, String city, String zip,
                       String mobilePhoneNumber) {
        sendKeys(driver.findElement(passwordField), password);

        By selectDay = By.xpath("//form//select[contains(@id, 'days')]//option[contains(@value, '" + day + "')]");;
        click(driver.findElement(birthDateDay));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDay));
        driver.findElement(selectDay).click();

        By selectMonth = By.xpath("//form//select[contains(@id, 'months')]//option[contains(@value, '" + month + "')]");;
        click(driver.findElement(birthDateMonth));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectMonth));
        driver.findElement(selectMonth).click();

        By selectYear = By.xpath("//form//select[contains(@id, 'years')]//option[contains(@value, '" + year + "')]");;
        click(driver.findElement(birthDateYear));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectYear));
        driver.findElement(selectYear).click();

        sendKeys(driver.findElement(firstNameField), firstName);
        sendKeys(driver.findElement(lastNameField), lastName);
        sendKeys(driver.findElement(addressField), address);

        By selectCountry = By.xpath("//form//select[contains(@id, 'country')]//option[contains(@value, '" + country + "')]");
        click(driver.findElement(countryField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
        driver.findElement(selectCountry).click();

        sendKeys(driver.findElement(stateField), state);
        sendKeys(driver.findElement(cityField), city);
        sendKeys(driver.findElement(zipField), zip);
        sendKeys(driver.findElement(mobilePhoneField), mobilePhoneNumber);

        click(driver.findElement(createAccountButton));
    }

    public String getName() {
        return driver.findElement(nameField).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public boolean emailAlreadyExistsIsVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailAlreadyExistsMessage));
        return driver.findElements(emailAlreadyExistsMessage).size() > 0;
    }

}
