package co.com.sofka.stepdefinitions;

import co.com.sofka.model.AlertsModel;
import co.com.sofka.page.PageFactoryAlerts;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AlertsSD extends WebSetup {
    private PageFactoryAlerts pageFactoryAlerts;

    @Given("navigates to the alerts page")
    public void navigatesToTheAlertsPage() {
        try {
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryAlerts = new PageFactoryAlerts(driver);
            pageFactoryMain.navigateToAlertsPage();
            pageFactoryAlerts.openPracticeForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("interacts with all alerts")
    public void interactsWithAllAlerts() {
        try {
            pageFactoryAlerts.interactWithAlerts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("should see a green message confirming successful interaction")
    public void shouldSeeAGreenMessageConfirmingSuccessfulInteraction() {
        try {
            AlertsModel alertsModel = pageFactoryAlerts.getAlertsModel();
            String EXPECTED_CONFIRMATION_MSG = "You selected Ok";
            Assertions.assertEquals(EXPECTED_CONFIRMATION_MSG, pageFactoryAlerts.getConfirmAlertMessage());
            Assertions.assertEquals(pageFactoryAlerts.getPromptAlertMessage(), "You entered " + alertsModel.getPromptMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
