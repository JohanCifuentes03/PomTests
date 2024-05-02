package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.model.WebTableModel;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.PageFactoryWebTable;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SearchUserWebTableSD extends WebSetup {
    PageFactoryWebTable pageFactoryWebTable;
    private WebTableModel webTableModel;
    private String expectedEmail;

    // Search
    @Given("navigates to the account management page")
    public void navigatesToTheAccountManagementPage() {
        try {
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryWebTable = new PageFactoryWebTable(driver);
            pageFactoryMain.navigateToElementsPage();
            pageFactoryWebTable.openPracticeWebTable();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @When("they search for their account by {string}")
    public void theySearchForTheirAccountBy(String email) {
        try {
            pageFactoryWebTable.searchForEmail(email);
            webTableModel = pageFactoryWebTable.getFoundedTableModel();
            expectedEmail = email;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @Then("they should see their account details displayed in the web table")
    public void theyShouldSeeTheirAccountDetailsDisplayedInTheWebTable() {
        try {
            Assertions.assertEquals(expectedEmail, webTableModel.getEmail());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}
