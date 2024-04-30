package co.com.sofka.stepdefinitions;

import co.com.sofka.model.AlertsModel;
import co.com.sofka.page.AlertsPageFactory;
import co.com.sofka.page.MainPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AlertsSD extends WebSetup {
    private final String EXPECTED_CONFIRMATION_MSG = "You selected Ok";
    private AlertsPageFactory alertsPageFactory;

    @Given("navigates to the alerts page")
    public void navigatesToTheAlertsPage() {
        try {
            MainPage mainPage = new MainPage(driver);
            alertsPageFactory = new AlertsPageFactory(driver);
            mainPage.navigateToAlertsPage();
            alertsPageFactory.openPracticeForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("interacts with all alerts")
    public void interactsWithAllAlerts() {
        try {
            alertsPageFactory.interactWithAlerts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("should see a green message confirming successful interaction")
    public void shouldSeeAGreenMessageConfirmingSuccessfulInteraction() {
        try {
            AlertsModel alertsModel = alertsPageFactory.getAlertsModel();
            Assertions.assertEquals(EXPECTED_CONFIRMATION_MSG, alertsPageFactory.getConfirmAlertMessage());
            Assertions.assertEquals(alertsPageFactory.getPromptAlertMessage(), "You entered " + alertsModel.getPromptMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
