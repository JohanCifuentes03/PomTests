package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.page.PageFactoryWebTable;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DeleteUserWebTableSD extends WebSetup {
    private PageFactoryWebTable pageFactoryWebTable;
    private String deletedAccount;
    // delete
    @When("the user {string} deletes its accounts")
    public void theUserDeletesItsAccounts(String email) {
        try {
            pageFactoryWebTable = new PageFactoryWebTable(driver);
            pageFactoryWebTable.deleteUser(email);
            deletedAccount = email;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @Then("they should not see their data in the table")
    public void theyShouldNotSeeTheirDataInTheTable() {
        pageFactoryWebTable.searchForEmail(deletedAccount);
        try {
            Assertions.assertNull(pageFactoryWebTable.getFoundedTableModel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }

}
