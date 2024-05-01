package co.com.sofka.stepdefinitions;

import co.com.sofka.page.PageFactoryForm;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import co.com.sofka.webenums.WebBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FormSD extends WebSetup {
    private PageFactoryForm pageFactoryForm;

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
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryForm = new PageFactoryForm(driver);
            pageFactoryMain.navigateToFormPage();
            pageFactoryForm.openPracticeForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("they enter their data correctly")
    public void theyEnterTheirDataCorrectly() {
        try {
            pageFactoryForm.fillOutForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("submit the form")
    public void submitTheForm() {
        try {
            pageFactoryForm.submitForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("they should see a welcome message")
    public void theyShouldSeeAWelcomeMessage() {
        try {

            Assertions.assertEquals("Thanks for submitting the form", pageFactoryForm.getThanksMessage());

            Assertions.assertEquals(pageFactoryForm.getStudentNameMessage(),
                    pageFactoryForm.getUser().getName() + " " + pageFactoryForm.getUser().getLastName());

            Assertions.assertEquals(pageFactoryForm.getStudentEmailMessage(),
                    pageFactoryForm.getUser().getEmail());

            Assertions.assertEquals(pageFactoryForm.getStudentAddressMessage(),
                    pageFactoryForm.getUser().getAddress());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
