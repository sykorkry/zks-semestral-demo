package frontend.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Vaclav Rechtberger
 */
public class FindOwnersForm {
    public static final Target LAST_NAME_TEXTBOX = Target
            .the("Last name textbox")
            .located(By.xpath("//input[@id=\"lastName\"]"));
}
