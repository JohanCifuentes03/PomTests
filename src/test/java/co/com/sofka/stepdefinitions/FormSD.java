package co.com.sofka.stepdefinitions;

import co.com.sofka.page.FormPageFactory;
import co.com.sofka.page.MainPage;
import co.com.sofka.setup.WebSetup;
import co.com.sofka.webenums.WebBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FormSD extends WebSetup {
    private FormPageFactory formPageFactory;

    @Given("the user is on the demoqa main page using {string}")
    public void theUserIsOnTheDemoqaMainPageUsing(String arg0) {
        try {
            generalSetup(WebBrowser.valueOf(arg0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Given("navigates to the registration form")
    public void navigatesToTheRegistrationForm() {
        try {
            MainPage mainPage = new MainPage(driver);
            formPageFactory = new FormPageFactory(driver);
            mainPage.navigateToFormPage();
            formPageFactory.openPracticeForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("they enter their data correctly")
    public void theyEnterTheirDataCorrectly() {
        try {
            formPageFactory.fillOutForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("submit the form")
    public void submitTheForm() {
        try {
            formPageFactory.submitForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("they should see a welcome message")
    public void theyShouldSeeAWelcomeMessage() {
        try {

            Assertions.assertEquals("Thanks for submitting the form", formPageFactory.getThanksMessage());

            Assertions.assertEquals(formPageFactory.getStudentNameMessage(),
                    formPageFactory.getUser().getName() + " " + formPageFactory.getUser().getLastName());

            Assertions.assertEquals(formPageFactory.getStudentEmailMessage(),
                    formPageFactory.getUser().getEmail());

            Assertions.assertEquals(formPageFactory.getStudentAddressMessage(),
                    formPageFactory.getUser().getAddress());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        } finally {
            quiteDrive();
        }
    }
}
