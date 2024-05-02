package co.com.sofka.page;

import co.com.sofka.model.FormModel;
import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static co.com.sofka.util.ModelCreator.createUser;

public class PageFactoryForm extends CommonFunctions {
    private final FormModel user = createUser();


    // redirect form practice element
    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Practice Form']")
    private WebElement PRACTICE_FORM_LI;


    // basic user data
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement NAME_FIELD;
    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement LAST_NAME_FIELD;
    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement EMAIL_FIELD;
    @CacheLookup
    @FindBy(id = "userNumber")
    private WebElement NUMBER_FIELD;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Male']/ancestor::div[contains(@class, 'custom-control')]")
    private WebElement GENDER_OPTION;
    @CacheLookup
    @FindBy(id = "subjectsInput")
    private WebElement SUBJECT_FIELD;


    // Date data
    @CacheLookup
    @FindBy(id = "dateOfBirthInput")
    private WebElement BIRTH_FIELD;
    @CacheLookup
    @FindBy(className = "react-datepicker__year-select")
    private WebElement YEAR_SELECT;
    @CacheLookup
    @FindBy(className = "react-datepicker__month-select")
    private WebElement MONTH_SELECT;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'day--024')]")
    private WebElement DAY_SELECT;


    // Hobbies and address data
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(), 'Sports')]")
    private WebElement HOBBIES_FIELD;
    @CacheLookup
    @FindBy(id = "currentAddress")
    private WebElement ADDRESS_FIELD;


    // City and state
    @CacheLookup
    @FindBy(id = "state")
    private WebElement STATE_FIELD;
    @CacheLookup
    @FindBy(xpath = "//div[text()='NCR']")
    private WebElement STATE_OPTION;
    @CacheLookup
    @FindBy(id = "city")
    private WebElement CITY_FIELD;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Gurgaon']")
    private WebElement CITY_OPTION;


    // Submit BTN
    @CacheLookup
    @FindBy(id = "submit")
    private WebElement SUBMIT_BTN;


    // Pop up confirmation data
    @CacheLookup
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement THANKS_MESSAGE;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement STUDENT_NAME;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement STUDENT_EMAIL;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[9]/td[2]")
    private WebElement STUDENT_ADDRESS;


    // Scroll objective element
    @CacheLookup
    @FindBy(id = "Ad.Plus-970x250-2")
    private WebElement SCROLL_OBJECTIVE;


    public PageFactoryForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillOutForm() {
        basicUserData();
        date();
        address();
    }

    private void basicUserData() {
        typeInto(NAME_FIELD, user.getName());
        typeInto(LAST_NAME_FIELD, user.getLastName());
        typeInto(EMAIL_FIELD, user.getEmail());
        typeInto(ADDRESS_FIELD, user.getAddress());
        typeInto(NUMBER_FIELD, user.getMobileNumber());
        typeInto(SUBJECT_FIELD, "Maths");
        SUBJECT_FIELD.sendKeys(Keys.ENTER);
        clickSelection(GENDER_OPTION);
    }

    private void address() {
        scrollTo(SCROLL_OBJECTIVE);
        clickSelection(STATE_FIELD);
        clickSelection(STATE_OPTION);
        clickSelection(CITY_FIELD);
        clickSelection(CITY_OPTION);
        clickSelection(HOBBIES_FIELD);
    }

    private void date() {
        scrollTo(SUBMIT_BTN);
        clickSelection(BIRTH_FIELD);
        Select monthSelect = new Select(MONTH_SELECT);
        monthSelect.selectByValue("9");
        Select yearSelect = new Select(YEAR_SELECT);
        yearSelect.selectByValue("2003");
        clickSelection(DAY_SELECT);
    }

    public void submitForm() {
        clickSelection(SUBMIT_BTN);
    }

    public void openPracticeForm() {
        clickSelection(PRACTICE_FORM_LI);
    }

    public String getThanksMessage() {
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        wait.until(ExpectedConditions.visibilityOf(THANKS_MESSAGE));
        return getText(THANKS_MESSAGE);
    }

    public String getStudentNameMessage() {
        return getText(STUDENT_NAME);
    }

    public String getStudentEmailMessage() {
        return getText(STUDENT_EMAIL);
    }

    public String getStudentAddressMessage() {
        return getText(STUDENT_ADDRESS);
    }

    public FormModel getUser() {
        return user;
    }
}
