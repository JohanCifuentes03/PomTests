package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserWebTableSD extends WebSetup {
    //create
    @When("they register a new account with valid data")
    public void theyRegisterANewAccountWithValidData() {

    }
    @Then("they should see their data in the table")
    public void theyShouldSeeTheirDataInTheTable() {
        quiteDrive();
    }
}
