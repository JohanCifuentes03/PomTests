package co.com.sofka.page;

import co.com.sofka.model.AlertsModel;
import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static co.com.sofka.util.ModelCreator.createAlertsModel;

public class AlertsPageFactory extends CommonFunctions {

    private final AlertsModel alertsModel = createAlertsModel();

    // redirect form practice element
    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Alerts']")
    private WebElement ALERTS_PRACTICE_LI;


    // Basic alert interaction
    @CacheLookup
    @FindBy(id = "alertButton")
    private WebElement BUTTON_BASIC_ALERT;


    // Timer alert
    @CacheLookup
    @FindBy(id = "timerAlertButton")
    private WebElement BUTTON_TIMER_ALERT;



    // Confirm alert
    @CacheLookup
    @FindBy(id = "confirmButton")
    private WebElement BUTTON_CONFIRM_ALERT;
    @CacheLookup
    @FindBy(id = "confirmResult")
    private WebElement CONFIRM_ALERT_MSG;
    private String confirmAlertMessage;



    // Prompt alert
    @CacheLookup
    @FindBy(id = "promtButton")
    private WebElement BUTTON_PROMPT_ALERT;
    @CacheLookup
    @FindBy(id = "promptResult")
    private WebElement PROMPT_ALERT_MSG;
    private String promptAlertMessage;


    public AlertsPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void interactWithAlerts() {
        solveBasicAlert();
        solveTimerAlert();
        solveConfirmAlert();
        solvePromptAlert();
    }


    private void solveBasicAlert() {
        openBasicAlert();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    private void solveTimerAlert() {
        openTimerAlert();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(6))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    private void solveConfirmAlert() {
        openConfirmAlert();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        confirmAlertMessage = getText(CONFIRM_ALERT_MSG);
        System.out.println(confirmAlertMessage);
    }

    private void solvePromptAlert() {
        openPromptAlert();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(alertsModel.getPromptMessage());
        alert.accept();
        promptAlertMessage = getText(PROMPT_ALERT_MSG);
        System.out.println(promptAlertMessage);
    }


    public void openPracticeForm() {
        clickSelection(ALERTS_PRACTICE_LI);
    }

    private void openBasicAlert() {
        clickSelection(BUTTON_BASIC_ALERT);
    }

    private void openTimerAlert() {
        clickSelection(BUTTON_TIMER_ALERT);
    }

    private void openConfirmAlert() {
        clickSelection(BUTTON_CONFIRM_ALERT);
    }

    private void openPromptAlert() {
        clickSelection(BUTTON_PROMPT_ALERT);
    }

    public String getConfirmAlertMessage() {
        return confirmAlertMessage;
    }

    public AlertsModel getAlertsModel() {
        return alertsModel;
    }

    public String getPromptAlertMessage() {
        return promptAlertMessage;
    }

}
