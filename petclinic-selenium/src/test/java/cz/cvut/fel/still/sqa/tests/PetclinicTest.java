package cz.cvut.fel.still.sqa.tests;

import cz.cvut.fel.still.sqa.page_objects.FindOwnersPage;
import cz.cvut.fel.still.sqa.page_objects.HomePage;
import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetclinicTest extends DriverBase {

    @Test
    @Order(1)
    public void loadHomepageTest() {
        new HomePage(driver);
    }

    @Test
    @Order(2)
    public void listOwnersTest() {
        FindOwnersPage findOwnersPage = FindOwnersPage.goTo("http://localhost:8080/owners/find", driver);
        findOwnersPage.enterLastName("Davis").find();
    }
}
