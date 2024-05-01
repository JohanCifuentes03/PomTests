package co.com.sofka.page;

import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PageFactoryDatePicker extends CommonFunctions {

    // redirect form practice element
    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Date Picker']")
    private WebElement DATE_PRACTICE_LI;


    // open calendar
    @CacheLookup
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement CALENDAR_DATE_INPUT;


    // select month
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'month-read-view')]")
    private WebElement MONTHS_MENU;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'month-option')][text() = 'October']")
    private WebElement MONTH_OPTION;


    // select year
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'year-read-view')]")
    private WebElement YEAR_MENU;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'year-option')][text() = '2024']")
    private WebElement YEAR_OPTION;


    // select day
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'day--024')]")
    private WebElement DAY_OPTION;


    //select time
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'time-box')]")
    private WebElement TIME_BOX_DIV;

    @CacheLookup
    @FindBy(xpath = "//li[contains(@class,'time-list-item')][text() = '19:30']")
    private WebElement HOUR_OPTION;


    //Compare date value
    @CacheLookup
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement DATETIME_MSG;
    private String dateTime;


    public PageFactoryDatePicker(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectDateTime() {
        openCalendar();
        scrollTo(DATE_PRACTICE_LI);
        reserveMonth();
        reserveYear();
        reserveDay();
        reserveHour();
        dateTime = DATETIME_MSG.getAttribute("value");
    }

    private void reserveDay() {
        clickSelection(DAY_OPTION);
    }

    private void reserveHour() {
        goToHoursBox();
        goToHour();
        selectHour();
    }

    private void goToHoursBox() {
        WebElement hoverable = TIME_BOX_DIV;
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
    }

    private void goToHour() {
        scrollTo(HOUR_OPTION);
    }

    private void selectHour() {
        clickSelection(HOUR_OPTION);
    }
    private void reserveYear() {
        openYearOptions();
        selectYear();
    }

    private void openYearOptions() {
        clickSelection(YEAR_MENU);
    }

    private void selectYear() {
        Wait<WebDriver> wait = getWebDriverWait();
        WebElement yearOption = wait.until(ExpectedConditions.visibilityOf(YEAR_OPTION));
        yearOption.click();
    }

    private Wait<WebDriver> getWebDriverWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
    }

    private void reserveMonth() {
        openMonthOptions();
        selectMonth();
    }

    private void openCalendar() {
        clickSelection(CALENDAR_DATE_INPUT);
    }

    private void openMonthOptions() {
        clickSelection(MONTHS_MENU);
    }

    private void selectMonth() {
        Wait<WebDriver> wait = getWebDriverWait();
        WebElement monthOption = wait.until(ExpectedConditions.visibilityOf(MONTH_OPTION));
        monthOption.click();
    }


    public void openPracticeDatePicker() {
        clickSelection(DATE_PRACTICE_LI);
    }

    public String getDateTime() {
        return dateTime;
    }
}
