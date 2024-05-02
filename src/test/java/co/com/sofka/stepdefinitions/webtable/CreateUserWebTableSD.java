package co.com.sofka.stepdefinitions.webtable;

import co.com.sofka.model.WebTableModel;
import co.com.sofka.page.PageFactoryWebTable;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CreateUserWebTableSD extends WebSetup {
    //create
    private PageFactoryWebTable pageFactoryWebTable;
    @When("they register a new account with valid data")
    public void theyRegisterANewAccountWithValidData() {
        try {
            pageFactoryWebTable = new PageFactoryWebTable(driver);
            pageFactoryWebTable.createUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @Then("they should see their data in the table")
    public void theyShouldSeeTheirDataInTheTable() {
        try {
            WebTableModel createdModel = pageFactoryWebTable.getCreatedTableModel();
            pageFactoryWebTable.searchForEmail(createdModel.getEmail());
            WebTableModel foundedModel = pageFactoryWebTable.getFoundedTableModel();
            System.out.println(createdModel);
            System.out.println(foundedModel);
            Assertions.assertEquals(createdModel.getEmail(), foundedModel.getEmail());
            Assertions.assertEquals(createdModel.getFirstName(), foundedModel.getFirstName());
            Assertions.assertEquals(createdModel.getLastName(), foundedModel.getLastName());
            Assertions.assertEquals(createdModel.getDepartment(), foundedModel.getDepartment());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();

        }finally {
            quiteDrive();
        }
    }
}
