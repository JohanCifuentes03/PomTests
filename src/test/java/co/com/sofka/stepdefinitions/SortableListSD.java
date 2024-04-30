package co.com.sofka.stepdefinitions;

import co.com.sofka.page.MainPage;
import co.com.sofka.page.OrderListPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableListSD extends WebSetup {
    private OrderListPage orderListPage;

    @Given("navigates to the interactions list page")
    public void navigatesToTheInteractionsListPage() {
        try {
            MainPage mainPage = new MainPage(driver);
            orderListPage = new OrderListPage(driver);
            mainPage.navigateToInteractionsPage();
            orderListPage.openSortableListSection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("orders the item's list")
    public void ordersTheItemSList() {
        try {
            orderListPage.sortElements();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("items should be ordered")
    public void itemsShouldBeOrdered() {
        try {
            List<WebElement> originalReversed = new ArrayList<>(orderListPage.getOriginalWebElements());
            Collections.reverse(originalReversed);
            List<WebElement> modified = orderListPage.getModifiedWebElements();
            Assertions.assertEquals(originalReversed, modified);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}


