package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteUserWebTableSD extends WebSetup {
    // delete
    @When("they delete their account")
    public void theyDeleteTheirAccount() {
    }
    @Then("they should not see their data in the table")
    public void theyShouldNotSeeTheirDataInTheTable() {
        quiteDrive();
    }
}
