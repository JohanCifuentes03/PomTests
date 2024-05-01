package co.com.sofka.stepdefinitions;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.OrderListPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SortableListSD extends WebSetup {
    private OrderListPage orderListPage;

    @Given("navigates to the interactions list page")
    public void navigatesToTheInteractionsListPage() {
        try {
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            orderListPage = new OrderListPage(driver);
            pageFactoryMain.navigateToInteractionsPage();
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
            //Collections.reverse(orderListPage.getOriginalWebElements());
            Assertions.assertEquals(
                    orderListPage.getOriginalWebElements(), orderListPage.getModifiedWebElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
