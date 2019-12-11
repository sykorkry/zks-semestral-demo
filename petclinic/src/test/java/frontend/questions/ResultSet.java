package frontend.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static frontend.pageobjects.FindOwnerResultPageObject.NAME_TEXTFIELD;


/**
 * @author Vaclav Rechtberger
 */
public class ResultSet implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(NAME_TEXTFIELD)
                .viewedBy(actor)
                .asString();
    }

    public static Question<String> displayedName() {
        return new ResultSet();
    }
}
