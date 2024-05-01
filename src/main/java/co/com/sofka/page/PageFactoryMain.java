package co.com.sofka.page;

import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryMain extends CommonFunctions {

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text() , 'Forms')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement FORMS_OPTION;
    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Interactions')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement INTERACTIONS_OPTION;
    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Alerts')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement ALERTS_OPTION;


    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Widgets')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement WIDGETS_OPTION;


    public PageFactoryMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToFormPage() {
        clickSelection(FORMS_OPTION);
    }

    public void navigateToInteractionsPage() {
        clickSelection(INTERACTIONS_OPTION);
    }

    public void navigateToAlertsPage() {
        clickSelection(ALERTS_OPTION);
    }

    public void navigateToWidgetsPage() {
        clickSelection(WIDGETS_OPTION);
    }

}
