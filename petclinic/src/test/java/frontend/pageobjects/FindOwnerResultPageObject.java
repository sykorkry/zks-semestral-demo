package frontend.pageobjects;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Vaclav Rechtberger
 */
public class FindOwnerResultPageObject {
    public static final Target NAME_TEXTFIELD = Target
            .the("Name text field")
            .located(By.xpath("//th[text()=\"Name\"]/following-sibling::td"));
}
