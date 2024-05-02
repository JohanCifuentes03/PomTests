package co.com.sofka.page;

import co.com.sofka.model.WebTableModel;
import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static co.com.sofka.util.ModelCreator.createWebTableModel;

public class PageFactoryWebTable extends CommonFunctions {


    // redirect web table practice element
    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Web Tables']")
    private WebElement PRACTICE_TABLE_LI;



    // Create
    private final WebTableModel createdTableModel = createWebTableModel();
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement CREATE_BTN;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement FIRSTNAME_FIELD;
    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement LASTNAME_FIELD;
    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement EMAIL_FIELD;
    @CacheLookup
    @FindBy(id = "age")
    private WebElement AGE_FIELD;
    @CacheLookup
    @FindBy(id = "salary")
    private WebElement SALARY_FIELD;
    @CacheLookup
    @FindBy(id = "department")
    private WebElement DEPARTMENT_FIELD;
    @CacheLookup
    @FindBy(id = "submit")
    private WebElement SUBMIT_BTN;



    // Search
    private final WebTableModel foundedTableModel = new WebTableModel();
    @CacheLookup
    @FindBy(id = "searchBox")
    private WebElement SEARCH_BOX_INPUT;
    private final String EMAIL_ELEMENTS = "//div[@role = 'rowgroup']//div[@class = 'rt-td'][4]";
    private final String FULL_USER_DATA = "//div[text() = '%s']/ancestor::div[@role = 'row']/div";


    public PageFactoryWebTable(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPracticeWebTable() {
        clickSelection(PRACTICE_TABLE_LI);
    }

    public void createUser(){
        openCreateForm();
        fillOutFormData();
        submitUserData();
    }

    private void openCreateForm() {
        clickSelection(CREATE_BTN);
    }

    private void fillOutFormData() {
        sendKeys(FIRSTNAME_FIELD, createdTableModel.getFirstName());
        sendKeys(LASTNAME_FIELD, createdTableModel.getLastName());
        sendKeys(AGE_FIELD, String.valueOf(createdTableModel.getAge()));
        sendKeys(EMAIL_FIELD, createdTableModel.getEmail());
        sendKeys(SALARY_FIELD, String.valueOf(createdTableModel.getSalary()));
        sendKeys(DEPARTMENT_FIELD, createdTableModel.getDepartment());
    }
    private void submitUserData() {
        clickSelection(SUBMIT_BTN);
    }

    private void setUserModelData(String locator){
        List<WebElement> userData = driver.findElements(By.xpath(locator));
        foundedTableModel.setFirstName(getText(userData.get(0)));
        foundedTableModel.setLastName(getText(userData.get(1)));
        foundedTableModel.setAge(Integer.parseInt(getText(userData.get(2))));
        foundedTableModel.setEmail(getText(userData.get(3)));
        foundedTableModel.setSalary(Integer.parseInt(getText(userData.get(4))));
        foundedTableModel.setDepartment(getText(userData.get(5)));
    }

    // Search
    public void searchForEmail(String email) {
        inputUserName(email);
        getUserSearch(email);
    }

    private void inputUserName(String email) {
        sendKeys(SEARCH_BOX_INPUT, email);

    }

    private void getUserSearch(String email) {
        List<WebElement> emailElements = driver.findElements(By.xpath(EMAIL_ELEMENTS));
        for (WebElement element : emailElements) {
            if (getText(element).equals(email)) {
                setUserModelData(String.format(FULL_USER_DATA, email));
            }
        }
    }

    public WebTableModel getCreatedTableModel() {
        return createdTableModel;
    }

    public WebTableModel getFoundedTableModel() {
        return foundedTableModel;
    }
}
