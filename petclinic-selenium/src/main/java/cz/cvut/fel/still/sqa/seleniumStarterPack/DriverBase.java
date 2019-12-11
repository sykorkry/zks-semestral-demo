package cz.cvut.fel.still.sqa.seleniumStarterPack;

import cz.cvut.fel.still.sqa.seleniumStarterPack.config.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DriverBase {

    private String currentTestName;
    protected RemoteWebDriver driver;

    @BeforeAll
    public void setup() throws IOException {
        driver = getDriver();
    }

    public static RemoteWebDriver getDriver() throws IOException {
        return new DriverFactory().getDriver();
        // https://www.guru99.com/gecko-marionette-driver-selenium.html
        // download from https://github.com/mozilla/geckodriver/releases
        /*
        System.setProperty("webdriver.gecko.driver", "C:\\utils\\SeleniumDrivers\\FirefoxDriver_0.22\\geckodriver.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.merge(desiredCapabilities);
        options.setHeadless(false);
        return new FirefoxDriver(options);*/
    }

    @AfterAll()
    public void clearCookies() {
        try {
            driver.manage().deleteAllCookies();
        } catch (Exception ignored) {
            System.out.println("Unable to clear cookies, driver object is not viable...");
        }

        System.out.println("quit");
        driver.quit();
    }

    public static void waitForElement(WebDriver driver, final By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) d -> d.findElement(by).isDisplayed());

        /*wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });*/
    }

    protected boolean waitForJSandJQueryToLoad(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                try {
                    return ((Long) ((JavascriptExecutor) d).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return ((JavascriptExecutor) d).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}