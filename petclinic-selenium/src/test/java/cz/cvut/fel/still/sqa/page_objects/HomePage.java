package cz.cvut.fel.still.sqa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitFor() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) d -> {
            WebElement h2 = d.findElement(By.tagName("body > div > div > h2"));
            return h2.isDisplayed() && h2.getText() == "Welcome";
        });
    }
}
