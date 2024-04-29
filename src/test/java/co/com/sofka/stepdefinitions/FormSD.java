package co.com.sofka.stepdefinitions;

import co.com.sofka.page.FormPage;
import co.com.sofka.page.MainPage;
import co.com.sofka.setup.WebSetup;
import co.com.sofka.webenums.WebBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FormSD extends WebSetup {
    private FormPage formPage;

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
            formPage = new FormPage(driver);
            mainPage.navigateToFormPage();
            formPage.openPracticeForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("they enter their data correctly")
    public void theyEnterTheirDataCorrectly() {
        try {
            formPage.fillOutForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @When("submit the form")
    public void submitTheForm() {
        try {
            formPage.submitForm();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }

    @Then("they should see a welcome message")
    public void theyShouldSeeAWelcomeMessage() {
        try {

            Assertions.assertEquals("Thanks for submitting the form", formPage.getThanksMessage());

            Assertions.assertEquals(formPage.getStudentNameMessage(),
                    formPage.getUser().getName() + " " + formPage.getUser().getLastName());

            Assertions.assertEquals(formPage.getStudentEmailMessage(),
                    formPage.getUser().getEmail());

            Assertions.assertEquals(formPage.getStudentAddressMessage(),
                    formPage.getUser().getAddress());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        } finally {
            quiteDrive();
        }
    }
}
