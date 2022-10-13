package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected static Actions actions;
    protected static WebDriverWait wait;

    protected static String baseURL = "https://www.automationexercise.com/";

    // Before/After Setup/Cleanup

    @BeforeSuite
    public void initializeVariables() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Windows\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void close() {
        driver.close();
        driver.quit();
    }
}

