package co.com.sofka.page;

import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends CommonFunctions {
    private final By FORMS_DIV = By.xpath("//h5[text() = 'Forms']/ancestor::div[@class = 'card mt-4 top-card']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToFormPage(){
        driver.findElement(FORMS_DIV).click();
    }
}
