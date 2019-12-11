package frontend.tasks;

import frontend.pageobjects.HomePagePageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Vaclav Rechtberger
 */
public class StartOn implements Task {
    HomePagePageObject homePagePageObject;
    @Override
    @Step("{0} starts on application homepage")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(homePagePageObject)
        );
    }

    public static StartOn homePage(){
        return instrumented(StartOn.class);
    }
}
