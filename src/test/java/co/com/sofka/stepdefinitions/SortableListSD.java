package co.com.sofka.stepdefinitions;

import co.com.sofka.page.MainPage;
import co.com.sofka.page.OrderListPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortableListSD extends WebSetup {
    private OrderListPage orderListPage;
    @Given("navigates to the interactions list page")
    public void navigatesToTheInteractionsListPage() {
        MainPage mainPage = new MainPage(driver);
        orderListPage = new OrderListPage(driver);
        mainPage.navigateToInteractionsPage();
        orderListPage.openSortableListSection();

    }
    @When("orders the item's list")
    public void ordersTheItemSList() {

    }
    @Then("items should be ordered")
    public void itemsShouldBeOrdered() {
        quiteDrive();
    }
}
