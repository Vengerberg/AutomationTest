package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.github.javafaker.Faker;
import util.ExcelReader;

import java.io.File;
import java.sql.Timestamp;
import java.time.Duration;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected static Actions actions;
    protected static WebDriverWait wait;
    protected static Faker faker;
    protected static String email;
    protected static String password;
    protected static String firstName;
    protected static String lastName;
    protected static String title;
    protected static String phone;
    protected static String birthDay;
    protected static String birthMonth;
    protected static String birthYear;

    // address
    protected static String address;
    protected static String country;
    protected static String city;
    protected static String state;
    protected static String zip;

    // card details
    protected static String creditCard;
    protected static String cvc;
    protected static String expirationMonth;
    protected static String expirationYear;

    protected static String baseURL = "https://www.automationexercise.com";

    protected static ExcelReader data;

    // Before/After Setup/Cleanup
    @BeforeTest
    @Parameters({"browser"})
    public void initializeVariables(String browser) {
        // https://bonigarcia.dev/webdrivermanager/#setup <- Remove need for System properties/manual download of ChromeDriver
        if(browser.equalsIgnoreCase("chrome")) {
            System.out.println("Chrome driver");
            WebDriverManager.chromedriver().setup();

            // https://chromedriver.chromium.org/extensions <-- Installing extensions reference
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File("extensions/Chromium/ublock.crx"));
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("firefox")) {
            System.out.println("FireFox driver");
            WebDriverManager.firefoxdriver().setup();

            FirefoxProfile profile = new FirefoxProfile();
            // ublock origin having issues loading, using adblocker instead for FireFox tests
            // profile.addExtension(new File("extensions/FireFox/ublock_origin-1.44.4.xpi"));
            profile.addExtension(new File("extensions/FireFox/adblocker_ultimate-3.7.19.xpi"));

            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
        } else if(browser.equalsIgnoreCase("edge")) {
            System.out.println("Edge driver");
            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addExtensions(new File("extensions/Chromium/ublock.crx"));
            driver = new EdgeDriver(options);
        }

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        faker = new Faker();

        email = faker.bothify("???????9#@gmail.com");
        password = faker.bothify("????????###");
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        phone = faker.phoneNumber().cellPhone();

        if((int)(Math.random()*10)+1 > 5) {
            title = "Mr";
        } else {
            title = "Mrs";
        }

        birthDay = faker.numerify("#");
        birthMonth = faker.numerify("#");
        birthYear = faker.numerify("19##");

        address = faker.address().streetAddress();
        country = "United States";
        city = faker.address().city();
        state = faker.address().state();
        zip = faker.address().zipCode();

        creditCard = faker.numerify("################");
        cvc = faker.numerify("###");
        expirationMonth = faker.numerify("##");
        expirationYear = faker.numerify("####");

        data = new ExcelReader("AutomationTestData.xlsx");
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void takeScreenshot() {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time = timestamp.toString().replaceAll(" ", "-").replaceAll(":", "-").replaceAll("\\.", "-");
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(System.getProperty("user.dir") + "/screenshots/" + time + ".png");
            FileUtils.copyFile(SrcFile, DestFile);
        } catch(Exception e) {
            System.out.println("Error taking screenshot");
        }
    }

    @AfterTest
    public void close() {
        // check for soft assert errors
        driver.close();
        driver.quit();
    }

    @DataProvider(name = "product-provider")
    public Object[][] getProducts() {
        return data.getProducts();
    }

    @DataProvider(name = "multi-product-provider")
    public Object[][] getMultiProducts() {
        return data.getMultiProducts();
    }

    @DataProvider(name = "random-product-provider")
    public Object[][] getRandomProduct() {
        String[][] products = data.getProducts();
        int randomProduct = (int) (Math.random()*products.length);
        return new String[][]{products[randomProduct]};
    }

    @DataProvider(name = "brand-provider")
    public Object[][] getBrands() {
        return data.getBrands();
    }

    @DataProvider(name = "category-provider")
    public Object[][] getCategories() {
        return data.getCategories();
    }
}
