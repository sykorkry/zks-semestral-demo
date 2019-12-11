package frontend.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * @author Vaclav Rechtberger
 */
public class MainMenuPageObject extends PageObject {
    public static final Target FIND_OWNER_LINK = Target
            .the("Find owner link")
            .located(By.xpath("//a[@title=\"find owners\"]"));
}
