package co.com.sofka.stepdefinitions;

import co.com.sofka.page.PageFactoryDatePicker;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DatePickerSD extends WebSetup {
    private PageFactoryDatePicker pageFactoryDatePicker;

    @Given("navigates to the datepicker page")
    public void navigatesToTheDatepickerPage() {
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryDatePicker = new PageFactoryDatePicker(driver);
        pageFactoryMain.navigateToWidgetsPage();
        pageFactoryDatePicker.openPracticeDatePicker();
    }

    @When("the user reserves a date")
    public void theUserReservesADate() {
        try{
            pageFactoryDatePicker.selectDateTime();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("the date should be successfully reserved")
    public void theDateShouldBeSuccessfullyReserved() {
        try {
            Assertions.assertEquals("October 24, 2024 7:30 PM", pageFactoryDatePicker.getDateTime());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
