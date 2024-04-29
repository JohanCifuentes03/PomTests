package co.com.sofka.page;

import co.com.sofka.model.FormModel;
import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static co.com.sofka.util.UserCreator.createUser;

public class FormPage extends CommonFunctions {
    public FormModel user = createUser();

    // Locators
    private final By PRACTICE_FORM_LI = By.xpath("//span[text() = 'Practice Form']");


    private final By NAME_FIELD = By.id("firstName");
    private final By LASTNAME_FIELD = By.id("lastName");
    private final By EMAIL_FIELD = By.id("userEmail");
    private final By NUMBER_FIELD = By.id("userNumber");
    private final By GENDER_OPTION = By.xpath("//input[@value='Male']/ancestor::div[@class ='custom-control custom-radio custom-control-inline']");
    private final By SUBJECT = By.xpath("//div[@class='subjects-auto-complete__input']");

    // Birthday
    private final By BIRTH_FIELD = By.id("dateOfBirthInput");
    private final By YEAR_SELECT = By.className("react-datepicker__year-select");
    private final By MONTH_SELECT = By.className("react-datepicker__month-select");
    private final By DAY_SELECT = By.xpath("//div[contains(@class, 'day--024')]");

    private final By HOBBIES_FIELD = By.xpath("//label[contains(text(), 'Sports')]");
    private final By ADDRESS_FIELD = By.id("currentAddress");

    // submit
    private final By SUBMIT_BTN = By.id("submit");

    // validate data card
    private final By THANKS_MESSAGE = By.id("example-modal-sizes-title-lg");

    private final By STUDENT_NAME = By.xpath("//tbody/tr[1]/td[2]");
    private final By STUDENT_EMAIL = By.xpath("//tbody/tr[2]/td[2]");
    private final By STUDENT_ADDRESS = By.xpath("//tbody/tr[9]/td[2]");

    public FormPage(WebDriver driver) {
        super(driver);
    }


    // Functions
    public void fillOutForm() {
        typeInto(NAME_FIELD, user.getName());
        typeInto(LASTNAME_FIELD, user.getLastName());
        typeInto(EMAIL_FIELD, user.getEmail());
        typeInto(ADDRESS_FIELD, user.getAddress());
        typeInto(NUMBER_FIELD, user.getMobileNumber());
        //sendKeys(SUBJECT, "Maths");
        clickSelection(GENDER_OPTION);
        selectDate();
        scrollTo(HOBBIES_FIELD);
        clickSelection(HOBBIES_FIELD);
    }

    public void selectDate() {

        clickSelection(BIRTH_FIELD);
        Select monthSelect = new Select(driver.findElement(MONTH_SELECT));
        monthSelect.selectByValue("9");

        Select yearSelect = new Select(driver.findElement(YEAR_SELECT));
        yearSelect.selectByValue("2003");

        clickSelection(DAY_SELECT);
    }

    public void submitForm() {
        scrollTo(SUBMIT_BTN);
        clickSelection(SUBMIT_BTN);
    }

    public void openPracticeForm() {
        driver.findElement(PRACTICE_FORM_LI).click();
    }

    public String getThanksMessage() {
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
