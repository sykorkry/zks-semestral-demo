package frontend.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static frontend.pageobjects.FindOwnersForm.LAST_NAME_TEXTBOX;
import static frontend.pageobjects.MainMenuPageObject.FIND_OWNER_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Vaclav Rechtberger
 */
public class FindOwner implements Task {
    private String lastName;

    public FindOwner(String lastName) {
        this.lastName = lastName;
    }

    @Override
    @Step("{0} find owner named '#lastName'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FIND_OWNER_LINK),
                Enter.theValue(lastName).into(LAST_NAME_TEXTBOX).thenHit(Keys.ENTER)
        );
    }

    public static FindOwner withLastName(String lastName){
        return instrumented(FindOwner.class,lastName);
    }
}
