package cz.cvut.fel.still.sqa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class FindOwnersPage extends BasePage {
    @FindBy(id = "lastName")
    private WebElement lastNameInputElement;

    @FindBy(id = "find-owner")
    private WebElement loginButtonElement;

    public FindOwnersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitFor() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver1 -> driver1.findElement(By.cssSelector("body > div > div > h2")).isDisplayed());
    }

    public static FindOwnersPage goTo(String baseUrl, WebDriver driver) {
        driver.get(baseUrl);
        FindOwnersPage findOwnerspage = new FindOwnersPage(driver);
        findOwnerspage.waitFor();
        return findOwnerspage;
    }

    public FindOwnersPage enterLastName(String userName) {
        lastNameInputElement.clear();
        lastNameInputElement.sendKeys(userName);
        return this;
    }

    public List<String> readOwners(){
        List<String> ret = new LinkedList<>();
        driver.findElements(By.cssSelector("/table//td[1]")).forEach((owner) -> ret.add(owner.getText()));
        return ret;
    }

    public void find() {
        loginButtonElement.click();
    }

}
