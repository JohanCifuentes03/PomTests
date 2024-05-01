package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateUserWebTableSD extends WebSetup {
    //update
    @When("the user updates their account's name from {string} to {string}")
    public void theUserUpdatesTheirAccountSNameFromTo(String string, String string2) {

    }
    @Then("they should see their data updated")
    public void theyShouldSeeTheirDataUpdated() {
        quiteDrive();
    }
}
