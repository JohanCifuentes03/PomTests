package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchUserWebTableSD extends WebSetup {
    // Search
    @Given("navigates to the account management page")
    public void navigatesToTheAccountManagementPage() {

    }
    @When("they search for their account by {string}")
    public void theySearchForTheirAccountBy(String string) {

    }
    @Then("they should see their account details displayed in the web table")
    public void theyShouldSeeTheirAccountDetailsDisplayedInTheWebTable() {
        quiteDrive();
    }
}
