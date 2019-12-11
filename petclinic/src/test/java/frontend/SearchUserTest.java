package frontend;

import frontend.questions.ResultSet;
import frontend.tasks.FindOwner;
import frontend.tasks.StartOn;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.PetClinicApplication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.endsWith;

/**
 * @author Vaclav Rechtberger
 */
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "3")
public class SearchUserTest {
    private String lastName;
    private static Thread t;

    Actor owner = Actor.named("owner");

    @TestData(columnNames = "lastName = '#lastName'")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"Franklin"}, {"Rodriquez"}, {"Coleman"}});
    }

    public SearchUserTest(String lastName) {
        this.lastName = lastName;
    }

    @Managed
    WebDriver theBrowser;

    public static boolean pingHost(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }

    @BeforeClass
    public static void run() throws InterruptedException {
        Runnable myrunnable = new Runnable() {
            public void run() {
                PetClinicApplication.main(new String[0]);//Call your function
            }
        };

        t = new Thread(myrunnable);
        t.start();

        while(!pingHost("localhost", 8080, 2000));

    }

    @AfterClass
    public static void stop(){
        t.stop();
    }

    @Before
    public void petOwnerCanBrowseTheWeb(){
        givenThat(owner).can(BrowseTheWeb.with(theBrowser));
    }
    @Test
    @WithTag("frontend")
    public void should_be_able_to_find_user(){
        givenThat(owner).wasAbleTo(StartOn.homePage());
        when(owner).attemptsTo(FindOwner.withLastName(lastName));
        then(owner).should(seeThat(ResultSet.displayedName(),endsWith(lastName)));
    }
}
