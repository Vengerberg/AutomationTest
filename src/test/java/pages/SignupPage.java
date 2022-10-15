package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    private final By nameField = By.xpath(XPaths.SIGNUP_NAME_FIELD.getXpath());
    private final By emailField = By.xpath(XPaths.SIGNUP_EMAIL_FIELD.getXpath());
    private final By passwordField = By.xpath(XPaths.SIGNUP_PASSWORD_FIELD.getXpath());
    private final By birthDateDay = By.xpath(XPaths.SIGNUP_BIRTH_DATE_DAY.getXpath());
    private final By birthDateMonth = By.xpath(XPaths.SIGNUP_BIRTH_DATE_MONTH.getXpath());
    private final By birthDateYear = By.xpath(XPaths.SIGNUP_BIRTH_DATE_YEAR.getXpath());
    private final By firstNameField = By.xpath(XPaths.SIGNUP_FIRST_NAME_FIELD.getXpath());

    private final By lastNameField = By.xpath(XPaths.SIGNUP_LAST_NAME_FIELD.getXpath());
    private final By addressField = By.xpath(XPaths.SIGNUP_ADDRESS_FIELD.getXpath());
    private final By countryField = By.xpath(XPaths.SIGNUP_COUNTRY_FIELD.getXpath());
    private final By stateField = By.xpath(XPaths.SIGNUP_STATE_FIELD.getXpath());
    private final By cityField = By.xpath(XPaths.SIGNUP_CITY_FIELD.getXpath());
    private final By zipField = By.xpath(XPaths.SIGNUP_ZIP_FIELD.getXpath());
    private final By mobilePhoneField = By.xpath(XPaths.SIGNUP_MOBILE_PHONE_FIELD.getXpath());
    private final By createAccountButton = By.xpath(XPaths.SIGNUP_CREATE_ACCOUNT_BUTTON.getXpath());
    private final By emailAlreadyExistsMessage = By.xpath(XPaths.SIGNUP_EMAIL_EXISTS_MESSAGE.getXpath());

    public SignupPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        super(driver, actions, wait);
        route = "/signup";
    }

    public String getRoute() {
        return route;
    }

    public void signup(String firstName, String lastName, String title, String password,
                       String day, String month, String year,
                       String address, String country, String state, String city, String zip,
                       String mobilePhoneNumber) {
        By selectTitle = By.xpath("//input[@value='" + title + "']");
        click(driver.findElement(selectTitle));

        sendKeys(driver.findElement(passwordField), password);

        By selectDay = By.xpath("//form//select[contains(@id, 'days')]//option[contains(@value, '" + day + "')]");
        click(driver.findElement(birthDateDay));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDay));
        driver.findElement(selectDay).click();

        By selectMonth = By.xpath("//form//select[contains(@id, 'months')]//option[contains(@value, '" + month + "')]");
        click(driver.findElement(birthDateMonth));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectMonth));
        driver.findElement(selectMonth).click();

        By selectYear = By.xpath("//form//select[contains(@id, 'years')]//option[contains(@value, '" + year + "')]");
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
