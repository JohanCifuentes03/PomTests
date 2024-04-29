package co.com.sofka.page;

import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderListPage extends CommonFunctions {
    private final By PRACTICE_SORTABLE_LI = By.xpath("//span[text() = 'Sortable']");

    public OrderListPage(WebDriver driver) {
        super(driver);
    }

    public void openSortableListSection() {
        driver.findElement(PRACTICE_SORTABLE_LI).click();
    }
}
