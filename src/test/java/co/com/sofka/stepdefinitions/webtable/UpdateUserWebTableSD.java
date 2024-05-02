package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.page.PageFactoryWebTable;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UpdateUserWebTableSD extends WebSetup {

    private PageFactoryWebTable pageFactoryWebTable;
    private String savedUserEmail;


    @When("the user {string} updates their account's data")
    public void theUserUpdatesTheirAccountSData(String email) {
        try {
            pageFactoryWebTable = new PageFactoryWebTable(driver);
            pageFactoryWebTable.updateUserModel(email);
            savedUserEmail = email;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("they should see their data updated")
    public void theyShouldSeeTheirDataUpdated() {
        try {
            Assertions.assertEquals(savedUserEmail, pageFactoryWebTable.getFoundedTableModel().getEmail());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }

}
